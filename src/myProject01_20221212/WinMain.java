package myProject01_20221212;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class WinMain extends JFrame {

	private JPanel contentPane;
	JPanel panelHead;
	Dimension size;
	int x,y;
	int srow=9999999;
	int row4;
	int row=9999999;
	JButton btnWrite;
	JTabbedPane tabbedPane;
	DefaultTableModel dtm6;
	DefaultTableModel dtm5;
	DefaultTableModel dtm4;
	DefaultTableModel dtm3;
	DefaultTableModel dtm2;
	DefaultTableModel dtm1;
	private JTable table1;
	private JTable table2;
	private JTextField tfSearch;
	JTextField lblSPNum;
	JTextField lblSPName;
	JTextField lblSPPrice;
	JTextField lblSPSize;
	private JTextField tfSUser;
	JOptionPane aa;
	int psu;
	int ssu;
	private JTextField tfPUser;
	private JTextField tfPSize;
	private JTextField tfPPrice;
	private JTextField tfPName;
	private JTextField tfPImage;
	private JTable table3;
	TableColumnModel tcm1;
	TableColumnModel tcm2;
	TableColumnModel tcm3;
	TableColumnModel tcm4;
	TableColumnModel tcm5;
	TableColumnModel tcm6;
	DefaultTableCellRenderer dtcr;
	JScrollPane scrollPane1;
	JScrollPane scrollPane2;
	JScrollPane scrollPane3;
	JScrollPane scrollPane4;
	JScrollPane scrollPane5_1;
	JScrollPane scrollPane5_2;
	JPanel panel1;
	JPanel panel1_1;
	JPanel panel1_2;
	JPanel panel2;
	JPanel panel2_1;
	JPanel panel3;
	JPanel panel3_1;
	JPanel panel4_1;
	int shownum;
	private JTextField textField_3;
	private JTextField lblNewLabel_5;
	private JTextField textField_2;
	String pnum;
	private String pname;
	private String pprice;
	private String psize;
	private String puser;
	private String pdate;
	private int sellFlag;
	private JTable table4;
	private int opnum;
	private int onum;
	int sd=9999999;
	private String opcount;
	private JTable table5;
	private JTable table6;
	private int cnt;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinMain frame = new WinMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinMain() {

		
		setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				ShowSAll();
				ShowOAll();
				ShowDMAll();
				ShowHMAll();
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				size = contentPane.getSize();
				x = size.width;
				y = size.height;
				int x2=x*4/5;
				int x3=x/5;
				panelHead.setSize(x, 28);
				
//				if(x>1500) {
//					x=1500;
//				}	
//				if(y>700) {
//					y=700;
//				}
				// 사이즈 조절
				tabbedPane.setBounds(0, 28, x, y);
				scrollPane1.setSize(800,440);
				scrollPane2.setSize(800,470);
				scrollPane3.setSize(800,470);
				scrollPane4.setSize(800,470);
				
				scrollPane5_1.setBounds(12, 120, x/2-19, y-186);
				scrollPane5_2.setBounds(5+x/2, 120, x/2-19, y-186);
				Dimension sp1size = scrollPane1.getSize();
				int sp1x = sp1size.width;
				int sp1y = sp1size.height;
				
				Dimension sp2size = scrollPane2.getSize();
				int sp2x = sp2size.width;
				int sp2y = sp2size.height;
				
				lblNewLabel_8.setBounds(x/2-152, 10, 300, 88);
				lblNewLabel_9.setBounds(12, 100, 68, 15);
				lblNewLabel_10.setBounds(5+x/2, 100, 68, 15);
				btnWrite.setBounds(x-110, 93, 97, 23);
				
				panel1_1.setBounds(sp2x+25, 10, 250, 350);
				panel1_2.setBounds(12, sp1y+20, 800, 30);
				panel2_1.setBounds(sp2x+25, 10, 250, 350);
				panel3_1.setBounds(sp2x+25, 10, 250, 350);
				panel4_1.setBounds(sp2x+25, 10, 250, 350);
				
				lblNewLabel_5.setBounds(699, 4, 97, 23);
				textField_2.setBounds(620, 4, 47, 23);
			}
		});
		
		
		setTitle("SinBalJang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 217));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// 프레임 크기
		Dimension frameSize = getSize();
		// 모니터 크기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 모니터 중앙에 프레임 띄우기
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHead = new JPanel();
		panelHead.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), new Color(255, 102, 98), null, null));
		panelHead.setBackground(new Color(255, 202, 200));
		panelHead.setBounds(0, 0, 875, 27);
		contentPane.add(panelHead);
		panelHead.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SinBalJang 판매관리");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(5, 0, 131, 27);
		panelHead.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("매장명 : ");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_1.setBounds(160, 6, 71, 15);
		panelHead.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MINI 지점");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNewLabel_2.setBounds(216, 6, 167, 15);
		panelHead.add(lblNewLabel_2);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(0, 28, 875, 500);
		contentPane.add(tabbedPane);
		
		
		
		String columnNames1[] = {"번호","판매일시","제품번호","제품명","사이즈", "판매자","수량", "가격"};
		dtm1 = new DefaultTableModel(columnNames1,0) {
			public boolean isCellEditable(int row, int column) { // 셀 수정 불가능
			       //all cells false
			       return false;
			    }
		};
		
		panel1 = new JPanel();
		tabbedPane.addTab("판매현황", null, panel1, null);
		panel1.setLayout(null);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(12, 10, 560, 402);
		panel1.add(scrollPane1);
		
		table1 = new JTable(dtm1);
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1) {
						srow = table1.getSelectedRow();
					}
			}
			});
		scrollPane1.setViewportView(table1);
		
		panel1_1 = new JPanel();
		panel1_1.setLayout(null);
		panel1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		panel1_1.setBackground(SystemColor.menu);
		panel1_1.setBounds(584, 10, 242, 330);
		panel1.add(panel1_1);
		
		JButton btnSDelete = new JButton("삭제");
		btnSDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnSDelete.setBackground(new Color(255, 255, 255));
		btnSDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SellDeldete();
					ShowSAll();
				} catch (Exception e1) {
					aa.showMessageDialog(null, "판매현황을 선택 해주세요.");
					}
			}
		});
		btnSDelete.setBounds(120, 276, 110, 44);
		panel1_1.add(btnSDelete);
		
		panel1_2 = new JPanel();
		panel1_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		panel1_2.setBounds(12, 422, 560, 24);
		panel1.add(panel1_2);
		panel1_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("   \uD569\uACC4 \u25B6");
		lblNewLabel_4.setBounds(0, 6, 52, 17);
		panel1_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		lblNewLabel_5 = new JTextField();
		lblNewLabel_5.setEditable(false);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(508, 0, 52, 21);
		panel1_2.add(lblNewLabel_5);
		lblNewLabel_5.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(445, 0, 52, 21);
		panel1_2.add(textField_2);
		
		
		textField_3 = new JTextField("");
		textField_3.setOpaque(true);
		textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(66, 127, 164, 21);
		
		
		// 테이블 내용 정렬 
		dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		tcm1 = table1.getColumnModel();
		tcm1.getColumn(0).setCellRenderer(dtcr);
		tcm1.getColumn(1).setCellRenderer(dtcr);
		tcm1.getColumn(2).setCellRenderer(dtcr);
		tcm1.getColumn(3).setCellRenderer(dtcr);
		tcm1.getColumn(4).setCellRenderer(dtcr);
		tcm1.getColumn(5).setCellRenderer(dtcr);
		tcm1.getColumn(6).setCellRenderer(dtcr);
		tcm1.getColumn(7).setCellRenderer(dtcr);
		
		// 셀 너비 조절
		int widths[] = {10,90,35,40,40,5,20};
		for(int i=0;i<7;i++) {
			TableColumn column = table1.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths[i]);
		}
		
		panel2 = new JPanel();
		tabbedPane.addTab("재고검색", null, panel2, null);
		panel2.setLayout(null);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(12, 10, 590, 411);
		panel2.add(scrollPane2);
		
		String columnNames2[] = {"제품번호","제품명", "가격", "사이즈", "등록자","등록일"};
		dtm2 = new DefaultTableModel(columnNames2,0) {
		@Override
	    public boolean isCellEditable(int row, int column) { // 셀 수정 불가능
	       //all cells false
	       return false;
	    }
		};
		
		String columnNames4[] = {"주문번호","제품번호", "수량", "주문자", "주문일","주문자번호","재고현황","상태"};
		dtm4 = new DefaultTableModel(columnNames4,0) {
		@Override
	    public boolean isCellEditable(int row, int column) { // 셀 수정 불가능
	       //all cells false
	       return false;
	    }
		};
		
		dtm3 = new DefaultTableModel(columnNames2,0) {
			@Override
		    public boolean isCellEditable(int row, int column) { // 셀 수정 불가능
		       //all cells false
		       return false;
		    }
			};
		
			String columnNames5[] = {"번호","일시","제목","작성자"};
			dtm5 = new DefaultTableModel(columnNames5,0) {
			@Override
		    public boolean isCellEditable(int row, int column) { // 셀 수정 불가능
		       //all cells false
		       return false;
		    }
			};
			
			String columnNames6[] = {"번호","일시","제목","작성자"};
			dtm6 = new DefaultTableModel(columnNames6,0) {
			@Override
		    public boolean isCellEditable(int row, int column) { // 셀 수정 불가능
		       //all cells false
		       return false;
		    }
			};
			
		table2 = new JTable(dtm2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1) {
					int column = table2.getSelectedColumn();
					row = table2.getSelectedRow();
					List<String> value = new ArrayList<String>();
					for(int i=0;i<table2.getColumnCount();i++) {
						value.add(i,(String) table2.getValueAt(row, i));
					}
					
					lblSPName.setText(value.get(1));
					lblSPNum.setText(value.get(0));
					lblSPPrice.setText(value.get(2));
					lblSPSize.setText(value.get(3));
					
				}
			}
		});
		scrollPane2.setViewportView(table2);
		//
		tcm2 = table2.getColumnModel();
		for(int i = 0 ; i < tcm2.getColumnCount() ; i++){
		tcm2.getColumn(i).setCellRenderer(dtcr);
		}
		
		
		//
		panel2_1 = new JPanel();
		panel2_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		panel2_1.setBackground(UIManager.getColor("Button.background"));
		panel2_1.setBounds(614, 21, 242, 411);
		panel2.add(panel2_1);
		panel2_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uC81C\uD488\uBC88\uD638:");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(12, 82, 57, 28);
		panel2_1.add(lblNewLabel_3);
		
		lblSPNum = new JTextField("");
		lblSPNum.setBackground(new Color(255, 255, 255));
		lblSPNum.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblSPNum.setBounds(66, 89, 164, 21);
		lblSPNum.setOpaque(true);
		panel2_1.add(lblSPNum);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uC81C\uD488\uBA85:");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(12, 120, 57, 28);
		panel2_1.add(lblNewLabel_3_1);
		
		lblSPName = new JTextField("");
		lblSPName.setBackground(new Color(255, 255, 255));
		lblSPName.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblSPName.setBounds(66, 127, 164, 21);
		lblSPName.setOpaque(true);
		panel2_1.add(lblSPName);
		
		JLabel lblNewLabel_3_2 = new JLabel("\uD310\uB9E4\uAC00\uACA9:");
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(12, 158, 57, 28);
		panel2_1.add(lblNewLabel_3_2);
		
		lblSPPrice = new JTextField("");
		lblSPPrice.setBackground(new Color(255, 255, 255));
		lblSPPrice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblSPPrice.setBounds(66, 165, 164, 21);
		lblSPPrice.setOpaque(true);
		panel2_1.add(lblSPPrice);
		
		JLabel lblNewLabel_3_3 = new JLabel("\uC0AC\uC774\uC988:");
		lblNewLabel_3_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(12, 196, 57, 28);
		panel2_1.add(lblNewLabel_3_3);
		
		lblSPSize = new JTextField("");
		lblSPSize.setBackground(new Color(255, 255, 255));
		lblSPSize.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblSPSize.setBounds(66, 203, 164, 21);
		lblSPSize.setOpaque(true);
		panel2_1.add(lblSPSize);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("\uC81C\uD488\uBA85:");
		lblNewLabel_3_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(12, 10, 57, 28);
		panel2_1.add(lblNewLabel_3_1_1);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(56, 15, 116, 23);
		panel2_1.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSearch();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_1.setBounds(173, 15, 60, 23);
		panel2_1.add(btnNewButton_1);
		
		JButton btnSInsert = new JButton("판매");
		btnSInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnSInsert.setBackground(new Color(255, 255, 255));
		btnSInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!tfPName.equals(null)) {
					try {
						shownum = Integer.parseInt(table2.getValueAt(row, 0).toString());
						sellItem();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						aa.showMessageDialog(null, "제품을 선택 해주세요.");
						}
				 // 물품 판매
				lblSPName.setText("");
				lblSPNum.setText("");
				lblSPPrice.setText("");
				lblSPSize.setText("");
				tfSUser.setText("안희권");
				}
				
			} 
		});
		btnSInsert.setBounds(12, 295, 106, 39);
		panel2_1.add(btnSInsert);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("\uD310\uB9E4\uC790:");
		lblNewLabel_3_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_3_1.setBounds(12, 234, 57, 28);
		panel2_1.add(lblNewLabel_3_3_1);
		
		tfSUser = new JTextField();
		tfSUser.setText("\uC548\uD76C\uAD8C");
		tfSUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnSInsert.doClick();
				}
			}
		});
		tfSUser.setBounds(66, 240, 106, 21);
		panel2_1.add(tfSUser);
		tfSUser.setColumns(10);
		
		JButton btnSInsert_1 = new JButton("삭제");
		btnSInsert_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					row=table2.getSelectedRow();
					PDelete();
					PSearch();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					aa.showMessageDialog(null, "제품을 선택 해주세요.");
					}
				
			}
		});
		btnSInsert_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnSInsert_1.setBackground(Color.WHITE);
		btnSInsert_1.setBounds(124, 295, 106, 39);
		panel2_1.add(btnSInsert_1);
		
		JLabel lblNewLabel_6 = new JLabel("(\uBE48\uCE78\uC73C\uB85C \uAC80\uC0C9\uC2DC \uBAA8\uB4E0\uBB3C\uD488 \uD655\uC778)");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(44, 37, 186, 21);
		panel2_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("(\uC67C\uCABD\uC5D0\uC11C \uBB3C\uD488 \uD558\uB098\uB97C \uC120\uD0DD\uD6C4 \uBC84\uD2BC\uD074\uB9AD)");
		lblNewLabel_6_1.setBounds(12, 264, 218, 21);
		panel2_1.add(lblNewLabel_6_1);
		lblNewLabel_6_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		ShowProductAll();
		
		panel3 = new JPanel();
		tabbedPane.addTab("재고등록", null, panel3, null);
		panel3.setLayout(null);
		
		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(12, 10, 478, 447);
		panel3.add(scrollPane3);
		
		table3 = new JTable(dtm3);
		scrollPane3.setViewportView(table3);
		
		panel3_1 = new JPanel();
		panel3_1.setLayout(null);
		panel3_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		panel3_1.setBackground(SystemColor.menu);
		panel3_1.setBounds(502, 10, 242, 411);
		panel3.add(panel3_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("\uC81C\uD488\uBA85:");
		lblNewLabel_3_1_2.setBounds(12, 10, 57, 28);
		panel3_1.add(lblNewLabel_3_1_2);
		lblNewLabel_3_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		tfPName = new JTextField();
		tfPName.setBounds(66, 16, 125, 21);
		panel3_1.add(tfPName);
		tfPName.setColumns(10);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("\uD310\uB9E4\uAC00\uACA9:");
		lblNewLabel_3_2_1.setBounds(12, 48, 57, 28);
		panel3_1.add(lblNewLabel_3_2_1);
		lblNewLabel_3_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		tfPPrice = new JTextField();
		tfPPrice.setBounds(85, 54, 106, 21);
		panel3_1.add(tfPPrice);
		tfPPrice.setColumns(10);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("\uC0AC\uC774\uC988:");
		lblNewLabel_3_3_2.setBounds(12, 86, 57, 28);
		panel3_1.add(lblNewLabel_3_3_2);
		lblNewLabel_3_3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		tfPSize = new JTextField();
		tfPSize.setBounds(85, 92, 106, 21);
		panel3_1.add(tfPSize);
		tfPSize.setColumns(10);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("\uB4F1\uB85D\uC790:");
		lblNewLabel_3_3_1_1.setBounds(12, 124, 57, 28);
		panel3_1.add(lblNewLabel_3_3_1_1);
		lblNewLabel_3_3_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		tfPUser = new JTextField();
		tfPUser.setBounds(85, 130, 106, 21);
		panel3_1.add(tfPUser);
		tfPUser.setColumns(10);
		
		JLabel lblNewLabel_3_3_1_1_1 = new JLabel("\uC0AC\uC9C4:");
		lblNewLabel_3_3_1_1_1.setBounds(12, 162, 57, 28);
		panel3_1.add(lblNewLabel_3_3_1_1_1);
		lblNewLabel_3_3_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		tfPImage = new JTextField();
		tfPImage.setBounds(85, 168, 106, 21);
		panel3_1.add(tfPImage);
		tfPImage.setText("\uBBF8\uAD6C\uD604");
		tfPImage.setColumns(10);
		
		JButton btnPInsert = new JButton("재고등록");
		btnPInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnPInsert.setBackground(new Color(255, 255, 255));
		btnPInsert.setBounds(60, 283, 116, 39);
		panel3_1.add(btnPInsert);
		btnPInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					productInsert();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					aa.showMessageDialog(null, "다시 시도해주세요.2");
					}
				
			}
		});
		
		tcm3 = table3.getColumnModel();
		for(int i = 0 ; i < tcm3.getColumnCount() ; i++){
		tcm3.getColumn(i).setCellRenderer(dtcr);
		}
		
