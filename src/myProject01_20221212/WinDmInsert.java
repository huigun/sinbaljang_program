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
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class WinDmInsert extends JFrame {

	private JPanel contentPane;
	private JTextField tfWriter;
	private JTextField tfRecipient;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinDmInsert frame = new WinDmInsert();
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
	public WinDmInsert() {
		setTitle("\uBA54\uC138\uC9C0 \uC791\uC131");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 510);
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
		tfWriter.setBounds(67, 15, 130, 21);
		contentPane.add(tfWriter);
		tfWriter.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\uBC1B\uB294\uC0AC\uB78C :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel_2.setBounds(209, 16, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfRecipient = new JTextField();
		tfRecipient.setColumns(10);
		tfRecipient.setBounds(276, 16, 130, 21);
		contentPane.add(tfRecipient);
		
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
		
		btnInsert = new JButton("\uC804\uC1A1");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DmInsert();
			}
		});
		btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnInsert.setBackground(new Color(255, 255, 255));
		btnInsert.setBounds(465, 433, 97, 28);
		contentPane.add(btnInsert);
		
		btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
		
		// 프레임 크기
				Dimension frameSize = getSize();
				// 모니터 크기
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				// 모니터 중앙에 프레임 띄우기
				setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	protected void DmInsert() {
		// TODO Auto-generated method stub
		try {
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
				String dmrecipient = tfRecipient.getText();
				
				if(tfFile.getText().equals("")) {
					dmfile = "첨부파일 없음";
				} else {
				dmfile = tfFile.getText();
				}
				sql = "INSERT INTO dmtbl VALUES(dm_SEQ.nextval,'"+dmdate+"','"+dmtitle+"','"+dmcontent+"','"+dmwriter+"','"+dmrecipient+"','"+dmfile+"')";
				int iDm = stmt.executeUpdate(sql);
				if(iDm>0) {
					aa.showMessageDialog(null, "등록 완료.");
					setVisible(false);
				} else {
					aa.showMessageDialog(null, "등록 실패. 다시 시도 해주세요.");
				}
			
		} catch (ClassNotFoundException | SQLException e1) {
			if(tfWriter.getText().equals("")) {
				aa.showMessageDialog(null, "작성자를 입력 해주세요.");
			} else if(tfRecipient.getText().equals("")) {
				aa.showMessageDialog(null, "받는사람을 입력 해주세요.");
			} else if(tfTitle.getText().equals("")) {
				aa.showMessageDialog(null, "제목을 입력 해주세요");
			} else if(tfContent.getText().equals("")) {
				aa.showMessageDialog(null, "내용을 입력 해주세요.");
			}
		}
		
	}
}
