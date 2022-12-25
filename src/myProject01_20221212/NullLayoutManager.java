package myProject01_20221212;

//*
// * Created on 2005. 4. 27.
// *
// * TODO To change the template for this generated file go to
// * Window - Preferences - Java - Code Style - Code Templates
// */
//
///**
// * @author DDosin
// *
// * TODO To change the template for this generated type comment go to
// * Window - Preferences - Java - Code Style - Code Templates
// */
//
///**
// * 자바에서 GUI 코딩할때 RED툴을 쓰지 않고 작업시에 레이아웃 관리하기 짜증나서 만든것
// * 기본적으로는 이 클래스만으로 레이아웃 관리가 가능하도록 구현 되어 있음
// * 내부적으로 null 레이아웃을 통해 구현되어 있음
// * 버그는 무자게 나올 수도 있음 ^^;; 
// * 특별히 상업용으로 만든것이 아니라서 많이 허접 할 수 있음 
// * 그래도 아이디어부터 구현까지 3시간 걸렸음 버그 테스트까지 좀 더 걸림
// * 
// * 레이아웃 관리자로 기본적으로 다른 레이아웃을 쓰지 않는다면 이것 하나만 가지고 조작이 가능
// * 최상위 컨테이너를 집어 넣고 보통은 JFrame
// * 시작값으로 픽셀값을 찍어주고 크기는 최초 컨테이너의 크기에서 퍼센트를 주면됨 
// * 50 이면 50% 란 뜻 
// * 예를 들어 addContainer(p1,0,0,50,25); 이면 
// * p1 컨테이너를 시작점 0, 0 에서 부모 컨테이너의 가로 크기 50% 세로 크기 25% 로 주면됨
// * 시작점은 나두고 퍼센트 값에 100 초과 값 주면 장담 못함.. ^^;;
// * 컴포넌트는 두종류임 리사이즈할것과 그냥 크기를 정적으로 할것 
// * addComponent 는 크기가 정적인것 시작값과 끝값이 모두 픽셀 값 
// * addComponentResize 는 시작값은 픽셀값 끝값은 페센트 값
// * 
// * 시작점은 상위 컨테이너의 값에 의존하지 화면 픽셀값과는 상관 없음
// * 즉 절대값이 아니라 상대적인값 상위 컨테이너의 위치가 변하면 같이 변함  
// * 
// * 주의 scrollpane 컨테이너로 취급 하지 말고 컴포넌트로 취급하면서 작업
// 
//

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class NullLayoutManager implements ComponentListener
{
	private Container c;	// 최상위 컨테이너 필수
	private Hashtable components;	// 리사이즈가 필요한 컴포넌트들을 유지
	private Hashtable containers;	// 컨테이너 목록을 유지
//	 사용자에 의해 ComponentListener 재구현이 필요한 경우를 위해 디스패치 하기 위해서 
	private ComponentListener listener;	

	// 생성자로 최상위 컨테이너와 최상위 컨테이너의 크기값 결정및 사용자가  ComponentListener 재정의 할때 필요한 
	public NullLayoutManager(Container c, int sizeX, int sizeY,ComponentListener listener)
	{
		this. c = c;
		components = new Hashtable();
		containers = new Hashtable();
		c.setLayout(null);
		c.addComponentListener(this);
		c.setSize(sizeX,sizeY);
		
		this.listener = listener;
	}
	
	// 생성자로 최상위 컨테이너와 최상위 컨테이너의 크기값 결정
	public NullLayoutManager(Container c, int sizeX, int sizeY)
	{
		this. c = c;
		components = new Hashtable();
		containers = new Hashtable();
		c.setLayout(null);
		c.addComponentListener(this);
		c.setSize(sizeX,sizeY);
	}
	
	// 최상위 컨테이너에 컴포넌트를 add 하는 것으로 x,y 는 시작점 width ,height 는 끝점  
	public void addComponent(Component comp, int x, int y, int width, int height)
	{
		comp.setBounds(x,y,width,height);
		c.add(comp);		
	}

	// 최상위 컨테이너에 컴포넌트를 add 하는 것으로 x,y 는 시작점 widthPer ,heightPer 는 컴포넌트이 크기 페센트값
	// 상위 컨테이너의 크기가 변하면 컴포넌트도 자동으로 리사이즈됨 
	public void addComponentResize(Component comp, int x, int y, int widthPer, int heightPer)
	{
		Dimension d = c.getSize();
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		comp.setBounds(x,y,sizeWidth,sizeHeight);
		c.add(comp);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		components.put(comp,p);
		//c.validate();
	}

	// parent 컨테이너에 컴포넌트를 add 하는 것으로 x,y 는 시작점 width ,height 는 끝점 
	public void addComponent(Container parent,Component comp, int x, int y, int width, int height)
	{
		comp.setBounds(x,y,width,height);
		parent.add(comp);
		
	}
	

	// parent 컨테이너에 컴포넌트를 add 하는 것으로 x,y 는 시작점 widthPer ,heightPer 는 컴포넌트이 크기 페센트값
	// parent 컨테이너의 크기가 변하면 컴포넌트도 자동으로 리사이즈됨 
	public void addComponentResize(Container parent,Component comp, int x, int y, int widthPer, int heightPer)
	{
		Dimension d = c.getSize();
		
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		comp.setBounds(x,y,sizeWidth,sizeHeight);
		parent.add(comp);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		components.put(comp,p);
	}
	
	// 최상위 컨테이너에 child 컨테이너를 add 하는 것으로  x,y 는 시작점 widthPer ,heightPer 는 컴포넌트이 크기 페센트값
	public void addContainer(Container child, int x, int y, int widthPer, int heightPer)
	{
		Dimension d = c.getSize();
		child.setLayout(null);
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		child.setBounds(x,y,sizeWidth,sizeHeight);
		c.add(child);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		containers.put(child,p);
	}
	
	// 최상위 컨테이너에 child 컨테이너를 add 하는 것으로  x,y 는 시작점 widthPer ,heightPer 는 컴포넌트이 크기 페센트값
	// parent 컨테이너의 크기가 변하면 child 컨테이너도 자동으로 리사이즈됨 
	public void addContainer(Container parent, Container child, int x, int y, int widthPer, int heightPer)
	{
		
		child.setLayout(null);
		Dimension d = c.getSize();
		
		//System.out.println(d);
		
		int width = (int)d.getWidth();
		int height = (int)d.getHeight();

		int sizeWidth = width*widthPer/100;
		int sizeHeight = height*heightPer/100;
	//	System.out.println(" "+sizeWidth+" "+sizeHeight);
		child.setBounds(x,y,sizeWidth,sizeHeight);
		parent.add(child);
		
		if(x<1)
			x=1;
		if(y<1)
			y=1;
		if(width < 1)
			width =1;
		if(height < 1)
			height =1;
		
		
		int startX = (x*100)/width;
		int startY = (y*100)/height;
		PointEx p = new PointEx(startX, startY,widthPer, heightPer);
		
		containers.put(child,p);
	}

	//
	// 인터페이스 ComponentListener 상속 받아 재 정의 해놓은 메소드
	//
	public void componentResized(ComponentEvent e)
	{
		
		
		Enumeration<Container> test = containers.keys();
		
		while(test.hasMoreElements())
		{
			Container c = (Container)test.nextElement();
			PointEx p = (PointEx)containers.get(c);
			
			//System.out.println(p);
			
			Container parent = c.getParent();
			
			Dimension d = parent.getSize();
			int width = (int)d.getWidth();
			int height = (int)d.getHeight();
			
			int x = (p.x * width)/100;
			int y = (p.y * height)/100;
			
			int sizeX = (p.width * width)/100;
			int sizeY = (p.height * height)/100;
			
			//System.out.print("startX "+x+" startY "+y);

			//System.out.println(" width "+sizeX+" height "+sizeY);
			c.setLocation(x,y);
			c.setSize(sizeX,sizeY);
			
			//c.repaint();
			
		}
		
		Enumeration enumCom = components.keys();
		
		while(enumCom.hasMoreElements())
		{
			Component com = (Component)enumCom.nextElement();
			PointEx p = (PointEx)components.get(com);
			
			//System.out.println(p);
			
			Container parent = com.getParent();
			Dimension d = parent.getSize();
			int width = (int)d.getWidth();
			int height = (int)d.getHeight();
			int x = (p.x * width)/100;
			int y = (p.y * height)/100;
			int sizeX = (p.width * width)/100;
			int sizeY = (p.height * height)/100;
			//System.out.print("startX "+x+" startY "+y);

			//System.out.println(" width "+sizeX+" height "+sizeY);
			com.setLocation(x,y);
			com.setSize(sizeX,sizeY);
			
		}
			
		c.validate();
		
	}

	public void componentMoved(ComponentEvent e)
	{
		if(listener != null)
		{
			listener.componentMoved(e);
		}
	}	
	public void componentShown(ComponentEvent e)
	{
		if(listener != null)
		{
			listener.componentShown(e);
		}
	}
	public void componentHidden(ComponentEvent e)
	{
		if(listener != null)
		{
			listener.componentHidden(e);
		}
	}
	
	
		// 메인은 테스트 용임 신경 쓸필요 없음 
	public static void main(String[] args) 
	{
		Frame f = new Frame("test");
		NullLayoutManager aa = new NullLayoutManager(f,500,500);

		Button b1 = new Button("button resize");
		Button b2 = new Button("button static");
		//Button b3 = new Button("button frame");
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
	//	NullLayoutManager aa1 = new NullLayoutManager(p3,500,500);
		p1.setBackground(Color.black);
		p2.setBackground(Color.BLUE);
		p3.setBackground(Color.GRAY);
		
		aa.addContainer(p1,0,0,50,50);
		aa.addContainer(p2,250,0,50,50);
		aa.addContainer(p3,0,250,100,50);
		
		aa.addComponent(p3,b2,20,20,100,20);
		aa.addComponentResize(p3,b1,150,20,30,20);

		f.show();
	}
	
		// 내부 클래스로 시작점과 끝점을 보관하기 위해 필요 
	class PointEx
	{
		int x;
		int y;
		int width;
		int height;
	
		public PointEx(int x, int y, int width, int height)
		{
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			
		}
		
		public String toString()
		{
			return new String("x-"+x+" y-"+y+" width-"+width+" height-"+height);
		}
	}
	
	
}