//		try{
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        //원래 자바 고유의 룩앤필을 쓰는데 이것을 사용할 경우 자신의 오에스의 룩앤필을 사용하게 된다.
//    }catch(Exception e) {
//        e.printStackTrace();
//    	}	
		tabbedPane.setUI(new UI());
		tabbedPane.setFont(new Font("맑은 고딕", Font.BOLD,13));
		
		JPanel panel4 = new JPanel();
		panel4.setLayout(null);
		tabbedPane.addTab("주문 목록", null, panel4, null);
		scrollPane4 = new JScrollPane();
		scrollPane4.setBounds(12, 10, 560, 402);
		panel4.add(scrollPane4);
		
		table4 = new JTable(dtm4);
		scrollPane4.setViewportView(table4);
		
		tcm4 = table4.getColumnModel();
		for(int i = 0 ; i < tcm4.getColumnCount() ; i++){
		tcm4.getColumn(i).setCellRenderer(dtcr);
		}
		// 테이블4 셀 너비 조절
		int widths4[] = {10,40,35,40,40,5,20,40};
		for(int i=0;i<7;i++) {
			TableColumn column = table4.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths4[i]);
		}
		
		panel4_1 = new JPanel();
		panel4_1.setLayout(null);
		panel4_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		panel4_1.setBackground(SystemColor.menu);
		panel4_1.setBounds(584, 10, 242, 330);
		panel4.add(panel4_1);
		
		JButton btnOInsert = new JButton("판매");
		btnOInsert.addActionListener(new ActionListener() {
			private String con;

			public void actionPerformed(ActionEvent e) {
				try {
					pnum="0";
					opcount = "재고없음";
					row4 = table4.getSelectedRow();
					con = (String) table4.getValueAt(row4, 6);
					shownum = Integer.parseInt(table4.getValueAt(row4, 1).toString());
					showitem();
					if(pnum.equals("0")) {
						aa.showMessageDialog(null, "해당 재고가 없습니다.");
					} else {
						ConUpdate();
						ShowOAll();
					}
					
				} catch (Exception e2) {
					aa.showMessageDialog(null, "주문을 선택 해주세요.");
				}
			}
		});
		btnOInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnOInsert.setBackground(Color.WHITE);
		btnOInsert.setBounds(12, 281, 106, 39);
		panel4_1.add(btnOInsert);
		
		JButton btnODelete = new JButton("취소");
		btnODelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnum="0";
				row4 = table4.getSelectedRow();
				try {
					ConUpdate2();
					ShowOAll();
				} catch (Exception e2) {
					aa.showMessageDialog(null, "주문을 선택 해주세요.");
				}
				
			}
		});
		btnODelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnODelete.setBackground(Color.WHITE);
		btnODelete.setBounds(124, 281, 106, 39);
		panel4_1.add(btnODelete);
		
		JPanel panel5 = new JPanel();
		panel5.setLayout(null);
		tabbedPane.addTab("게시판", null, panel5, null);
		
		scrollPane5_1 = new JScrollPane();
		scrollPane5_1.setBounds(12, 127, 421, 330);
		panel5.add(scrollPane5_1);
		
		table5 = new JTable(dtm5);
		scrollPane5_1.setViewportView(table5);
		
		tcm5 = table5.getColumnModel();
		tcm5.getColumn(0).setCellRenderer(dtcr);
		tcm5.getColumn(1).setCellRenderer(dtcr);
		tcm5.getColumn(3).setCellRenderer(dtcr);
		
		scrollPane5_2 = new JScrollPane();
		scrollPane5_2.setBounds(445, 127, 413, 330);
		panel5.add(scrollPane5_2);
		
		table6 = new JTable(dtm6);
		scrollPane5_2.setViewportView(table6);
		
		lblNewLabel_8 = new JLabel("\uAC8C\uC2DC\uD310");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(287, 10, 301, 88);
		panel5.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("\uBCF8\uC0AC \u25B6 \uB9E4\uC7A5");
		lblNewLabel_9.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(12, 108, 68, 15);
		panel5.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("\uB9E4\uC7A5 \u25B6 \uB9E4\uC7A5");
		lblNewLabel_10.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(445, 108, 68, 15);
		panel5.add(lblNewLabel_10);
		
		btnWrite = new JButton("글 쓰기");
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DmInsert();
			}
		});
		btnWrite.setBackground(new Color(255, 255, 255));
		btnWrite.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnWrite.setBounds(761, 94, 97, 23);
		panel5.add(btnWrite);
