package Map;

import javax.swing.*;

public class CityCounty {

    JFrame frame = new JFrame("World Map");
    JPanel background = new JPanel();
    JLabel image = new JLabel(new ImageIcon("map.png"));


    public CityCounty(){
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
