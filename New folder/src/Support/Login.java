package Support;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel background = new JLabel(new ImageIcon("Login.png"));   // background image for login screen
    JLabel boy = new JLabel(new ImageIcon("boy.png"));   // background image for login screen
    JLabel girl = new JLabel(new ImageIcon("girl.png"));   // background image for login screen
    JTextField userText = new JTextField(35);
    JPasswordField passwordText = new JPasswordField(35);
    JButton button = new JButton("LOGIN");
    private static JLabel success;

    public Login(){

        //  Frame code

        setSize(865,587);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Learning Application - Individual Capstone Project - Login");
        setLayout(null);
        SoundManager.play(SoundManager.bgMusic);
        add(boy);
        add(girl);

        // Panels

        add(panel);
        panel.setSize(850,550);
        panel.add(background);
        background.add(button);

        add(panel1);
        panel1.setSize(430,40);
        panel1.setLocation(240,257);

        add(panel2);
        panel2.setSize(430,40);
        panel2.setLocation(240,317);

        add(panel3);
        panel3.setSize(200,200);
        panel3.setLocation(315,340);

        userText.setBounds(250, 150, 165, 25);
        userText.addKeyListener(new Keys());
        panel1.add(userText);


        passwordText.setBounds(250, 150, 165, 25);
        passwordText.addKeyListener(new Keys());
        panel2.add(passwordText);


        /* Button

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();
                System.out.println(user + ", " + password);

                if (user.equals("Dilovan") && password.equals("Panawandi")){
                    success.setText("                   Success!");
                    dispose();
                    MyFrame frame = new MyFrame();
                } else {
                    if (user.equals("Dilovan") || password.equals("Panawandi")){
                        success.setText(" Wrong username AND/OR password!");
                    }
                }

            }
        }); */

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    //  Connecting our database to the login form
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSl=false", "root", "Pandawandi110200");

                    String user = userText.getText();
                    String pass = passwordText.getText();

                    Statement stm = con.createStatement();

                    //String query = "select * from `usernames` where `username` =? & `password` =?";
                    String query = "select * from usernames where username ='"+user+"' and password ='"+pass+"'";
                    ResultSet rs = stm.executeQuery(query);

                    if (rs.next()){
                        dispose();
                        MyFrame frame = new MyFrame();
                    } else {
                        success.setText(" Incorrect username/password! ");
                        userText.setText("");
                        passwordText.setText("");
                    }

                    con.close();

                } catch (Exception ex){
                    ex.getMessage();
                }
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    button.setBackground(Color.yellow);
                }
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    button.setBackground(Color.cyan);
                }
            }
        });

        button.setBounds(100,100,135,55);
        button.setLocation(350,366);
        button.setFont(new Font("Times New Roman", Font.BOLD, 20));
        button.setBackground(Color.cyan);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);

        // Success

        success = new JLabel("");
        success.setBounds(237,225,300,25);
        panel3.add(success);

        setVisible(true);

    }
/*
    private void setUserTextFocusGained(){
        if (userText.getText().equals("")){
            userText.setText("Enter username..");
        } else {
            setUserTextFocusLost();
        }
    }

    private void setUserTextFocusLost(){
        if (userText.getText().equals("Enter username..")){
            userText.setText("");
        }
    }*/

}