//		lblNewLabel_3_5.setIcon(new ImageIcon("D:\\AHG\\image\\hollydick - 복사본.jpg"));
		
		tcm6 = table6.getColumnModel();
		tcm6.getColumn(0).setCellRenderer(dtcr);
		tcm6.getColumn(1).setCellRenderer(dtcr);
		tcm6.getColumn(3).setCellRenderer(dtcr);
		// 셀 너비 조절
		int widths5[] = {10,130,250,60};
		for(int i=0;i<4;i++) {
			TableColumn column = table5.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths5[i]);
		}
		
		for(int i=0;i<4;i++) {
			TableColumn column = table6.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths5[i]);
		}
		

//		NullLayoutManager aa = new NullLayoutManager(contentPane,634,300);
//		aa.addContainer(contentPane,tabbedPane,50, 50, 30, 30);

//		aa.addContainer(panel, 0, 0, 100,6);

	}

protected void DmInsert() {
		// TODO Auto-generated method stub
		WinDmInsert winDmInsert = new WinDmInsert();
		winDmInsert.setVisible(true);
	}

protected void ShowHMAll() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();			
		String sql = "";
		sql = "SELECT * FROM hmtbl ORDER BY hmdate DESC";
		ResultSet rs = stmt.executeQuery(sql);
		String record[] = new String[4];
		dtm5 = (DefaultTableModel)table5.getModel();
		dtm5.setRowCount(0);
		cnt=0;
		while(rs.next()) {
			record[0] = Integer.toString(++cnt);
			record[1] = rs.getString("hmdate");
			record[2] = rs.getString("hmtitle");
			record[3] = rs.getString("hmwriter");
			dtm5.addRow(record);
		}
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void ShowDMAll() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();			
		String sql = "";
		sql = "SELECT * FROM dmtbl ORDER BY dmdate DESC";
		ResultSet rs = stmt.executeQuery(sql);
		String record[] = new String[4];
		dtm6 = (DefaultTableModel)table6.getModel();
		dtm6.setRowCount(0);
		cnt=0;
		while(rs.next()) {
			record[0] = Integer.toString(++cnt);
			record[1] = rs.getString("dmdate");
			record[2] = rs.getString("dmtitle");
			record[3] = rs.getString("dmwriter");
			dtm6.addRow(record);
		}
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void ConUpdate() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		onum = Integer.parseInt(table4.getValueAt(row4, 0).toString());
		Statement stmt = con.createStatement();			
		String sql = "";
		String situation = table4.getValueAt(row4, 7).toString();
		if(!situation.equals("완료")) {
			sql = "UPDATE ordertbl SET ocon = '2' WHERE onum="+onum;
		int conFlag = stmt.executeUpdate(sql);
		if(conFlag>0) {
			aa.showMessageDialog(null, "판매완료");
		}
		} else {
			aa.showMessageDialog(null, "이미 판매가 완료된 제품 입니다.");
		}
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void ConUpdate2() {
	// TODO Auto-generated method stub
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
	String user = "system";
	String password = "1234";
	Connection con = DriverManager.getConnection(url, user, password);
	onum = Integer.parseInt(table4.getValueAt(row4, 0).toString());
	Statement stmt = con.createStatement();			
	String sql = "";
	sql = "UPDATE ordertbl SET ocon = '1' WHERE onum="+onum;
	stmt.execute(sql);
} catch (ClassNotFoundException | SQLException e1) {
	e1.printStackTrace();
}
}

