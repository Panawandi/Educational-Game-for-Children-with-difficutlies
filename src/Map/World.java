package Map;

import Support.MyFrame;
import Support.SoundManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;


public class World extends JFrame {

    boolean gameOver = false;
    ArrayList<GameObject> countriesObjectsList;
    public static final int SIZE = 600;
    BufferedImage image;
    Area area;
    ArrayList<Shape> countriesShapeList;
    private int questionCounter = 1;
    private int placeOnTheMap = 0;
    private int randomIndex = 0;
    private int score = 0;
    Timer timer;
    int count = 0;
    private final ActionListener wordTimer;

    /*
      Creates new form NewJFrame
     */
    public World() throws IOException {
        this.setTitle("World Map Game");
        initComponents();
        countriesObjectsList = new ArrayList<>();
        readCountries();
        image = ImageIO.read(new File("map.png"));
        long then = System.currentTimeMillis();
        System.out.println("" + then);
        area = getOutline(Color.WHITE, image, 12);
        long now = System.currentTimeMillis();
        countriesShapeList = separateShapeIntoCountries(area);
        lblImage.addMouseMotionListener(new MousePositionListener());
        setLocationRelativeTo(null);
        lblImage.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!gameOver) {
                    if (placeOnTheMap == countriesObjectsList.get(randomIndex).getPlaceOnMap()) {
                        lblResult.setText("Correct");
                        lblResult.setForeground(Color.GREEN);
                        SoundManager.play(SoundManager.isCorrect);
                        count = 0;
                        score += 1;
                    } else {
                        lblResult.setText("Wrong");
                        lblResult.setForeground(Color.red);
                        SoundManager.play(SoundManager.isInCorrect);
                        count = 0;
                    }
                    questionCounter += 1;
                    loadQuestion();
                }
            }
        });
        loadQuestion();
        refresh();
        wordTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameOver) {
                    if (count <= 10) {
                        lblTimer.setText(count + " seconds");
                        count++;
                    } else {
                        if (questionCounter <= 10) {
                            questionCounter += 1;
                            loadQuestion();
                            count = 0;
                        } else {
                            JOptionPane.showMessageDialog(null, "Your score is " + score, "Final Score", JOptionPane.INFORMATION_MESSAGE);
                            gameOver = true;
                            count = 0;
                            lblTimer.setText(count + " seconds");
                            lblQNo.setText("");
                            lblQuestion.setText("Click Reset Button to start new game");
                            timer.stop();
                        }
                    }
                }
            }
        };

        timer = new Timer(1000, wordTimer);
        if (questionCounter <= 10) {
            timer.start();
        }
    }

    /*
      This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        lblQNo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        lblTimer = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        home = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new Rectangle(0, 0, 0, 0));
        setPreferredSize(new Dimension(1235, 850));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 51, 0));
        jPanel1.setForeground(new Color(255, 0, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 49, Short.MAX_VALUE)
        );

        jLabel2.setFont(new Font("Tahoma", 1, 14));
        jLabel2.setText("World Map Quiz");

        lblResult.setFont(new Font("Tahoma", 1, 14));
        lblResult.setForeground(new Color(0, 153, 0));

        lblTimer.setFont(new Font("Tahoma", 1, 11));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        home.setText("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true){
                    dispose();
                    MyFrame frame1 = new MyFrame();
                }
            }
        });

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addContainerGap(632, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(460, 460, 560))
                        .addGroup(panelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblImage)
                                                        .addComponent(lblResult))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(lblQuestion)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(84, 84, 84))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(lblQNo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnReset)
                                                .addGap(80, 80, 80))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(home)
                                                .addGap(80, 80, 80))))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImage)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(lblQNo)
                                                .addGap(7, 7, 7)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblQuestion))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblResult)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 675, Short.MAX_VALUE)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(btnReset)
                                                .addComponent(home)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }

    public static void main(String[] args){
        if (true){
            try {
                World wo = new World();
                wo.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        if (timer != null) {
            timer = null;
        }
        gameOver = false;
        questionCounter = 1;
        count = 0;
        score = 0;
        loadQuestion();
        timer = new Timer(1000, wordTimer);
        if (questionCounter <= 10) {
            timer.start();
        }
    }

    // Variables declaration

    private JButton btnReset;
    private JButton home;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JLabel lblImage;
    private JLabel lblQNo;
    private JLabel lblQuestion;
    private JLabel lblResult;
    private JLabel lblTimer;
    private JPanel panel;

    // End of variables declaration

    public Area getOutline(Color target, BufferedImage bi, int tolerance) {
        // construct the GeneralPath
        GeneralPath gp = new GeneralPath();

        boolean cont = false;
        for (int i = 0; i < bi.getWidth(); i++) {
            for (int j = 0; j < bi.getHeight(); j++) {
                if (isIncluded(new Color(bi.getRGB(i, j)), target, tolerance)) {
                    if (cont) {
                        gp.lineTo(i, j);
                        gp.lineTo(i, j + 1);
                        gp.lineTo(i + 1, j + 1);
                        gp.lineTo(i + 1, j);
                        gp.lineTo(i, j);
                    } else {
                        gp.moveTo(i, j);
                    }
                    cont = true;
                } else {
                    cont = false;
                }
            }
            cont = false;
        }
        gp.closePath();

        return new Area(gp);
    }

    public static ArrayList<Shape> separateShapeIntoCountries(Shape shape) {
        ArrayList<Shape> countries = new ArrayList<>();

        PathIterator pathIterator = shape.getPathIterator(null);
        GeneralPath generalPath = new GeneralPath();
        while (!pathIterator.isDone()) {
            double[] coOrdinates = new double[6];
            int pathSegmentType = pathIterator.currentSegment(coOrdinates);
            int windingRule = pathIterator.getWindingRule();
            generalPath.setWindingRule(windingRule);
            switch (pathSegmentType) {
                case PathIterator.SEG_MOVETO:
                    generalPath = new GeneralPath();
                    generalPath.setWindingRule(windingRule);
                    generalPath.moveTo(coOrdinates[0], coOrdinates[1]);
                    break;
                case PathIterator.SEG_LINETO:
                    generalPath.lineTo(coOrdinates[0], coOrdinates[1]);
                    break;
                case PathIterator.SEG_QUADTO:
                    generalPath.quadTo(coOrdinates[0], coOrdinates[1], coOrdinates[2], coOrdinates[3]);
                    break;
                case PathIterator.SEG_CUBICTO:
                    generalPath.curveTo(coOrdinates[0], coOrdinates[1], coOrdinates[2], coOrdinates[3], coOrdinates[4], coOrdinates[5]);
                    break;
                case PathIterator.SEG_CLOSE:
                    generalPath.closePath();
                    countries.add(new Area(generalPath));
                    break;
                default:
                    System.err.println("Unexpected value! " + pathSegmentType);
                    break;
            }

            pathIterator.next();
        }

        return countries;
    }

    public static boolean isIncluded(Color target, Color pixel, int tolerance) {
        int rT = target.getRed();
        int gT = target.getGreen();
        int bT = target.getBlue();
        int rP = pixel.getRed();
        int gP = pixel.getGreen();
        int bP = pixel.getBlue();
        return ((rP - tolerance <= rT) && (rT <= rP + tolerance) && (gP - tolerance <= gT) && (gT <= gP + tolerance)
                && (bP - tolerance <= bT) && (bT <= bP + tolerance));
    }

    private void refresh() {
        lblImage.setIcon(new ImageIcon(getImage()));
    }

    private BufferedImage getImage() {
        BufferedImage bi = new BufferedImage(2 * SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        g.drawImage(image, 0, 0, lblImage);
        g.setColor(Color.WHITE);
        g.fill(area);
        g.setColor(Color.RED);
        g.draw(area);
        try {
            Point p = MouseInfo.getPointerInfo().getLocation();
            Point p1 = lblImage.getLocationOnScreen();
            int x = p.x - p1.x;
            int y = p.y - p1.y;
            Point pointOnImage = new Point(x, y);
            for (Shape shape : countriesShapeList) {
                if (shape.contains(pointOnImage)) {
                    g.setColor(Color.GREEN.darker());
                    g.fill(shape);
                    placeOnTheMap = countriesShapeList.indexOf(shape);
                    break;
                }
            }
        } catch (Exception doNothing) {
        }

        g.dispose();

        return bi;
    }

    class MousePositionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            refresh();
        }

    }

    public void readCountries() {
        Scanner input = null;
        try {
            input = new Scanner(new File("countries.txt"));
            input.useDelimiter("\r\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (input.hasNext()) {
            String name = input.next();
            int place = input.nextInt();
            GameObject country = new GameObject(name, place);
            countriesObjectsList.add(country);
        }

    }

    //loading questions and its answers in radio buttons
    private void loadQuestion() {
        if (questionCounter <= 10) {
            lblQNo.setText("Question # " + (questionCounter));
            Random rand = new Random();
            randomIndex = rand.nextInt(countriesObjectsList.size() - 1) + 1;
            lblQuestion.setText("Point out " + countriesObjectsList.get(randomIndex).getCountryName() + " on the Map");
        } else {
            JOptionPane.showMessageDialog(null, "Your score is " + score, "Final Score", JOptionPane.INFORMATION_MESSAGE);
            gameOver = true;
            count = 0;
            lblTimer.setText(count + " seconds");
            lblQNo.setText("");
            lblQuestion.setText("Click Reset Button to start new game");

            timer.stop();
        }
    }
}
