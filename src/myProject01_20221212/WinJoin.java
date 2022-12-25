package myProject01_20221212;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPasswordField;

public class WinJoin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelLogin;
	private JLabel lbl1;
	private JLabel lbl2;
	private JTextField tfPw;
	private JTextField tfId;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JTextField tfTel;
	private JTextField tfAddress;
	private JTextField tfAdmin;
	String stId;
	JOptionPane aa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinJoin dialog = new WinJoin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinJoin() {
		getContentPane().setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		setUndecorated(true);
		setTitle("SinBalJang");
		setSize(345, 472);
		// «¡∑π¿” ≈©±‚
		Dimension frameSize = getSize();
		// ∏¥œ≈Õ ≈©±‚
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// ∏¥œ≈Õ ¡ﬂæ”ø° «¡∑π¿” ∂ÁøÏ±‚
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		
		getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBorder(new TitledBorder(new LineBorder(Color.red)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("mini");
		lblTitle.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		lblTitle.setBounds(34, 34, 57, 15);
		contentPanel.add(lblTitle);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(1, 439, 343, 32);
		contentPanel.add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\uAC00\uC785");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Join();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(149, 0, 92, 31);
		panelBtn.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uC885\uB8CC");
		btnNewButton_1_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinLogin winLogin = new WinLogin();
				winLogin.setVisible(true);
				setVisible(false);
			
			}
		});
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(240, 0, 92, 31);
		panelBtn.add(btnNewButton_1_1);
		
		panelLogin = new JPanel();
		panelLogin.setBounds(1, 176, 343, 260);
		contentPanel.add(panelLogin);
		panelLogin.setLayout(null);
		
		lbl1 = new JLabel("ID :");
		lbl1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lbl1.setBounds(12, 11, 118, 27);
		panelLogin.add(lbl1);
		
		lbl2 = new JLabel("PW :");
		lbl2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lbl2.setBounds(12, 48, 118, 27);
		panelLogin.add(lbl2);
		
		tfPw = new JTextField();
		tfPw.setColumns(10);
		tfPw.setBounds(114, 48, 174, 27);
		panelLogin.add(tfPw);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(114, 11, 174, 27);
		panelLogin.add(tfId);
		
		JLabel lblName = new JLabel("\uC9C0\uC810\uBA85 :");
		lblName.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblName.setBounds(12, 85, 118, 27);
		panelLogin.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(114, 86, 174, 27);
		panelLogin.add(tfName);
		
		JLabel lblTel = new JLabel("TEL :");
		lblTel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblTel.setBounds(12, 122, 118, 27);
		panelLogin.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(114, 123, 218, 27);
		panelLogin.add(tfTel);
		
		JLabel lblAddress = new JLabel("\uC8FC\uC18C :");
		lblAddress.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblAddress.setBounds(12, 159, 118, 27);
		panelLogin.add(lblAddress);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(114, 159, 218, 27);
		panelLogin.add(tfAddress);
		
		JLabel lblAdmin = new JLabel("\uAD00\uB9AC\uC790 :");
		lblAdmin.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		lblAdmin.setBounds(12, 194, 118, 27);
		panelLogin.add(lblAdmin);
		
		tfAdmin = new JTextField();
		tfAdmin.setColumns(10);
		tfAdmin.setBounds(114, 196, 109, 27);
		panelLogin.add(tfAdmin);
		
		JLabel lblNewLabel = new JLabel("2000\uB144 0\uC6D4 00\uC77C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(237, 31, 115, 21);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		lblNewLabel.setText(LocalDate.now().toString());
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\AHG\\image\\sample.jpg"));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(1, 28, 343, 137);
		lblNewLabel_1.setOpaque(true);
		contentPanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 202, 200));
		panel.setBounds(1, 1, 343, 28);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SinBalJang");
		lblNewLabel_2.setBounds(12, 7, 72, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("x");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setBackground(new Color(255, 81, 81));
		lblNewLabel_3.setBorder(new TitledBorder(new LineBorder(Color.gray)));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(303, 3, 29, 22);
		panel.add(lblNewLabel_3);
	}

	protected void Join() throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			String sql = "";
			stId=tfId.getText();
			String stPw=tfPw.getText();
			String stName=tfName.getText();
			String stTel=tfTel.getText();
			String stDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			String stAddress=tfAddress.getText();
			String stAdmin=tfAdmin.getText();
			
			sql = "INSERT INTO storetbl VALUES(store_SEQ.nextval,'"+stId+"','"+stPw+"','"+stName+"','"+stTel+"','"+stAddress+"','"+stAdmin+"','"+stDate+"')";
			int stFlag = 0;
				stFlag = stmt.executeUpdate(sql);
				if(stFlag==1) {
					aa.showMessageDialog(null, "∞°¿‘º∫∞¯");
					WinLogin winLogin = new WinLogin();
					winLogin.setVisible(true);
					setVisible(false);
				} else {
				aa.showMessageDialog(null, "∞°¿‘Ω«∆– ¥ŸΩ√ Ω√µµ «ÿ¡÷ººø‰");
				}
			
//			if(stFlag==1) {
//				aa = new JOptionPane();
//				aa.showMessageDialog(null, "∞°¿‘øœ∑·");
//				setVisible(false);
//				WinLogin winLogin = new WinLogin();
//				winLogin.setVisible(true);
//			} else {
//				aa.showMessageDialog(null, "∞°¿‘Ω«∆– ¥ŸΩ√ Ω√µµ «ÿ¡÷ººø‰");
//			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
