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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {
	static ReturnBook frame;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> booklist;
	private String[] str;
	private int counter = 0;
	private int id = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.ORANGE);
		
		Connection con=Database.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT COUNT(id) FROM Books WHERE rented = 1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			rs.next();
			str = new String[rs.getInt(1)];
			
			ps=con.prepareStatement("SELECT name FROM Books WHERE rented = 1",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			while(rs.next()) {
				str[counter] = rs.getString("name");
				counter++;
			}
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		
		booklist = new JComboBox<>(str);
		
		
		
		try {
			ps = con.prepareStatement("SELECT id FROM Books WHERE name=?");
			ps.setString(1, (String) booklist.getSelectedItem());
			ResultSet rs=ps.executeQuery();
			rs.next();
			id = rs.getInt(1);
			
		} catch (SQLException e1) {
			System.out.println(e1);
		}
		
		JLabel lblReturnBook = new JLabel("Vrni knjigo");
		lblReturnBook.setForeground(Color.BLACK);
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBookCallno = new JLabel("Email vračitelja: ");
		
		JLabel lblStudentId = new JLabel("Identifikacija knjige: ");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnReturnBook = new JButton("Vrni knjigo");
		btnReturnBook.setBackground(Color.cyan);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=textField.getText();
				int i=AdminData.returnBook(email, id);
				if(i>0){
					JOptionPane.showMessageDialog(ReturnBook.this,"Knjiga je bila vrnjena uspešna!");
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(ReturnBook.this,"Napaka pri shranjveanju!");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Pozor: preverite identifikacijo knjige!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
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
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblStudentId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblBookCallno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(booklist, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(lblReturnBook)
					.addGap(187))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addContainerGap(294, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(194))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReturnBook)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookCallno)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(booklist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(72))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
