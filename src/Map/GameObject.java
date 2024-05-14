package Map;

public class GameObject {
    String countryName;
    int placeOnMap;

    public GameObject(String countryName, int placeOnMap){
        this.countryName = countryName;
        this.placeOnMap = placeOnMap;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public int getPlaceOnMap(){
        return placeOnMap;
    }

    public void setPlaceOnMap(int placeOnMap){
        this.placeOnMap = placeOnMap;
    }
}


/*JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setExtendedState(Frame.MAXIMIZED_BOTH);
            f.setLocationByPlatform(true);

            f.setContentPane(getUI());
            f.setResizable(false);
            f.pack();

            f.setVisible(true);*/