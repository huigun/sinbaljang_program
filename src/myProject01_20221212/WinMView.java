package myProject01_20221212;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinMView extends JDialog {

	private JPanel contentPane;
	private JTextField tfWriter;
	private JTextField tfRecipient;
	private JTextField tfFile;
	private JTextArea tfTitle;
	private JScrollPane scrollPane_1;
	private JButton btnFileInsert;
	private JButton btnCancel;
	private JTextArea tfContent;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	JOptionPane aa;
	static String msnum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					WinMView dialog = new WinMView(msnum);
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
	public WinMView(String msnum) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowMS();
			}
		});
		this.msnum=msnum;
		setTitle("\uBA54\uC138\uC9C0 \uBCF4\uAE30");
		setBounds(100, 100, 725, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("\uC81C\uBAA9 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		lblNewLabel.setBounds(0, 41, 58, 26);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uC791\uC131\uC790 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 16, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfWriter = new JTextField();
		tfWriter.setEditable(false);
		tfWriter.setBounds(67, 15, 130, 21);
		contentPane.add(tfWriter);
		tfWriter.setColumns(10);
		lblNewLabel_2 = new JLabel("\uBC1B\uB294\uC0AC\uB78C :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		lblNewLabel_2.setBounds(209, 16, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		tfRecipient = new JTextField();
		tfRecipient.setEditable(false);
		tfRecipient.setColumns(10);
		tfRecipient.setBounds(276, 16, 130, 21);
		contentPane.add(tfRecipient);
		
		lblNewLabel_3 = new JLabel("\uB0B4\uC6A9 :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 12));
		lblNewLabel_3.setBounds(1, 108, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 104, 604, 275);
		contentPane.add(scrollPane);
		
		tfContent = new JTextArea();
		tfContent.setEditable(false);
		tfContent.setLineWrap(true);
		scrollPane.setViewportView(tfContent);
		
		btnCancel = new JButton("√Îº“");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setBounds(304, 433, 97, 28);
		contentPane.add(btnCancel);
		
		tfFile = new JTextField();
		tfFile.setBounds(177, 393, 495, 23);
		contentPane.add(tfFile);
		tfFile.setColumns(10);
		
		btnFileInsert = new JButton("\uCCA8\uBD80\uD30C\uC77C");
		btnFileInsert.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		btnFileInsert.setBackground(Color.WHITE);
		btnFileInsert.setBounds(68, 391, 102, 26);
		contentPane.add(btnFileInsert);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(68, 46, 604, 48);
		contentPane.add(scrollPane_1);
		
		tfTitle = new JTextArea();
		tfTitle.setEditable(false);
		tfTitle.setLineWrap(true);
		scrollPane_1.setViewportView(tfTitle);
		// «¡∑π¿” ≈©±‚
				Dimension frameSize = getSize();
				// ∏¥œ≈Õ ≈©±‚
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				// ∏¥œ≈Õ ¡ﬂæ”ø° «¡∑π¿” ∂ÁøÏ±‚
				setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	protected void ShowMS() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@58.232.38.53:1521:xe";
			String user = "system";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();			
			String sql = "";
			sql = "SELECT * FROM dmtbl WHERE dmnum="+msnum;
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				tfWriter.setText(rs.getString("dmwriter"));
				tfRecipient.setText(rs.getString("dmrecipient"));
				tfContent.setText(rs.getString("dmcontent"));
				tfTitle.setText(rs.getString("dmtitle"));
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
