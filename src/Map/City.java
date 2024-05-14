package Map;

import javax.swing.*;

public class City {

    JFrame frame = new JFrame("Cities in the UK");
    JPanel background = new JPanel();
    JLabel image = new JLabel(new ImageIcon("map.png"));

    public City(){
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.add(background);
        background.add(image);
    }
}
