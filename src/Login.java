import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.file.*;
import java.util.*;
import java.lang.*;
import java.util.List;

public class Login extends JFrame implements ActionListener {
   private JPanel window;
   private JLabel login_label,empty_label,userName_label, password_label, status_label;
   private JTextField userName_text,password_text;
   private JButton submit;

   //lock object
   static final Object wait = new Object();
   private int loginStatus;

   private String name;
   private int type;
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
      setSize(500, 500);
      setVisible(true);
      return loginStatus;
   }

   public void waitTime(){
      //wait
      try {
         synchronized (wait) {
            wait.wait();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   @Override
   public void actionPerformed(ActionEvent ae) {
      String userName = userName_text.getText();
      String password = password_text.getText();
      int flag=0;
      try {
         List<String> buyer = Files.readAllLines(Paths.get("input/BuyerInfo.txt"));
         for (String a : buyer) {
            if(a.split(":")[0].equals(userName) && a.split(":")[1].equals(password)) {
               this.name = userName;
               this.type = 0;
               flag=1;
            }
         }
         List<String> seller = Files.readAllLines(Paths.get("input/SellerInfo.txt"));
         for (String a : seller) {
            if(a.split(":")[0].equals(userName) && a.split(":")[1].equals(password)) {
               this.name = userName;
               this.type = 1;
               flag=1;
            }
         }
      }
      catch(Exception e) {
         e.printStackTrace();
      }
      if(flag==1) {
         setVisible(false);
      }
      synchronized (wait) {
         wait.notify();
      }
   }

   public String getName() {
      return this.name;
   }

   public int getUserType() {
      return this.type;
   }
}