package Language;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class test {

    /* Target age  6-8
    / Different levels of difficulty depending on age
    / Add sounds effects
    / Hover over the game explaining or explain the game when starting game
    / Logout function
    / Focus on the mechanics of the game and then design
     */

    JFrame frame = new JFrame();
    JLabel label,label1, label2;
    JTextField field;
    JButton[] buttons = new JButton[5];
    LinkedList myList = new LinkedList();
    LinkedList myAns = new LinkedList();
    Random rand = new Random();
    int numQuestion = 9;
    JButton b1, b2;
    JButton resultButton = new JButton();
    ButtonGroup bg;
    int count = 0, current = 0;

    public test(){
        super();
        frame.setUndecorated(false);
        frame.setTitle("Language Game");
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel(new ImageIcon("A.png"));

        frame.add(label);
        frame.add(label1);
        frame.add(label2);
        frame.add(field = new JTextField(20));

        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++){
            buttons[i] = new JButton();
            frame.add(buttons[i]);
            bg.add(buttons[i]);
        }

        for (int i = 0; i < numQuestion; i++){}
        while (!myList.isEmpty()){
            int randQu = rand.nextInt(numQuestion);
            System.out.println(myList.remove(randQu));
        }

        myList.add("Which letter is this?");
        myAns.add("Cairo");

        b1 = new JButton("Next");
        b2 = new JButton("Next");
        resultButton = new JButton("Results");
        resultButton.setVisible(false);

        b1.addActionListener(null);
        b2.addActionListener(null);
        resultButton.addActionListener(null);

        frame.add(b1);
        frame.add(b2);
        b2.setVisible(false);
        frame.add(resultButton);

        label.setBounds(590, 550, 750, 40);
        label1.setBounds(370, 600, 750, 40);
        label2.setBounds(430,120,650,450);

        label.setText("Question 1: What letter is this?");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        label.setForeground(new Color(102-255-102));

        label1.setText("Remember to answer in Upper-case/Lower-case, depending on what you see!");
        label1.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        //label1.setForeground(new Color(102-255-102));

        field.setBounds(650,660,130,20);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1){
                    if (current == 9){
                        b1.setEnabled(false);
                        resultButton.setVisible(true);
                        resultButton.setText("Results");
                    }
                }
            }
        });

        if (current == 0){
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer = field.getText();
                    if (answer.equals("A")){
                        field.setText("");
                        System.out.println("Good job!");
                        current = 1;
                        label.setText("Question 2: What letter is this?");
                        label2.setIcon(new ImageIcon("B.png"));
                    } else if (answer != "A"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 1){
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer1 = field.getText();
                    if (answer1.equals("B")){
                        field.setText("");
                        System.out.println("Good job!");
                        current = 2;
                    } else if (answer1 != "B"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 2){
            label.setText("Question 3: What letter is this?");
            label2.setIcon(new ImageIcon("C.png"));
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer2 = field.getText();
                    if (answer2.equals("C")){
                        field.setText("");
                        System.out.println("Correct answer");
                    } else if (answer2 != "C"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }
/*
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Results")){
                    if (check())
                        count = count + 1;
                    current++;
                    JOptionPane.showMessageDialog(null, "Correct answers: " + count);
                    System.exit(0);
                }
            }
        });*/

        b1.setBounds(580, 720, 130, 30);
        b2.setBounds(580, 720, 130, 30);
        resultButton.setBounds(680, 800, 130, 30);

        frame.setVisible(true);
    }

/*
        if (current == 3){
            label.setText("Question 4: What letter is this?");
            label2.setIcon(new ImageIcon("D.png"));
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer3 = field.getText();
                    if (answer3.equals("D")){
                        field.setText("");
                        System.out.println("Correct answer");
                    } else if (answer3 != "D"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 4){
            label.setText("Question 5: What letter is this?");
            label2.setIcon(new ImageIcon("E.png"));
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer4 = field.getText();
                    if (answer4.equals("E")){
                        System.out.println("Correct answer");
                        field.setText("");
                        label.setText("Question 6: What letter is this?");
                        label2.setIcon(new ImageIcon("F.png"));
                    } else if (answer4 != "E"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 5){
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer5 = field.getText();
                    if (answer5.equals("F")){
                        System.out.println("Correct answer");
                        field.setText("");
                        label.setText("Question 7: What letter is this?");
                        label2.setIcon(new ImageIcon("G.png"));
                    } else if (answer5 != "F"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 6){
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer6 = field.getText();
                    if (answer6.equals("G")){
                        System.out.println("Correct answer");
                        field.setText("");
                        label.setText("Question 8: What letter is this?");
                        label2.setIcon(new ImageIcon("H.png"));
                    } else if (answer6 != "G"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 7){
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer7 = field.getText();
                    if (answer7.equals("H")){
                        System.out.println("Correct answer");
                        field.setText("");
                        label.setText("Question 9: What letter is this?");
                        label2.setIcon(new ImageIcon("I.png"));
                    } else if (answer7 != "H"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        }

        if (current == 8){
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String answer8 = field.getText();
                    if (answer8.equals("I")){
                        System.out.println("Correct answer");
                        field.setText("");
                    } else if (answer8 != "I"){
                        System.out.println("Please, try again.");
                    }
                }
            });
        } */
}


