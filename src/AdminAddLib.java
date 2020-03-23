import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddLib extends JFrame {
	static AdminAddLib frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	public static void main(String[] args, int admin_id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminAddLib(admin_id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminAddLib(int admin_id) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.ORANGE);
		
		JLabel lblAddLibrarian = new JLabel("Dodaj knjižničarja");
		lblAddLibrarian.setForeground(Color.BLACK);
		lblAddLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblName = new JLabel("Priimek:");
		
		JLabel lblPassword = new JLabel("Geslo:");
		
		JLabel lblEmail = new JLabel("Ime:");
		
		JLabel lblAddress = new JLabel("Email:");
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.setBackground(Color.cyan);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField_1.getText();
			String password=String.valueOf(passwordField.getPassword());
			String surname=textField.getText();
			String email=textField_2.getText();

			AdminData.save(name, surname, password, email, admin_id);
			
			frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Nazaj");
		btnBack.setBackground(Color.cyan);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(lblName)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(passwordField))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addComponent(lblAddLibrarian)
					.addGap(110))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(133))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(169))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddLibrarian)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblName)
								.addGap(18)
								.addComponent(lblPassword))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGap(18)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBack)
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