protected void ShowOAll() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();			
		String sql = "";
		sql = "select * from orderTBL ORDER BY onum ASC";
		ResultSet rs = stmt.executeQuery(sql);
		String record[] = new String[8];
		DefaultTableModel dtm = (DefaultTableModel)table4.getModel();
		dtm.setRowCount(0);
		while(rs.next()) {
			pnum="0";
			shownum=Integer.parseInt(rs.getString("opnum"));
			showitem();
			record[0] = rs.getString("onum");
			record[1] = rs.getString("opnum");
			record[2] = rs.getString("ocount");
			record[3] = rs.getString("omname");
			record[4] = rs.getString("odate");
			record[5] = rs.getString("omtel");
			if(rs.getString("ocon").equals("1")) {
			record[7] = "대기중";
			} else if(rs.getString("ocon").equals("2")) {
			record[7] = "완료";
			}
			if(pnum.equals("0")) {
				record[6] = "재고없음";
			} else {
				record[6] = "재고있음";
			}
			dtm.addRow(record);
		}
		
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void aa() {
		// TODO Auto-generated method stub
	
	// 물품 등록 더미데이터 생성
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "";
		for(int i=0;i<=100;i++) {
			String pname="gstest"+i;
			String psize="240";
			String pprice="30000";
			String pdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 날짜
			String puser="안희권";
			String pimage="이미지 없음";
			sql = "INSERT INTO producttbl VALUES(product_SEQ.nextval,'"+pname+"',"+pprice+","+psize+",'"+puser+"','"+pdate+"','"+pimage+"')";
			int iItem = stmt.executeUpdate(sql);
			if(iItem>=1) {
				System.out.println("재고등록 성공");
				ShowProductAll();
			} else {
				System.out.println("재고등록 실패");
		}
		}
		
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void PSearch() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();			
		String sql = "";
		sql = "select * from productTBL WHERE pname LIKE '%"+tfSearch.getText()+"%' ORDER BY pnum DESC";
		ResultSet rs = stmt.executeQuery(sql);
		String record[] = new String[6];
		dtm2.setRowCount(0);
//		
		if(rs.next()==false) {
			aa.showMessageDialog(null, "검색된 재고가 없습니다.");
		} else {
			do {
				record[0] = rs.getString("pnum");
				record[1] = rs.getString("pname");
				record[2] = rs.getString("pprice");
				record[3] = rs.getString("psize");
				record[4] = rs.getString("puser");
				record[5] = rs.getString("pdate");
				dtm2.addRow(record);

			} while(rs.next()) ;
		}
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
} 	


