package myProject01_20221212;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WinLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JPanel panelLogin;
	private JLabel lbl1;
	private JLabel lbl2;
	private JTextField tfPw;
	private JTextField tfId;
	private JLabel lblNewLabel_1;
	JOptionPane aa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinLogin dialog = new WinLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinLogin() {
		getContentPane().setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		setUndecorated(true);
		setTitle("SinBalJang");
		setSize(298, 313);
		// ÇÁ·¹ÀÓ Å©±â
		Dimension frameSize = getSize();
		// ¸ð´ÏÅÍ Å©±â
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// ¸ð´ÏÅÍ Áß¾Ó¿¡ ÇÁ·¹ÀÓ ¶ç¿ì±â
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		
		
		getContentPane().setLayout(new BorderLayout());
		//contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBorder(new TitledBorder(new LineBorder(Color.red)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("mini");
		lblTitle.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		lblTitle.setBounds(10, 34, 57, 15);
		contentPanel.add(lblTitle);
		
		JPanel panelBtn = new JPanel();
		panelBtn.setBounds(1, 279, 293, 33);
		contentPanel.add(panelBtn);
		panelBtn.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\uD648\uD398\uC774\uC9C0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(110, 0, 92, 31);
		panelBtn.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		JButton btnNewButton_1_1 = new JButton("\uC885\uB8CC");
		btnNewButton_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			
			}
		});
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(201, 0, 92, 31);
		panelBtn.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("\uAC00\uC785");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WinJoin winJoin = new WinJoin();
				winJoin.setVisible(true);
				setModal(true);
				
			}
		});
		btnNewButton_1_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnNewButton_1_2.setBackground(Color.WHITE);
		btnNewButton_1_2.setBounds(19, 0, 92, 31);
		panelBtn.add(btnNewButton_1_2);
		
		panelLogin = new JPanel();
		panelLogin.setBounds(1, 176, 208, 105);
		contentPanel.add(panelLogin);
		panelLogin.setLayout(null);
		
		lbl1 = new JLabel("ID");
		lbl1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lbl1.setBounds(12, 11, 118, 27);
		panelLogin.add(lbl1);
		
		lbl2 = new JLabel("PW");
		lbl2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		lbl2.setBounds(12, 48, 118, 27);
		panelLogin.add(lbl2);
		
		tfPw = new JPasswordField();
		tfPw.setColumns(10);
		tfPw.setBounds(47, 49, 157, 27);
		panelLogin.add(tfPw);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(47, 12, 157, 27);
		panelLogin.add(tfId);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("ID \uC800\uC7A5");
		chckbxNewCheckBox.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(22, 81, 65, 23);
		panelLogin.add(chckbxNewCheckBox);
		
		btnNewButton = new JButton("·Î±×ÀÎ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserSearch();
			}
		});
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(210, 186, 83, 68);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("2000\uB144 0\uC6D4 00\uC77C");
		lblNewLabel.setText(LocalDate.now().toString());
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(214, 31, 115, 21);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:/Users/b/Desktop/SinBalJang/sample.jpg"));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(1, 28, 296, 137);
		lblNewLabel_1.setOpaque(true);
		contentPanel.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 202, 200));
		panel.setBounds(1, 1, 296, 28);
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
		lblNewLabel_3.setBounds(262, 3, 29, 22);
		panel.add(lblNewLabel_3);
	}

	protected void UserSearch() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();			
			String sql = "";
			sql = "select * from storeTBL where stId='"+tfId.getText()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String pw = rs.getString("stPw");
				
				if(tfPw.getText().equals(pw)) {
					aa.showMessageDialog(null, "·Î±×ÀÎ ¼º°ø");
					WinMain winMain = new WinMain();
					winMain.setVisible(true);
					setVisible(false);
				} else {
					aa.showMessageDialog(null, "ºñ¹Ð¹øÈ£°¡ Æ²¸³´Ï´Ù.");
				}
			} else {
				aa = new JOptionPane();
				aa.showMessageDialog(null, "¾ÆÀÌµð°¡ ¾ø½À´Ï´Ù.");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	
}
