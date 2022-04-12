package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;

import db.MySQLDB;
import db.MySQLDB2;

import javax.swing.event.AncestorEvent;
import javax.swing.JPasswordField;

public class Main extends JFrame {

   private JPanel contentPane;
   private JTextField idInputField;
   private JPasswordField passwordInputField;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main frame = new Main();
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
   public Main() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.addAncestorListener(new AncestorListener() {
         public void ancestorAdded(AncestorEvent event) {
         }
         public void ancestorMoved(AncestorEvent event) {
         }
         public void ancestorRemoved(AncestorEvent event) {
         }
      });
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      idInputField = new JTextField();
      idInputField.setBounds(52, 62, 114, 22);
      contentPane.add(idInputField);
      idInputField.setColumns(10);
      
      JLabel label = new JLabel("로그인");
      label.setBounds(150, 12, 59, 18);
      contentPane.add(label);
      
      JButton button = new JButton("확인");
      button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		
      		String loginID= idInputField.getText();
            String loginPW = passwordInputField.getText();
               System.out.println("id:"+loginID);
               System.out.println("pw:"+loginPW);
               
               MySQLDB db = new MySQLDB();
               int loginResult = db.login(loginID, loginPW);
               if(loginResult == 1000) {
            	   System.out.println("로그인성공했으니 다른창을 띄워주세요");
            	   Lotto1 lf = new Lotto1();
            	   lf.setVisible(true);
            	   setVisible(false);
               }else {
            	   JOptionPane.showMessageDialog(contentPane, "아디나 비번이 틀립니다", "불가", JOptionPane.WARNING_MESSAGE);
               }
            
      	}
      });
      button.setBounds(202, 56, 105, 28);
      contentPane.add(button);
      
      JButton button_1 = new JButton("회원가입");
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {

            RegistFrame1 rf= new RegistFrame1();
            rf.setVisible(true);
            setVisible(false);
         }
      });
      button_1.setBounds(150, 123, 105, 28);
      contentPane.add(button_1);
      
      passwordInputField = new JPasswordField();
      passwordInputField.setBounds(52, 89, 114, 22);
      contentPane.add(passwordInputField);
   }
}