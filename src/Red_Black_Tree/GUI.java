package Red_Black_Tree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	public Tree RBC= new Tree(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 0, 0));
		frame.setBounds(100, 100, 540, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int num= Integer.parseInt(textField.getText());
				RBC.insert(num);
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(60, 179, 113));
		btnNewButton.setBounds(38, 140, 117, 44);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(142, 85, 236, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textField.getText().equals("tree")) 
				{
					RBC.delete_tree(RBC.root);
				}
				else 
				{
					int num= Integer.parseInt(textField.getText());
					RBC.delete(RBC.root, num);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(201, 140, 117, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(0, 0, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Print_Tree binTree= new Print_Tree(RBC);
				String title = "Graphical Display of Binary Tree";		
				JFrame bFrame = new JFrame(title);                  
				bFrame.getContentPane().add(binTree.getView());
				bFrame.pack();
				bFrame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(378, 140, 102, 44);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblRedblacktreeApp = new JLabel("Red-Black-Tree  App");
		lblRedblacktreeApp.setForeground(new Color(0, 0, 0));
		lblRedblacktreeApp.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblRedblacktreeApp.setBounds(162, 41, 236, 31);
		frame.getContentPane().add(lblRedblacktreeApp);
	}
}
