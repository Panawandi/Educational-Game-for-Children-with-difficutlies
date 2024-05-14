package LearningApplication;

import Support.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Animals extends Component implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label, label2;
    JPanel panel = new JPanel();
    JRadioButton radioButton[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0;

    public Animals(){
        super();
        frame.setLayout(null);
        frame.setUndecorated(false);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setTitle("Animal Game");

        label = new JLabel();
        label2 = new JLabel(new ImageIcon("hinny.png"));
        frame.add(panel);
        panel.setLayout(null);
        panel.setSize(1505,1005);
        panel.setBackground(Color.cyan);
        panel.add(label2);
        panel.add(label);


        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++){
            radioButton[i] = new JRadioButton();
            panel.add(radioButton[i]);
            bg.add(radioButton[i]);
        }

        b1 = new JButton("Next");
        b2 = new JButton("Results");
        b2.setVisible(false);

        b1.addActionListener(this);
        b2.addActionListener(this);

        panel.add(b1);
        panel.add(b2);
        set();

        label.setBounds(200,240,450,20);
        label2.setBounds(330,-20,1250,920);

        radioButton[0].setBounds(200,285,200,20);
        radioButton[0].setBackground(Color.yellow);
        radioButton[1].setBounds(200,315,200,20);
        radioButton[1].setBackground(Color.yellow);
        radioButton[2].setBounds(200,345,200,20);
        radioButton[2].setBackground(Color.yellow);
        radioButton[3].setBounds(200,375,200,20);
        radioButton[3].setBackground(Color.yellow);
        b1.setBounds(200,540,100,30);
        b2.setBounds(340,540,100,30);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9){
                b1.setEnabled(false);
                b2.setVisible(true);
                b2.setText("Results");
            }
        }

        if (e.getActionCommand().equals("Results")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(null, "Correct answers: " + count);
            frame.dispose();
            MyFrame frame1 = new MyFrame();
        }
    }

    // setting questions with options
    private void set() {
        radioButton[4].setSelected(true);
        if (current == 0){
            label.setText("Question 1: What animal is this?");
            radioButton[0].setText("Horse");
            radioButton[1].setText("Mule");
            radioButton[2].setText("Donkey");
            radioButton[3].setText("Hinny");
        }
        if (current == 1){
            label.setText("Question 2: What animal is this?");
            radioButton[0].setText("Porpoise");
            radioButton[1].setText("Tropical Bottlenose Whale");
            radioButton[2].setText("Dolphin");
            radioButton[3].setText("Blue Whale");
            label2.setIcon(new ImageIcon("porpoises.png"));
        }
        if (current == 2){
            label.setText("Question 3: What animal is this?");
            radioButton[0].setText("Puma");
            radioButton[1].setText("Cheetah");
            radioButton[2].setText("Leopards");
            radioButton[3].setText("Jaguar");
            label2.setIcon(new ImageIcon("cheetah.png"));
        }
        if (current == 3){
            label.setText("Question 4: What animal is this?");
            radioButton[0].setText("Monkey");
            radioButton[1].setText("Gorilla");
            radioButton[2].setText("Sloth");
            radioButton[3].setText("Chimpanzee");
            label2.setIcon(new ImageIcon("Chimp.png"));
        }
        if (current == 4){
            label.setText("Question 5: What animal is this?");
            radioButton[0].setText("Ferret");
            radioButton[1].setText("Raccoon");
            radioButton[2].setText("Otter");
            radioButton[3].setText("Meerkat");
            label2.setIcon(new ImageIcon("raccoon.png"));
        }
        if (current == 5){
            label.setText("Question 6: What animal is this?");
            radioButton[0].setText("Polar Bear");
            radioButton[1].setText("Brown Bear");
            radioButton[2].setText("Panda");
            radioButton[3].setText("Sun Bear");
            label2.setIcon(new ImageIcon("panda.png"));
        }
        if (current == 6){
            label.setText("Question 7: What animal is this?");
            radioButton[0].setText("Ayrshire Cow");
            radioButton[1].setText("Zebu");
            radioButton[2].setText("Guernsey Cow");
            radioButton[3].setText("Jersey Cow");
            label2.setIcon(new ImageIcon("zebu.png"));
        }
        if (current == 7){
            label.setText("Question 8: What animal is this?");
            radioButton[0].setText("Hampshire Boar");
            radioButton[1].setText("Berkshire Boar");
            radioButton[2].setText("Landrace");
            radioButton[3].setText("Wild Boar");
            label2.setIcon(new ImageIcon("wild.png"));
        }
        if (current == 8){
            label.setText("Question 9: What animal is this?");
            radioButton[0].setText("Siberian Husky");
            radioButton[1].setText("Pit Bull");
            radioButton[2].setText("Bulldog");
            radioButton[3].setText("Golden retriever");
            label2.setIcon(new ImageIcon("husky.png"));
        }
        label.setBounds(200,170,200,20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(200,210 + i, 200, 20);
    }

    private boolean check() {
        if (current == 0)
            return (radioButton[3].isSelected());
        if (current == 1)
            return (radioButton[0].isSelected());
        if (current == 2)
            return (radioButton[1].isSelected());
        if (current == 3)
            return (radioButton[3].isSelected());
        if (current == 4)
            return (radioButton[1].isSelected());
        if (current == 5)
            return (radioButton[2].isSelected());
        if (current == 6)
            return (radioButton[1].isSelected());
        if (current == 7)
            return (radioButton[3].isSelected());
        if (current == 8)
            return (radioButton[0].isSelected());
        return false;
    }
}
