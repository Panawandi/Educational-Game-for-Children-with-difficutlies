package Language;

import Support.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Uppercase implements ActionListener {

    /* Target age  6-8
    / Different levels of difficulty depending on age
    / Add sounds effects
    / Hover over the game explaining or explain the game when starting game
    / Logout function
    / Focus on the mechanics of the game and then design
     */

    JFrame frame = new JFrame();
    JLabel label, label2;
    JPanel panel = new JPanel();
    JTextField field;
    JButton[] buttons = new JButton[5];
    JButton b2;
    ButtonGroup bg;
    int count = 0, current = 0;

    public Uppercase(){
        super();
        frame.setUndecorated(false);
        frame.setTitle("Language Game");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label = new JLabel();
        label2 = new JLabel(new ImageIcon("A.png"));

        frame.add(field = new JTextField(20));
        frame.add(panel);
        panel.setLayout(null);
        panel.setSize(1505,1005);
        panel.setBackground(Color.cyan);
        panel.add(label2);
        panel.add(label);

        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++){
            buttons[i] = new JButton();
            panel.add(buttons[i]);
            bg.add(buttons[i]);
        }

        buttons[0] = new JButton("Next");
        b2 = new JButton("Results");
        b2.setVisible(false);

        b2.addActionListener(this);
        buttons[0].addActionListener(this);

        panel.add(buttons[0]);
        panel.add(b2);
        set();

        label.setBounds(590, 550, 750, 40);
        label2.setBounds(430,120,650,450);
        buttons[0].setBounds(580, 720, 130, 30);
        b2.setBounds(720, 720, 130, 30);

        label.setText("Question 1: What letter is this?");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        label.setForeground(Color.RED);

        //label1.setText("Remember to answer in Upper-case/Lower-case, depending on what you see!");
        //label1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        //label1.setForeground(new Color(102-255-102));

        field.setBounds(650,660,130,20);

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttons[0]){
                    if (check())
                        count = count + 1;
                    current++;
                    set();
                    if (current == 9){
                        buttons[0].setEnabled(false);
                        b2.setVisible(true);
                        b2.setText("Home");
                        b2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (true){
                                    frame.dispose();
                                    MyFrame frame = new MyFrame();
                                }
                            }
                        });
                    }
                }

            }
        });

        frame.setVisible(true);
    }


    private void set() {
        buttons[0].setSelected(true);

        if (current == 0){
            label.setText("Question 1: What letter is this?");
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = field.getText();
                    if (answer.equals("A")){
                        System.out.println("Correct answer");
                        field.setText("");
                    } else if (answer != "A"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 1){
            label.setText("Question 2: What letter is this?");
            label2.setIcon(new ImageIcon("T.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer1 = field.getText();
                    if (answer1.equals("T")){
                        System.out.println("Correct answer");
                        field.setText("");
                    } else if (answer1 != "T"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 2){
            label.setText("Question 3: What letter is this?");
            label2.setIcon(new ImageIcon("I.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer2 = field.getText();
                    if (answer2.equals("I")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer2 != "I"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 3){
            label.setText("Question 4: What letter is this?");
            label2.setIcon(new ImageIcon("B.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer3 = field.getText();
                    if (answer3.equals("B")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer3 != "B"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 4){
            label.setText("Question 5: What letter is this?");
            label2.setIcon(new ImageIcon("E.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer4 = field.getText();
                    if (answer4.equals("E")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer4 != "E"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 5){
            label.setText("Question 6: What letter is this?");
            label2.setIcon(new ImageIcon("M.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer5 = field.getText();
                    if (answer5.equals("M")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer5.toString() != "M"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 6){
            label.setText("Question 7: What letter is this?");
            label2.setIcon(new ImageIcon("X.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer6 = field.getText();
                    if (answer6.equals("X")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer6 != "X"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 7){
            label.setText("Question 8: What letter is this?");
            label2.setIcon(new ImageIcon("P.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer7 = field.getText();
                    if (answer7.equals("P")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer7 != "P"){
                        field.setText("");
                    }
                }
            });
        }

        if (current == 8){
            label.setText("Question 9: What letter is this?");
            label2.setIcon(new ImageIcon("Q.png"));
            buttons[0].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer8 = field.getText();
                    if (answer8.equals("Q")){
                        System.out.println("Correct answer");
                        field.setText("");
                    }  else if (answer8 != "Q"){
                        field.setText("");
                    }
                }
            });
        }
        label.setBounds(590, 550, 750, 40);
    }

    private boolean check() {
        if (current == 0){
            buttons[0].setSelected(true);
        }
        if (current == 1){
            buttons[0].setSelected(true);
        }
        if (current == 2){
            buttons[0].setSelected(true);
        }
        if (current == 3){
            buttons[0].setSelected(true);
        }
        if (current == 4){
            buttons[0].setSelected(true);
        }
        if (current == 5){
            buttons[0].setSelected(true);
        }
        if (current == 6){
            buttons[0].setSelected(true);
        }
        if (current == 7){
            buttons[0].setSelected(true);
        }
        if (current == 8){
            buttons[0].setSelected(true);
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

