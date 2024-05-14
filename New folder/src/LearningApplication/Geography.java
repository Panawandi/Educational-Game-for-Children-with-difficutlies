package LearningApplication;

import Map.City;
import Map.County;
import Map.World;
import Support.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Geography {
    JFrame frame = new JFrame();
    JLabel label;
    ImageIcon image = new ImageIcon("world.png");

    JButton cities = new JButton("Cities in the UK");
    JButton county = new JButton("Counties in the UK");
    JButton both = new JButton("Cities and counties in the UK");
    JButton back = new JButton(new ImageIcon("back.png"));

    public Geography(){
        frame.setSize(665, 480);
        frame.setLocationRelativeTo(null);

        label = new JLabel(image, JLabel.CENTER);
        label.setBounds(50,50, 650, 450);
        frame.add(label);


        //  Code for city button

        label.add(cities);
        cities.setBackground(Color.cyan);
        cities.setBounds(50,50,205,70);
        cities.setLocation(230,100);

        cities.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    cities.setBackground(Color.yellow);
                }
            }
        });

        cities.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    cities.setBackground(Color.cyan);
                }
            }
        });

        cities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true){
                    frame.dispose();
                    City city = new City();
                }
            }
        });


        //  Code for counties button

        label.add(county);
        county.setBackground(Color.cyan);
        county.setBounds(50,50,205,70);
        county.setLocation(230,200);

        county.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (true){
                    county.setBackground(Color.yellow);
                }
            }
        });

        county.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (true){
                    county.setBackground(Color.cyan);
                }
            }
        });

        county.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true){
                    frame.dispose();
                    County counties = new County();
                }
            }
        });


        //  Code for city || counties button

        label.add(both);
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
                try {
                    World myWorld = new World();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });

        //  Back button
        label.add(back);
        back.setBackground(Color.cyan);
        back.setBounds(15,40,80,58);
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