protected void PDelete() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "";
		
		String pdnum = table2.getValueAt(row, 0).toString();
		sql = "DELETE FROM producttbl WHERE pNum="+pdnum;
		stmt.execute(sql);
		
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void SellDeldete() {
		// TODO Auto-generated method stub
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "";
		sd= Integer.parseInt(table1.getValueAt(srow, 2).toString());
		sql = "DELETE FROM selltbl WHERE sNum="+sd;
		stmt.execute(sql);
		srow=99999999;
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void productInsert() {
		// TODO Auto-generated method stub
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "";
		String pname=tfPName.getText();
		String psize=tfPSize.getText();
		String pprice=tfPPrice.getText();
		String pdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String puser=tfPUser.getText();
		String pimage=tfPImage.getText();
		sql = "INSERT INTO producttbl VALUES(product_SEQ.nextval,'"+pname+"',"+pprice+","+psize+",'"+puser+"','"+pdate+"','"+pimage+"')";
		int iItem = stmt.executeUpdate(sql);
		if(iItem>=1) {
			aa.showMessageDialog(null, "재고등록 성공");
			ShowProductAll();
			tfPSize.setText("");
			tfPPrice.setText("");
			tfPName.setText("");
			tfPUser.setText("");
			tfPImage.setText("미구현");
			
		} else {
			aa.showMessageDialog(null, "재고등록 실패");
		}
	} catch (ClassNotFoundException | SQLException e1) {
		aa.showMessageDialog(null, "빈칸을 모두 채워주세요.");
	}
	}

