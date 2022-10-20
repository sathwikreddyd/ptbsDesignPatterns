import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
   private JPanel window;
   private JLabel login_label,empty_label,userName_label, password_label, status_label;
   private JTextField userName_text,password_text;
   private JButton submit;
   private int loginStatus;
   public int LoginWindow() {
      login_label = new JLabel();
      empty_label = new JLabel();
      userName_label = new JLabel();
      password_label = new JLabel();
      status_label = new JLabel();
      login_label.setText("LOGIN");
      empty_label.setText("Enter Details");
      userName_label.setText("User Name");
      password_label.setText("Password");
      status_label.setText(" ");
      userName_text = new JTextField();
      password_text = new JTextField();
      submit = new JButton("Submit");
      window = new JPanel(new GridLayout(4, 2));
      window.add(login_label);
      window.add(empty_label);
      window.add(userName_label);
      window.add(userName_text);
      window.add(password_label);
      window.add(password_text);
      window.add(submit);
      window.add(status_label);
      submit.addActionListener(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      add(window, BorderLayout.CENTER);
      setTitle("Login");
      setSize(500,500);
      setVisible(true);
      return loginStatus;
   }

   public void sett(){
      System.out.println(loginStatus);
   }
   public static void main(String[] args) {
      Login k = new Login();
      System.out.println(k.LoginWindow());
      k.sett();
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      if (userName.trim().equals("admin") && password.trim().equals("admin")) {
         status_label.setText(" Hello " + userName + "");
         loginStatus = 15;

      } else {
         status_label.setText(" Invalid user.. ");
         loginStatus = 0;
      }
   }
}