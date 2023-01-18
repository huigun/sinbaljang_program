package myProject01_20221212;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;

public class WinDmInsert extends JDialog {
	private JCheckBox stname;
	private JPanel contentPane;
	private JTextField tfWriter;
	private JTextField tfFile;
	private JTextArea tfTitle;
	private JScrollPane scrollPane_1;
	private JButton btnFileInsert;
	private JButton btnCancel;
	private JButton btnInsert;
	private JTextArea tfContent;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private String dmfile;
	JOptionPane aa;
	private String stName="";
	private JPanel panel;
	private int i;
	private JCheckBox chckbxNewCheckBox;
	private JScrollBar scrollBar;
	private JCheckBox chbAll;
	private JCheckBox cbt;
	private ArrayList<String> dmrp = new ArrayList<String>();
	private int iDm;
	private int iDmSum=0;
	private JCheckBox chbNotice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String stName="";

			public void run() {
				try {
					WinDmInsert dialog = new WinDmInsert(stName);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WinDmInsert(String stName) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				SStore();
			}
		});
		this.stName=stName;
		setTitle("\uBA54\uC138\uC9C0 \uC791\uC131");
		setBounds(100, 100, 877, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("\uC81C\uBAA9 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 41, 58, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uC791\uC131\uC790 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 16, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfWriter = new JTextField();
		tfWriter.setEditable(false);
		tfWriter.setBounds(67, 15, 130, 21);
		contentPane.add(tfWriter);
		tfWriter.setColumns(10);
		tfWriter.setText(stName);
		lblNewLabel_2 = new JLabel("\uBC1B\uB294\uC9C0\uC810 :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2.setBounds(615, 16, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\uB0B4\uC6A9 :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_3.setBounds(1, 108, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 104, 604, 275);
		contentPane.add(scrollPane);
		
		tfContent = new JTextArea();
		tfContent.setLineWrap(true);
		scrollPane.setViewportView(tfContent);
		
		btnInsert = new JButton("전송");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chbNotice.isSelected()==false) {
					DmInsert();
				} else if(chbNotice.isSelected()==true) {
					NoticeInsert();
					
				}
			}
		});
		btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnInsert.setBackground(new Color(255, 255, 255));
		btnInsert.setBounds(465, 433, 97, 28);
		contentPane.add(btnInsert);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setBounds(575, 433, 97, 28);
		contentPane.add(btnCancel);
		
		tfFile = new JTextField();
		tfFile.setBounds(177, 393, 495, 23);
		contentPane.add(tfFile);
		tfFile.setColumns(10);
		
		btnFileInsert = new JButton("\uD30C\uC77C\uCCA8\uBD80");
		btnFileInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnFileInsert.setBackground(Color.WHITE);
		btnFileInsert.setBounds(68, 391, 102, 26);
		contentPane.add(btnFileInsert);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(68, 46, 604, 48);
		contentPane.add(scrollPane_1);
		
		tfTitle = new JTextArea();
		tfTitle.setLineWrap(true);
		scrollPane_1.setViewportView(tfTitle);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(684, 16, 171, 445);
		scrollPane_2.getVerticalScrollBar().setUnitIncrement(15);
		contentPane.add(scrollPane_2);
		
		panel = new JPanel();
		scrollPane_2.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		chbAll = new JCheckBox("전체 선택");
		chbAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chbAll.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				dmrp = new ArrayList<String>();
				SStore();
			}
		});
		panel.add(chbAll);
		
		chbNotice = new JCheckBox("공지");
		chbNotice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chbAll.doClick();
			}
		});
		chbNotice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chbNotice.setBounds(558, 12, 49, 23);
		contentPane.add(chbNotice);
		if(!stName.equals("본사")) {
			chbNotice.setVisible(false);
		}
		
		
		// 프레임 크기
				Dimension frameSize = getSize();
				// 모니터 크기
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				// 모니터 중앙에 프레임 띄우기
				setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	protected void NoticeInsert() {
		try {
			for(int i=0;i<dmrp.size();i++) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			String sql = "";
				String dmtitle = tfTitle.getText();
				String dmcontent = tfContent.getText();
				String dmwriter = tfWriter.getText();
				String dmdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 날짜
				
				if(tfFile.getText().equals("")) {
					dmfile = "첨부파일 없음";
				} else {
				dmfile = tfFile.getText();
				}
				String dmrecipient="공지"+stName;
				sql = "INSERT INTO dmtbl VALUES(dm_SEQ.nextval,'"+dmdate+"','"+dmtitle+"','"+dmcontent+"','"+dmwriter+"','"+dmrecipient+"','"+dmfile+"','0')";
				iDm = stmt.executeUpdate(sql);
				iDmSum = iDmSum + iDm;
				
				} if(iDmSum>dmrp.size()-1) {
					aa.showMessageDialog(null, "등록 완료.");
					setVisible(false);
				} else {
					aa.showMessageDialog(null, "등록 실패. 다시 시도 해주세요.");
				}
			
		} catch (ClassNotFoundException | SQLException e1) {
			if(tfTitle.getText().equals("")) {
				aa.showMessageDialog(null, "제목을 입력 해주세요");
			} else if(tfContent.getText().equals("")) {
				aa.showMessageDialog(null, "내용을 입력 해주세요.");
			} else {
				aa.showMessageDialog(null, "알수없는 오류.");
			}e1.printStackTrace();
		}
	
}
	protected void SStore() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();			
			String sql = "";
			sql = "SELECT * FROM storetbl";
			ResultSet rs = stmt.executeQuery(sql);
			i=0;
			Component compList[] = panel.getComponents();
			for(Component c : compList) {
				if(c instanceof JCheckBox) {
					panel.remove(c);
					panel.revalidate();
					panel.repaint();
				}
			}
			panel.add(chbAll);
			
			while(rs.next()) {
				int checkCount=0;
				
				if(!rs.getString("stname").equals("본사") && !rs.getString("stname").equals(stName)) {
				stname = new JCheckBox(rs.getString("stname"));
				stname.setBounds(10, i*25+10, 50, 20);
				}
				stname.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(((JCheckBox)e.getSource()).isSelected()==true) {
							String su = ((JCheckBox)e.getSource()).getText();
							dmrp.add(su);
						} else if(((JCheckBox)e.getSource()).isSelected()==false) {
							String su = ((JCheckBox)e.getSource()).getText();
							dmrp.remove(su);
						}
					}
				});
				
				if(chbAll.isSelected()==false) {
					dmrp = new ArrayList<String>();
					stname.setSelected(false);
				} else if(chbAll.isSelected()==true) {
					stname.setSelected(false);
					stname.doClick();
				}
				
				panel.add(stname);
				
				stname.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
				
				i++;
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected void DmInsert() {
		try {
			if(dmrp.size()==0) {
				aa.showMessageDialog(null, "지점을 선택 해주세요.");
			} else {
			for(int i=0;i<dmrp.size();i++) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			String sql = "";
				String dmtitle = tfTitle.getText();
				String dmcontent = tfContent.getText();
				String dmwriter = tfWriter.getText();
				String dmdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // 날짜
				
				if(tfFile.getText().equals("")) {
					dmfile = "첨부파일 없음";
				} else {
				dmfile = tfFile.getText();
				}
				String dmrecipient = dmrp.get(i);
				
				sql = "INSERT INTO dmtbl VALUES(dm_SEQ.nextval,'"+dmdate+"','"+dmtitle+"','"+dmcontent+"','"+dmwriter+"','"+dmrecipient+"','"+dmfile+"','0')";
				iDm = stmt.executeUpdate(sql);
				iDmSum = iDmSum + iDm;
				
			} if(iDmSum>dmrp.size()-1) {
					aa.showMessageDialog(null, "등록 완료.");
					setVisible(false);
				} else {
					aa.showMessageDialog(null, "등록 실패. 다시 시도 해주세요.");
				}
			}
		} catch (ClassNotFoundException | SQLException e1) {
			if(dmrp.size()==0) {
				aa.showMessageDialog(null, "지점을 선택 해주세요.");
			} else if(tfWriter.getText().equals("")) {
				aa.showMessageDialog(null, "작성자를 입력 해주세요.");
			} else if(tfTitle.getText().equals("")) {
				aa.showMessageDialog(null, "제목을 입력 해주세요");
			} else if(tfContent.getText().equals("")) {
				aa.showMessageDialog(null, "내용을 입력 해주세요.");
			} else {
				aa.showMessageDialog(null, "알수없는 오류.");
			}
		}
		
	}
}
