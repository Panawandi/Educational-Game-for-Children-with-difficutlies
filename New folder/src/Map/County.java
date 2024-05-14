package Map;

import javax.swing.*;

public class County {

    JFrame frame = new JFrame("Counties in the UK");
    JPanel background = new JPanel();
    JLabel image = new JLabel(new ImageIcon("counties.png"));

    public County(){
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //frame.add(background);
        //background.add(image);

        frame.add(image);
    }
}