package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

public class RegistFrame1 extends JFrame {

   private JPanel contentPane;
   private JTextField idField;
   private JPasswordField passwordField;
   private JPasswordField rePasswordField;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               RegistFrame1 frame = new RegistFrame1();
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
   public RegistFrame1() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JButton button = new JButton("돌아가기");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            Main main = new Main();
            main.setVisible(true);
            setVisible(false);
         }
      });
      button.setBounds(68, 180, 105, 28);
      contentPane.add(button);
      
      JLabel label = new JLabel("회원가입");
      label.setBounds(222, 12, 59, 18);
      contentPane.add(label);
      
      JLabel idlabel_1 = new JLabel("아이디");
      idlabel_1.setBounds(151, 34, 59, 18);
      contentPane.add(idlabel_1);
      
      idField = new JTextField();
      idField.setBounds(130, 58, 105, 18);
      contentPane.add(idField);
      idField.setColumns(10);
      
      JLabel pwlabel_1 = new JLabel("비밀번호");
      pwlabel_1.setBounds(151, 87, 59, 18);
      contentPane.add(pwlabel_1);
      
      passwordField = new JPasswordField();
      passwordField.setBounds(130, 109, 105, 18);
      contentPane.add(passwordField);
      
      JLabel relabel_1 = new JLabel("비밀번호 확인");
      relabel_1.setBounds(130, 130, 105, 18);
      contentPane.add(relabel_1);
      
      rePasswordField = new JPasswordField();
      rePasswordField.setBounds(130, 152, 105, 18);
      contentPane.add(rePasswordField);
      
      JButton button_1 = new JButton("회원가입");
      button_1.addActionListener(new ActionListener() {
         
    	  
    	  
    	  
    	  
    	  public void actionPerformed(ActionEvent e) {
        	 boolean idFix = false;
        	 boolean pwFix = false;
        
         String id= idField.getText();
         String resultID = id.trim().replaceAll(" ", "");
         int resultLeng = resultID.length();
         String onlyEng = resultID.replaceAll("[^a-zA-Z0-9]","");
         
         
         System.out.println(resultID);
         System.out.println("아이디의 길이:"+resultLeng);
         MySQLDB db1 = new MySQLDB();
         boolean idDup = db1.idDuplicate(onlyEng);
         
         
         
         
         if(onlyEng.length()>0) {
             System.out.println("영어로만 이루어진 올바른 아이디입니다");
             System.out.println("디비에 저장될 아이디"+onlyEng);
             idFix=true;
          }else {
             System.out.println("영아가 아닌 다른문자가 있다");
             JOptionPane.showMessageDialog(contentPane, "영어로만 입력합시다", "경고", JOptionPane.WARNING_MESSAGE);
          }
         
         if(id == null || id.equals("")) {
        	 System.out.println("아이디가 비었습니다");
        	 JOptionPane.showMessageDialog(contentPane, "아이디가 비었다", "회원가입불가", JOptionPane.WARNING_MESSAGE);
         }else {
        	 String resultPW = id.trim().replaceAll(" ", "");
        	 idFix = true;
         }
         if(idDup == false){
        	 System.out.println("사용가능한 아이디당");
        	 
         }else {
        	 System.out.println("좆중복 민주화");
        	 JOptionPane.showMessageDialog(contentPane, "이미있는 아이디댜", "회원가입불가", JOptionPane.WARNING_MESSAGE);
         }
         String pw = passwordField.getText();
         String rePW = rePasswordField.getText();
         
         if(pw==null || pw.equals("")) {
        	 System.out.println("비밀번호가 비었읍니다");
        	 JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력하셔야합니다", "회원가입불가", JOptionPane.WARNING_MESSAGE);
         }else {
        	       String resultPW = pw.trim().replaceAll(" ", "");
        		      if(resultPW.equals(rePW)) {
        		         System.out.println("비밀번호가 일치합니다");
        		         pwFix = true;
        	        }else {
        	        	passwordField.setText("");
        	        	rePasswordField.setText("");
        	            System.out.println("비밀번호가 일치하지않습니다");
        	            JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지않습니다", "회원가입불가", JOptionPane.WARNING_MESSAGE);
                     }
         }
         
         if(idFix == true && pwFix == true && idDup == false) {
        	 MySQLDB db = new MySQLDB();
        	 db.insert(onlyEng, pw);
        	 System.out.println("insert 완료");
        	 setVisible(false);
        	 Main main = new Main();
        	 main.setVisible(true);
        	 
         }else {
        	 System.out.println("회원가입불가");
        	 JOptionPane.showMessageDialog(contentPane, "아이디와 비번을 올바르게입력해주세요", "회원가입불가", JOptionPane.WARNING_MESSAGE);
         }
        	 
            System.out.println("id:"+id);
            System.out.println("pw:"+pw);
            
          
         }
      });
      button_1.setBounds(222, 180, 105, 28);
      contentPane.add(button_1);
   }

}