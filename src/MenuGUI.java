import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.util.List;

class MenuGUI extends JFrame {

    JButton jButton;

    ArrayList<JRadioButton> l;
    ButtonGroup G1;

    JLabel L1;

    public MenuGUI(List<String> value)
    {

        this.setLayout(null);

        jButton = new JButton("Submit");

        G1 = new ButtonGroup();

        L1 = new JLabel("Product Types");

        L1.setBounds(20,30,150,50);

        this.add(L1);

        int x=0,y=0;
        l = new ArrayList<JRadioButton>();
        for (String k : value) {
            JRadioButton j = new JRadioButton();
            j.setText(k);
            j.setBounds(120+x,30,100,50);
            x+=120;
            l.add(j);
            this.add(j);
            G1.add(j);
        }
        jButton.setBounds(120,150,50,50);
        this.add(jButton);
        this.setTitle("Products");
        this.setBounds(50,50,1000,500);
        this.setVisible(true);
    }
}

