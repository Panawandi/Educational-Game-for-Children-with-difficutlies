package Support;

import LearningApplication.Alphabet;
import LearningApplication.Animals;
import Map.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame {

    JFrame frame = new JFrame("An Educational Game for Autistic Children");
    JLabel background = new JLabel();
    ImageIcon img = new ImageIcon("background.png");
    JButton alphabetPuzzle, animalPuzzle, mapPuzzle, sportPuzzle, musicSett, soundSett;
    static boolean doStop = true;
    static boolean doStart = false;
    SoundManager sound = new SoundManager();

    public MyFrame(){

        // Code for frame
        frame.setLayout(null);
        frame.setUndecorated(true);      // decides to keep taskbar or not
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);       // Sets fullscreen
        frame.setTitle("Learning Application - Individual Capstone Project");


        // Code for background image0
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0,0, 1505, 1005);
        frame.add(background);    // Add background label to frame


        //  Alphabet button

        //alphabet = new ImageIcon("alphabet.png");     Adding image to button
        alphabetPuzzle = new JButton("Alphabet");
        alphabetPuzzle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        alphabetPuzzle.setBackground(Color.cyan);
        alphabetPuzzle.setBounds(100,100,192,110);
        alphabetPuzzle.setLocation(221,456);
        alphabetPuzzle.setContentAreaFilled(true);  // makes button invincible
        alphabetPuzzle.setBorderPainted(false);  // makes border paint invincible

        //  When I hover my mouse over the button it changes colour
        alphabetPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    alphabetPuzzle.setBackground(Color.YELLOW);
                }
            }
        });

        //  When hovering exited button goes to default colour
        alphabetPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    alphabetPuzzle.setBackground(Color.cyan);
                }
            }
        });

        alphabetPuzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Alphabet alpha = new Alphabet();
            }
        });
        background.add(alphabetPuzzle);


        //  Animal button

        animalPuzzle = new JButton("Animals");
        animalPuzzle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        animalPuzzle.setBackground(Color.cyan);
        animalPuzzle.setBounds(100,100,194,110);
        animalPuzzle.setLocation(503,456);
        animalPuzzle.setContentAreaFilled(true);
        animalPuzzle.setBorderPainted(false);

        animalPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    animalPuzzle.setBackground(Color.YELLOW);
                }
            }
        });

        animalPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    animalPuzzle.setBackground(Color.cyan);
                }
            }
        });

        animalPuzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Animals animal = new Animals();
            }
        });
        background.add(animalPuzzle);


        //  Sky button

        mapPuzzle = new JButton("World Map");
        mapPuzzle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        mapPuzzle.setBackground(Color.cyan);
        mapPuzzle.setBounds(100,100,194,110);
        mapPuzzle.setLocation(788,456);
        mapPuzzle.setContentAreaFilled(true);
        mapPuzzle.setBorderPainted(false);

        mapPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    mapPuzzle.setBackground(Color.YELLOW);
                }
            }
        });

        mapPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    mapPuzzle.setBackground(Color.cyan);
                }
            }
        });

        mapPuzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                if (true){
                    try {
                        World wo = new World();
                        wo.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        background.add(mapPuzzle);


        //  Sports button

        sportPuzzle = new JButton("Sports");
        sportPuzzle.setFont(new Font("Times New Roman", Font.BOLD, 18));
        sportPuzzle.setBackground(Color.cyan);
        sportPuzzle.setBounds(100,100,193,110);
        sportPuzzle.setLocation(1069,456);
        sportPuzzle.setContentAreaFilled(true);
        sportPuzzle.setBorderPainted(false);

        sportPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    sportPuzzle.setBackground(Color.YELLOW);
                }
            }
        });

        sportPuzzle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    sportPuzzle.setBackground(Color.cyan);
                }
            }
        });

        sportPuzzle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sportPuzzle.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Unavailable");
                    }
                });
            }
        });
        background.add(sportPuzzle);


        // Music on/off button

        musicSett = new JButton("Music On/Off");
        musicSett.setFont(new Font("Times New Roman", Font.BOLD, 16));
        musicSett.setBackground(Color.cyan);
        musicSett.setBounds(100,100,290,80);
        musicSett.setLocation(295,592);
        musicSett.setContentAreaFilled(true);
        musicSett.setBorderPainted(false);


        musicSett.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    musicSett.setBackground(Color.YELLOW);
                }
            }
        });

        musicSett.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    musicSett.setBackground(Color.cyan);
                }
            }
        });

        musicSett.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // turn music off and on action
                    if (doStop && SoundManager.bgMusic.isActive()){
                        SoundManager.bgMusic.stop();
                        System.out.println("Music off");
                    } else {
                        SoundManager.play(SoundManager.bgMusic);
                        System.out.println("Music on");
                    }
            }
        });
        background.add(musicSett);


        //  SFX on/off button

        soundSett = new JButton("Sounds On/Off");
        soundSett.setFont(new Font("Times New Roman", Font.BOLD, 16));
        soundSett.setBackground(Color.cyan);
        soundSett.setBounds(100,100,320,80);
        soundSett.setLocation(895,595);
        soundSett.setContentAreaFilled(true);
        soundSett.setBorderPainted(false);

        soundSett.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    soundSett.setBackground(Color.YELLOW);
                }
            }
        });

        soundSett.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    soundSett.setBackground(Color.cyan);
                }
            }
        });

        soundSett.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sound Off/On");
            }
        });
        background.add(soundSett);

        frame.setVisible(true);

    }

}
