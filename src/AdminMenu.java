import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;

public class AdminMenu extends JFrame {
	static AdminMenu frame;
	private JPanel contentPane;

	public static void main(String[] args, String name, String password) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int admin_id = 0;
				try {
					admin_id = AdminData.getAdminId(name, password);
					frame = new AdminMenu(admin_id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminMenu(int admin_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminSection = new JLabel("Adminovo kontrolno okno");
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdminSection.setForeground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Dodaj knjižničarja");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminAddLib.main(new String []{}, admin_id);
			}
		});
		
		JButton btnViewLibrarian = new JButton("Poglej knjižničarje");
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("dela");
			}
		});
		btnViewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnDeleteLibrarian = new JButton("Izbriši knjižničarja");
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println("dela");
			frame.dispose();
			}
		});
		btnDeleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLogout = new JButton("Izpis");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