protected void deleteitem() {
		// TODO Auto-generated method stub
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "";

		sql = "DELETE FROM producttbl WHERE pNum='"+pnum+"'";
		stmt.execute(sql);
		
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

protected void sellItem() throws Exception {
	
		showitem();
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();
		String sql = "";
		
//		String snum=lblSPNum.getText();
//		String sname=lblSPName.getText();
//		String ssize=lblSPSize.getText();
//		String sPrice=lblSPPrice.getText();
		String sdate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//		String suser=textField_1.getText();
		
		sql = "INSERT INTO selltbl VALUES("+pnum+",'"+pname+"',"+psize+","+pprice+",'"+sdate+"','"+puser+"')";
		
			sellFlag = stmt.executeUpdate(sql);
			if(sellFlag>=1) {
				aa.showMessageDialog(null, "판매등록 성공");
				deleteitem(); // 판매등록 성공시 해당 아이템 삭제
				PSearch();
				ShowProductAll();
				row=9999999;
			} else {
				aa.showMessageDialog(null, "판매등록 실패");
			}
			
//		if(sellFlag>=1) {
//			aa.showMessageDialog(null, "판매등록 성공");
//			deleteitem(); // 판매등록 성공시 해당 아이템 삭제
//			PSearch();
//			ShowProductAll();
//		} else {
//			aa.showMessageDialog(null, "판매등록 실패");
//		}
		
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
	}

	private void showitem() {
	// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			
			
			Statement stmt = con.createStatement();			
			String sql = "";
			sql = "select * from productTBL WHERE pnum="+shownum;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				pnum = rs.getString("pNum");
				pname = rs.getString("pName");
				pprice = rs.getString("pPrice");
				psize = rs.getString("pSize");
				puser = rs.getString("pUser");
				pdate = rs.getString("pDate");
				opcount = "재고있음";
			}

		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
}

	protected void ShowSAll() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();			
			String sql = "";
			sql = "select * from sellTBL ORDER BY sDate ASC";
			ResultSet rs = stmt.executeQuery(sql);
			
			cnt=0;
			String record[] = new String[8];
			DefaultTableModel dtm = (DefaultTableModel)table1.getModel();
			dtm.setRowCount(0);
			while(rs.next()) {
				ssu = rs.getRow(); // 총 판매 물품 갯수
				
				record[0] = Integer.toString(++cnt);
				record[1] = rs.getString("sDate");
				record[2] = rs.getString("sNum");
				record[3] = rs.getString("sName");
				record[4] = rs.getString("sSize");
				record[5] = rs.getString("sUser");
				record[6] = "1";
				record[7] = rs.getString("sPrice");
//				for(int i=1; i < record.length; i++)
//					record[i] = rs.getString(i);
				dtm.addRow(record);
				
				int sum=0;
				String tb1sum="";
				for(int i=0;i<=table1.getRowCount()-1;i++) {
				int tb1 = Integer.parseInt(table1.getValueAt(i, 7).toString());
				sum = sum+tb1;
				tb1sum = Integer.toString(sum);
				
				}
				
				int sum2=0;
				String tb1sum2="";
				for(int i=0;i<=table1.getRowCount()-1;i++) {
				int tb2 = Integer.parseInt(table1.getValueAt(i, 6).toString());
				sum2 = sum2+tb2;
				tb1sum2 = Integer.toString(sum2);
				}
				
				lblNewLabel_5.setText(tb1sum+"원");
				textField_2.setText("총"+tb1sum2+"건");
			
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	} 
	
	protected void ShowProductAll() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
		String user = "system";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stmt = con.createStatement();			
		String sql = "";
		sql = "select * from productTBL ORDER BY pnum DESC";
		ResultSet rs = stmt.executeQuery(sql);
		String record[] = new String[6];
		dtm3.setRowCount(0);
		while(rs.next()) {
			psu = rs.getRow(); // 총 재고 개수 
			record[0] = rs.getString("pNum");
			record[1] = rs.getString("pName");
			record[2] = rs.getString("pPrice");
			record[3] = rs.getString("pSize");
			record[4] = rs.getString("pUser");
			record[5] = rs.getString("pDate");
//			for(int i=1; i < record.length; i++)
//				record[i] = rs.getString(i);
			dtm3.addRow(record);
		}
	} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
	}
} 	
}
