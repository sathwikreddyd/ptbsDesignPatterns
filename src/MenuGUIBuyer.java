import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.util.List;

class MenuGUIBuyer extends JFrame{

    //BUYER BRIDGE PATTERN
    public String option;

    static final Object wait = new Object();
    public int productType;
    public String product;
    public ArrayList<String> products;
    JButton jButton;
    ArrayList<JRadioButton> l;
    ButtonGroup G1;
    JLabel L1;
    public void MenuGUIforProducts(List<String> value)
    {

        this.setLayout(null);
        jButton = new JButton("Submit");
        //jButton.setText("Submit");
        G1 = new ButtonGroup();
        L1 = new JLabel("Products");
        L1.setBounds(20,30,150,50);
        this.add(L1);
        int x=0,y=0;
        l = new ArrayList<JRadioButton>();
        products = new ArrayList<String>();
        for (String k : value) {
            JRadioButton j = new JRadioButton();
            j.setText(k);
            products.add(k);
            j.setBounds(120+x,30,100,50);
            x+=120;
            l.add(j);
            this.add(j);
            G1.add(j);
        }
        jButton.setBounds(120,150,100,50);
        this.add(jButton);
        this.setTitle("Products");
        this.setBounds(50,50,1000,300);
        this.setVisible(true);

        jButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<products.size();i++) {
                    if(l.get(i).isSelected()) {
                        product = products.get(i);
                        //System.out.println(product+"####");
                    }
                }
                synchronized (wait) {
                    wait.notify();
                }
                setVisible(false);
            }
        });
    }

    public void MenuGUIForProductTypes() {
        this.setLayout(null);
        jButton = new JButton("Submit");
        //jButton.setText("Submit");
        G1 = new ButtonGroup();
        L1 = new JLabel("Product Types");
        L1.setBounds(20,30,150,50);
        this.add(L1);

        JRadioButton produce = new JRadioButton("Produce");
        produce.setBounds(120,30,100,50);
        this.add(produce);

        JRadioButton meat = new JRadioButton("Meat");
        meat.setBounds(240,30,100,50);
        this.add(meat);

        G1.add(meat);
        G1.add(produce);

        jButton.setBounds(120,150,100,50);
        this.add(jButton);
        this.setTitle("Buyer");
        this.setBounds(50,50,1000,300);
        this.setVisible(true);

        jButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                // If condition to check if jRadioButton2 is selected.
                if (produce.isSelected()) {
                    productType = 1;
                }
                else {
                    productType = 0;
                }
                synchronized (wait) {
                    wait.notify();
                }
                setVisible(false);
            }
        });


    }

    public void MenuGUIForTradingOptions() {
        this.setLayout(null);
        jButton = new JButton("Submit");
        //jButton.setText("Submit");
        G1 = new ButtonGroup();
        L1 = new JLabel("Select Option");
        L1.setBounds(20,30,150,50);
        this.add(L1);

        JRadioButton addmenu = new JRadioButton("Add to trading menu");
        addmenu.setBounds(120,30,200,50);
        this.add(addmenu);

        JRadioButton listBuyer = new JRadioButton("List all sellers");
        listBuyer.setBounds(320,30,200,50);
        this.add(listBuyer);

        G1.add(addmenu);
        G1.add(listBuyer);

        jButton.setBounds(120,150,100,50);
        this.add(jButton);
        this.setTitle("Buyer Options");
        this.setBounds(50,50,1000,300);
        this.setVisible(true);

        jButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                // If condition to check if jRadioButton2 is selected.
                if (addmenu.isSelected()) {
                    option = "add";
                }
                else if(listBuyer.isSelected()){
                    option = "list";
                }
                synchronized (wait) {
                    wait.notify();
                }
                setVisible(false);
            }
        });


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


}


