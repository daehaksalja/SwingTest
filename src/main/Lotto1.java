package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Lotto1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lotto1 frame = new Lotto1();
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
	public Lotto1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel one1 = new JLabel("New label");
		one1.setHorizontalAlignment(SwingConstants.CENTER);
		one1.setBounds(12, 41, 100, 100);
		BevelBorder border1=new BevelBorder(BevelBorder.RAISED);
		 one1.setBorder(border1);
		contentPane.add(one1);
		
		JLabel one2 = new JLabel("New label");
		one2.setHorizontalAlignment(SwingConstants.CENTER);
		one2.setBounds(12, 41, 100, 100);
		BevelBorder border2=new BevelBorder(BevelBorder.RAISED);
		 one2.setBorder(border1);
		contentPane.add(one2);
		
	}
}
