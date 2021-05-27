package Login;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



/**
 * @author alessioborgi
 * @created 03 / 05 / 2021 - 16:01
 * @project LOGIN
 */

public class Login_Start extends JFrame implements ActionListener {

    public static java.awt.Color bordeaux = new java.awt.Color(110, 34, 44);
    public static java.awt.Color darkgreen = new java.awt.Color(0, 150, 36);
    public static java.awt.Color black = new java.awt.Color(0, 0, 0);
    public static java.awt.Color orange = new java.awt.Color(249,166, 2);
    protected static JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel user = new JLabel("User: ");
    private JLabel password = new JLabel("Password: ");
    private JTextField username = new JTextField(20);
    private JPasswordField password_text = new JPasswordField();
    private JCheckBox show_password = new JCheckBox("Show Password");
    private JButton login = new JButton("Login");
    private JButton clear = new JButton("Clear");

    private JLabel cat_label = new JLabel();
    private JLabel acsai = new JLabel();
    private JLabel sapienza = new JLabel();
    private JLabel sapienza_1 = new JLabel();
    private JLabel java_item = new JLabel();
    private JLabel java_item_1 = new JLabel();
    private JLabel current_date = new JLabel();
    private JLabel current_time = new JLabel();



    public Login_Start() {
        setter();
        adder();
        addListeners();
        clock();
        pack();
    }


    private void setter(){
        frame.setBounds(200, 200,500, 540);
        panel.setBackground(orange);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        panel.setLayout(null);

        java_item.setBounds(0, 0, 115, 75);
        java_item.setIcon(new ImageIcon("img/java_2.jpeg"));
        cat_label.setBounds(115, 0, 270, 75);
        cat_label.setIcon(new ImageIcon("img/Programming.jpeg"));
        java_item_1.setBounds(385, 0, 115, 75);
        java_item_1.setIcon(new ImageIcon("img/java_2.jpeg"));

        user.setBounds(85, 180, 80, 25);
        user.setForeground(black);
        Font f = user.getFont();
        user.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        password.setBounds(85, 210, 80, 25);
        password.setForeground(black);
        password.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        username.setBounds(180, 180, 165, 25);
        password_text.setBounds(180, 210, 165, 25);
        show_password.setBackground(orange);
        show_password.setBounds(350,210,150,25);
        show_password.setForeground(black);
        show_password.setFont(f.deriveFont(f.getStyle() | Font.BOLD));

        login.setBounds(275, 250, 70, 25);
        login.setForeground(black);
        login.setIcon(new ImageIcon("img/login.png"));
        clear.setBounds(180, 250, 70, 25);
        clear.setForeground(black);
        clear.setIcon(new ImageIcon("img/clear1.png"));
        current_date.setBounds(0, 375, 150, 25);
        current_date.setForeground(black);
        current_date.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        current_time.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        current_time.setBounds(400, 375, 100, 25 );
        current_time.setForeground(black);
        sapienza.setBounds(0, 400, 115, 110);
        sapienza.setIcon(new ImageIcon("img/Sapienza_2.png"));
        acsai.setBounds(115, 400, 270, 110);
        acsai.setIcon(new ImageIcon("img/ACSAI_2.jpeg"));
        sapienza_1.setBounds(385, 400, 115, 110);
        sapienza_1.setIcon(new ImageIcon("img/Sapienza_2.png"));
        frame.setVisible(true);
    }

    private void adder(){
        frame.add(panel);
        panel.add(java_item);
        panel.add(cat_label);
        panel.add(java_item_1);
        panel.add(user);
        panel.add(username);
        panel.add(password);
        panel.add(password_text);
        panel.add(show_password);
        panel.add(login);
        panel.add(clear);
        panel.add(sapienza);
        panel.add(acsai);
        panel.add(sapienza_1);
        panel.add(current_date);
        panel.add(current_time);
    }

    public void clock(){
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Thread clock = new Thread(){
            public void run(){
                try {
                    for(;;) {     //Never Ending Loop (We could have also used the "while(true)"
                        Calendar cal = new GregorianCalendar();
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        int month = cal.get(Calendar.MONTH);
                        int year = cal.get(Calendar.YEAR);
                        int second = cal.get(Calendar.SECOND);
                        int minute = cal.get(Calendar.MINUTE);
                        int hour = cal.get(Calendar.HOUR);
                        current_time.setText("Time:" + hour + ":" + minute + ":" + second);
                        current_date.setText(" Date: " + months[month] + "/" + day + "/" + year);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }

    private void addListeners(){
        show_password.addActionListener(this);
        login.addActionListener(this);
        clear.addActionListener(this);
    }

    public void clear_all(){
        username.setText("");
        password_text.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if(button.getSource() == login){
            String userName = username.getText();
            String password = password_text.getText();
            if ((userName.trim().equals("admin") && password.trim().equals("admin")) ||
                    (userName.trim().equals("alessio") && password.trim().equals("borgi")) ||
                    (userName.trim().equals("francesco") && password.trim().equals("danese")) ||
                    (userName.trim().equals("federica") && password.trim().equals("valeau")) ||
                    (userName.trim().equals("elena") && password.trim().equals("muia"))){
                JOptionPane.showMessageDialog(frame, "Welcome Back " + userName + " \nIt's always a pleasure to see you again!");
                frame.dispose();
                Menu frame2 = new Menu();
                frame2.setVisible(true);
            } else if((userName.trim().equals("admin")) && !(password.trim().equals("admin"))){
                password_text.setText("");
                JOptionPane.showMessageDialog(frame, " Invalid Password... ");
            } else{
                clear_all();
                JOptionPane.showMessageDialog(frame, " Invalid Access... ");
            }
        }if(button.getSource() == clear){
            clear_all();
        }
        if (button.getSource() == show_password) {
            if (show_password.isSelected()) {
                password_text.setEchoChar((char) 0);
            } else {
                password_text.setEchoChar('•');
            }
        }
    }
}