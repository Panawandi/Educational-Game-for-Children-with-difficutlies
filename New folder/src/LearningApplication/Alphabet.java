package LearningApplication;

import Language.Lowercase;
import Language.Uppercase;
import Support.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Alphabet {
    JFrame frame = new JFrame();
    JLabel label;
    ImageIcon image = new ImageIcon("langback1.png");

    JButton upper = new JButton("Uppercase letters");
    JButton lower = new JButton("Lowercase letters");
    JButton both = new JButton("Upper and lowercase letters");
    JButton back = new JButton(new ImageIcon("back.png"));

    public Alphabet(){
        frame.setSize(665, 480);
        frame.setLocationRelativeTo(null);

        label = new JLabel(image, JLabel.CENTER);
        label.setBounds(50,50, 650, 450);
        frame.add(label);


        //  Code for city button

        label.add(upper);
        upper.setBackground(Color.cyan);
        upper.setBounds(50,50,205,70);
        upper.setLocation(230,100);

        upper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    upper.setBackground(Color.yellow);
                }
            }
        });

        upper.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    upper.setBackground(Color.cyan);
                }
            }
        });

        upper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true){
                    frame.dispose();
                    Uppercase upperCase = new Uppercase();
                }
            }
        });


        //  Code for counties button

        label.add(lower);
        lower.setBackground(Color.cyan);
        lower.setBounds(50,50,205,70);
        lower.setLocation(230,200);

        lower.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    lower.setBackground(Color.yellow);
                }
            }
        });

        lower.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    lower.setBackground(Color.cyan);
                }
            }
        });

        lower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true){
                    frame.dispose();
                    Lowercase lowerCase = new Lowercase();
                }
            }
        });


        //  Code for city || counties button

        label.add(both);
        both.setVisible(false);
        both.setBackground(Color.cyan);
        both.setBounds(50,50,205,70);
        both.setLocation(230,300);

        both.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    both.setBackground(Color.yellow);
                }
            }
        });

        both.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    both.setBackground(Color.cyan);
                }
            }
        });

        both.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true){
                    frame.dispose();
                }
            }
        });

        //  Back button
        label.add(back);
        back.setBackground(Color.cyan);
        back.setBounds(15,40,70,50);
        back.setLocation(35,35);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(true){
                    frame.dispose();
                    MyFrame frame = new MyFrame();
                }
            }
        });

        frame.setUndecorated(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
