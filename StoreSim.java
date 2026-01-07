
import Datenstrukturen.Queue;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class StoreSim extends JFrame implements KeyListener{
    // Anfang Attribute
    Graphics graph;

    //Movement Attributes
    boolean w,a,s,d = false;

    //Datenstrukturen
    Queue<Customer> customerQueue = new Queue<>();
    java.util.List<Rectangle> allowedZones = new ArrayList<>();

    // Spielattribute
    int anzahlBananen = 0;
    int anzahlAepfel = 0;
    int anzahlKohlrabi = 0;
    int anzahlPaprika = 0;
    int anzahlHackfleisch = 0;
    int anzahlRumpsteak = 0;
    int geld = 200;

    //Game Objects
    private final Cashier myCashier = new Cashier();

    //Timer
    private final Timer customerTimer;
    private final Timer cashierMovementTimer;

    //Java Editor
    private final JLabel background = new JLabel();
    private final ImageIcon backgroundIcon = new ImageIcon("images/gameworld.png");
    private final Container cp;
    private final JLabel einkaufslisteLabel = new JLabel();
    private final JButton kundeBedienenButton = new JButton();
    private final JTextArea einkaufslisteTextArea = new JTextArea("");
    private final JScrollPane einkaufslisteTextAreaScrollPane = new JScrollPane(einkaufslisteTextArea);
    private final JButton bananenButton = new JButton();
    private final JButton aepfelButton = new JButton();
    private final JButton kohlrabiButton = new JButton();
    private final JButton paprikaButton = new JButton();
    private final JButton hackfleischButton = new JButton();
    private final JButton rumpsteakButton = new JButton();
    private final JLabel bananenLabel = new JLabel();
    private final JLabel aepfelLabel = new JLabel();
    private final JLabel kohlrabiLabel = new JLabel();
    private final JLabel paprikaLabel = new JLabel();
    private final JLabel hackfleischLabel = new JLabel();
    private final JLabel rumpsteakLabel = new JLabel();
    private final JLabel kaufButtonLabel = new JLabel();
    private final JLabel spielstandLabel = new JLabel();
    private final JLabel geldTextLabel = new JLabel();
    private final JLabel geldLabel = new JLabel();
    private final JButton wegschickenButton = new JButton();
    private final JButton startButton = new JButton();
    private final JLabel bananenTextLabel = new JLabel();
    private final JLabel aepfelTextLabel = new JLabel();
    private final JLabel kohlrabiTextLabel = new JLabel();
    private final JLabel paprikaTextLabel = new JLabel();
    private final JLabel hackTextLabel = new JLabel();
    private final JLabel RumpsteakTextLabel = new JLabel();
    // Ende Attribute

    public StoreSim(String title) {
        // Frame-Initialisierung
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 903;
        int frameHeight = 775;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        cp = getContentPane();
        cp.setLayout(null);
        background.setBounds(0, 0, 1000, 800);
        background.setText("");
        background.setBackground(Color.YELLOW);
        background.setOpaque(true);
        background.setIcon(backgroundIcon);
        // Anfang Komponenten 
        einkaufslisteLabel.setBounds(432, 152, 150, 25);
        einkaufslisteLabel.setText("Einkaufsliste");
        einkaufslisteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        einkaufslisteLabel.setBackground(new Color(0xFFC800));
        einkaufslisteLabel.setOpaque(true);
        einkaufslisteTextArea.setFocusable(false);

        kundeBedienenButton.setBounds(432, 320, 150, 25);
        kundeBedienenButton.setText("Kunde bedienen");
        kundeBedienenButton.setMargin(new Insets(2, 2, 2, 2));
        kundeBedienenButton.addActionListener(evt -> kundeBedienenButton_ActionPerformed(evt));
        kundeBedienenButton.setFocusable(false);
        einkaufslisteTextAreaScrollPane.setBounds(432, 192, 145, 97);
        bananenButton.setBounds(784, 400, 90, 25);
        bananenButton.setText("Bananen (10)");
        bananenButton.setMargin(new Insets(2, 2, 2, 2));
        bananenButton.addActionListener(evt -> bananenButton_ActionPerformed(evt));
        bananenButton.setFocusable(false);

        aepfelButton.setBounds(784, 430, 90, 25);
        aepfelButton.setText("Äpfel (2)");
        aepfelButton.setMargin(new Insets(2, 2, 2, 2));
        aepfelButton.addActionListener(evt -> aepfelButton_ActionPerformed(evt));
        aepfelButton.setFocusable(false);

        kohlrabiButton.setBounds(784, 460, 90, 25);
        kohlrabiButton.setText("Kohlrabi (8)");
        kohlrabiButton.setMargin(new Insets(2, 2, 2, 2));
        kohlrabiButton.addActionListener(evt -> kohlrabiButton_ActionPerformed(evt));
        kohlrabiButton.setFocusable(false);

        paprikaButton.setBounds(784, 490, 90, 25);
        paprikaButton.setText("Paprika (3)");
        paprikaButton.setMargin(new Insets(2, 2, 2, 2));
        paprikaButton.addActionListener(evt -> paprikaButton_ActionPerformed(evt));
        paprikaButton.setFocusable(false);

        hackfleischButton.setBounds(784, 520, 90, 25);
        hackfleischButton.setText("Hack (10)");
        hackfleischButton.setMargin(new Insets(2, 2, 2, 2));
        hackfleischButton.addActionListener(evt -> hackfleischButton_ActionPerformed(evt));
        hackfleischButton.setFocusable(false);

        rumpsteakButton.setBounds(784, 550, 90, 25);
        rumpsteakButton.setText("Rumpsteak (25)");
        rumpsteakButton.setMargin(new Insets(2, 2, 2, 2));
        rumpsteakButton.addActionListener(evt -> rumpsteakButton_ActionPerformed(evt));
        rumpsteakButton.setFocusable(false);

        bananenLabel.setBounds(256, 632, 25, 25);
        bananenLabel.setText("0");
        bananenLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        bananenLabel.setForeground(Color.WHITE);

        aepfelLabel.setBounds(330, 632, 25, 25);
        aepfelLabel.setText("0");
        aepfelLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        aepfelLabel.setForeground(Color.WHITE);

        kohlrabiLabel.setBounds(463, 632, 25, 25);
        kohlrabiLabel.setText("0");
        kohlrabiLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        kohlrabiLabel.setForeground(Color.WHITE);

        paprikaLabel.setBounds(538, 632, 25, 25);
        paprikaLabel.setText("0");
        paprikaLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        paprikaLabel.setForeground(Color.WHITE);

        hackfleischLabel.setBounds(644, 632, 25, 25);
        hackfleischLabel.setText("0");
        hackfleischLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        hackfleischLabel.setForeground(Color.WHITE);

        rumpsteakLabel.setBounds(722, 632, 25, 25);
        rumpsteakLabel.setText("0");
        rumpsteakLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        rumpsteakLabel.setForeground(Color.WHITE);
        rumpsteakButton.setFont(new Font("Dialog", Font.BOLD, 10));

        kaufButtonLabel.setBounds(744, 352, 139, 33);
        kaufButtonLabel.setText("Waren einkaufen");
        kaufButtonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        kaufButtonLabel.setBackground(Color.GRAY);
        kaufButtonLabel.setOpaque(true);
        kaufButtonLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        kaufButtonLabel.setForeground(Color.WHITE);

        spielstandLabel.setBounds(744, 152, 139, 33);
        spielstandLabel.setText("Spielstand");
        spielstandLabel.setBackground(Color.GRAY);
        spielstandLabel.setOpaque(true);
        spielstandLabel.setForeground(Color.WHITE);
        spielstandLabel.setHorizontalAlignment(SwingConstants.CENTER);

        geldTextLabel.setBounds(744, 192, 75, 25);
        geldTextLabel.setText("Geld:");
        geldTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        geldTextLabel.setBackground(Color.WHITE);
        geldTextLabel.setOpaque(true);

        geldLabel.setBounds(832, 192, 43, 25);
        geldLabel.setText("0");
        geldLabel.setHorizontalAlignment(SwingConstants.CENTER);
        geldLabel.setBackground(Color.WHITE);
        geldLabel.setOpaque(true);

        wegschickenButton.setBounds(584, 192, 81, 97);
        wegschickenButton.setText("Wegschicken");
        wegschickenButton.setMargin(new Insets(2, 2, 2, 2));
        wegschickenButton.addActionListener(evt -> wegschickenButton_ActionPerformed(evt));
        wegschickenButton.setFont(new Font("Dialog", Font.BOLD, 10));
        wegschickenButton.setFocusable(false);

        startButton.setBounds(112, 584, 105, 41);
        startButton.setText("Start");
        startButton.setMargin(new Insets(2, 2, 2, 2));
        startButton.addActionListener(evt -> startButton_ActionPerformed(evt));
        startButton.setFocusable(false);

        bananenTextLabel.setBounds(240, 672, 59, 25);
        bananenTextLabel.setText("Bananen");
        bananenTextLabel.setBackground(Color.WHITE);
        bananenTextLabel.setOpaque(true);

        aepfelTextLabel.setBounds(320, 672, 35, 25);
        aepfelTextLabel.setText("Äpfel");
        aepfelTextLabel.setBackground(Color.WHITE);
        aepfelTextLabel.setOpaque(true);

        kohlrabiTextLabel.setBounds(448, 672, 51, 25);
        kohlrabiTextLabel.setText("Kohlrabi");
        kohlrabiTextLabel.setBackground(Color.WHITE);
        kohlrabiTextLabel.setOpaque(true);

        paprikaTextLabel.setBounds(528, 672, 51, 25);
        paprikaTextLabel.setText("Paprika");
        paprikaTextLabel.setBackground(Color.WHITE);
        paprikaTextLabel.setOpaque(true);

        hackTextLabel.setBounds(624, 672, 71, 25);
        hackTextLabel.setText("Hackfleisch");
        hackTextLabel.setBackground(Color.WHITE);
        hackTextLabel.setOpaque(true);

        RumpsteakTextLabel.setBounds(704, 672, 69, 25);
        RumpsteakTextLabel.setText("Rumpsteak");
        RumpsteakTextLabel.setBackground(Color.WHITE);
        RumpsteakTextLabel.setOpaque(true);
        requestFocusInWindow();
        addKeyListener(this);

        // Ende Komponenten
        redrawGraphics();
        setVisible(true);

        // Adding Timer
        customerTimer = new Timer(500, evt -> customerTimerTick(evt));

        cashierMovementTimer = new Timer(16, evt -> cashierMovementTimerTick(evt));
        cashierMovementTimer.start();

        allowedZones.add(new Rectangle(235, 262, 152, 145));
        allowedZones.add(new Rectangle(386, 350, 208, 57));
        allowedZones.add(new Rectangle(414, 407, 40, 70));
        allowedZones.add(new Rectangle(235, 477, 507, 94));
    }

    // Anfang Methoden
    public void kundeBedienenButton_ActionPerformed(ActionEvent evt) {
        Datenstrukturen.List<Integer> myList = customerQueue.front().getEinkaufsliste();

        // if (!myList.isEmpty()) {
        //     myCashier.startRoute(myList);
        //     List<Integer> tempList = customerQueue.front().getEinkaufsliste();
        //     tempList.toFirst();
        //     while (tempList.hasAccess()) {
        //         if (!checkStore(tempList.getContent())) {
        //             geld = geld - 50;
        //         }
        //         tempList.next();
        //     }
        //     cashierMovementTimer.start();

        // }

    }

    public boolean allowed(int newX, int newY) {
    for (Rectangle zone : allowedZones) {
        if (zone.contains(newX, newY)) {
            return true;
        }
    }
    return false;
}

    public void cashierMovementTimerTick(ActionEvent evt) {
        int dx = 0;
        int dy = 0;
        if(w) {dy--; System.out.println("w");}
        if(a) {dx--; System.out.println("a");}
        if(s) {dy++; System.out.println("s");}
        if(d) {dx++; System.out.println("d");}
        if(dx ==0 && dy == 0) return;
        int newx = myCashier.getX()+dx;
        int newy = myCashier.getY()+dy;
        if(allowed(newx, newy)){
            myCashier.move(dx,dy);
            redrawGraphics();
            System.out.println(myCashier.getX() + " " + myCashier.getY());
        }
    }

    public boolean checkStore(int nr) {
        boolean enough;
        switch (nr) {
            case 1 -> {
                enough = (anzahlBananen >= 0);
                anzahlBananen--;
                geld = geld + 20;
                return enough;
            }
            case 2 -> {
                enough = (anzahlAepfel >= 0);
                anzahlAepfel--;
                geld = geld + 4;
                return enough;
            }
            case 3 -> {
                enough = (anzahlKohlrabi >= 0);
                anzahlKohlrabi--;
                geld = geld + 16;
                return enough;
            }
            case 4 -> {
                enough = (anzahlPaprika >= 0);
                anzahlPaprika--;
                geld = geld + 6;
                return enough;
            }
            case 5 -> {
                enough = (anzahlHackfleisch >= 0);
                anzahlHackfleisch--;
                geld = geld + 20;
                return enough;
            }
            case 6 -> {
                enough = (anzahlRumpsteak >= 0);
                anzahlRumpsteak--;
                geld = geld + 25;
                return enough;
            }
            default -> {
                return false;
            }
        }
    }

    public void customerTimerTick(ActionEvent evt) {
        // generate Random Customer
        int rnd = (int) (Math.random() * 2);
        if (rnd == 0) {
            customerQueue.enqueue(new Customer());
        }
        redrawGraphics();
    }

    public void bananenButton_ActionPerformed(ActionEvent evt) {
        anzahlBananen++;
        geld = geld - 10;
        redrawGraphics();
    }

    public void aepfelButton_ActionPerformed(ActionEvent evt) {
        anzahlAepfel++;
        geld = geld - 2;
        redrawGraphics();
    }

    public void kohlrabiButton_ActionPerformed(ActionEvent evt) {
        anzahlKohlrabi++;
        geld = geld - 8;
        redrawGraphics();
    }

    public void paprikaButton_ActionPerformed(ActionEvent evt) {
        anzahlPaprika++;
        geld = geld - 3;
        redrawGraphics();
    }

    public void hackfleischButton_ActionPerformed(ActionEvent evt) {
        anzahlHackfleisch++;
        geld = geld - 10;
        redrawGraphics();
    }

    public void rumpsteakButton_ActionPerformed(ActionEvent evt) {
        anzahlRumpsteak++;
        geld = geld - 25;
        redrawGraphics();
    }

    public void wegschickenButton_ActionPerformed(ActionEvent evt) {
        customerQueue.dequeue();
        einkaufslisteTextArea.setText("");
        redrawGraphics();
    }

    public void startButton_ActionPerformed(ActionEvent evt) {

        if (startButton.getText().equals("Start")) {
            customerTimer.start();
            startButton.setText("Stop");
            redrawGraphics();
        } else {
            customerTimer.stop();
            startButton.setText("Start");
            redrawGraphics();
        }

    }

    @Override
    public void keyPressed(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){
        char key = e.getKeyChar();
        switch(key){
            case 'w':
                w = true;
                break;
            case 'a':
                a = true;
                break;
            case 's':
                s = true;
                break;
            case 'd':
                d = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case 87:
                w = false;
                break;
            case 65:
                a = false;
                break;
            case 83:
                s = false;
                break;
            case 68:
                d = false;
                break;
        }
    }


    // Ende Methoden
    public static void main(String[] args) {
        new StoreSim("StoreSim");
    }

    // Redraw the game graphics
    public void redrawGraphics() {
        // frist dump all components  
        cp.removeAll();

        // the components to be added (buttons etc.)
        cp.add(myCashier.getImage());
        cp.add(einkaufslisteTextAreaScrollPane);
        cp.add(einkaufslisteLabel);
        cp.add(startButton);
        cp.add(kundeBedienenButton);
        cp.add(wegschickenButton);
        cp.add(bananenButton);
        cp.add(aepfelButton);
        cp.add(kohlrabiButton);
        cp.add(paprikaButton);
        cp.add(hackfleischButton);
        cp.add(rumpsteakButton);
        cp.add(bananenLabel);
        cp.add(aepfelLabel);
        cp.add(kohlrabiLabel);
        cp.add(paprikaLabel);
        cp.add(hackfleischLabel);
        cp.add(rumpsteakLabel);
        cp.add(kaufButtonLabel);
        cp.add(spielstandLabel);
        cp.add(geldTextLabel);
        cp.add(geldLabel);
        cp.add(bananenTextLabel);
        cp.add(RumpsteakTextLabel);
        cp.add(hackTextLabel);
        cp.add(paprikaTextLabel);
        cp.add(kohlrabiTextLabel);
        cp.add(aepfelTextLabel);

        //updateInterface
        bananenLabel.setText(String.valueOf(anzahlBananen));
        aepfelLabel.setText(String.valueOf(anzahlAepfel));
        kohlrabiLabel.setText(String.valueOf(anzahlKohlrabi));
        paprikaLabel.setText(String.valueOf(anzahlPaprika));
        hackfleischLabel.setText(String.valueOf(anzahlHackfleisch));
        rumpsteakLabel.setText(String.valueOf(anzahlRumpsteak));
        geldLabel.setText(String.valueOf(geld));

        //draw Customers
        Queue<Customer> tempQueue = new Queue<>();
        int position = 1;
        boolean drawing = true;
        while (drawing) {
            Customer tempCustomer = customerQueue.front();
            JLabel tempLabel;
            if (tempCustomer == null) {
                drawing = false;
            } else {
                switch (position) {
                    case 1 -> {
                        tempLabel = tempCustomer.getFrontImage();
                        tempLabel.setBounds(280, 216, 28, 61);
                        cp.add(tempLabel);
                        tempQueue.enqueue(tempCustomer);
                        customerQueue.dequeue();
                        position++;

                        Datenstrukturen.List<Integer> tempList = tempCustomer.getEinkaufsliste();
                        tempList.toFirst();
                        String toAdd = "";
                        while (tempList.hasAccess()) {
                            int nr = tempList.getContent();
                            toAdd += switch (nr) {
                                case 1 -> "Bananen\n";
                                case 2 -> "Äpfel\n";
                                case 3 -> "Kohlrabi\n";
                                case 4 -> "Paprika\n";
                                case 5 -> "Hackfleisch\n";
                                case 6 -> "Rumpsteak\n";
                                default -> "";
                            };
                            tempList.next();
                        }
                        einkaufslisteTextArea.setText(toAdd);
                    }
                    case 2 -> {
                        tempLabel = tempCustomer.getRightImage();
                        tempLabel.setBounds(216, 185, 28, 61);
                        cp.add(tempLabel);
                        tempQueue.enqueue(tempCustomer);
                        customerQueue.dequeue();
                        position++;
                    }
                    case 3 -> {
                        tempLabel = tempCustomer.getRightImage();
                        tempLabel.setBounds(168, 160, 28, 61);
                        cp.add(tempLabel);
                        tempQueue.enqueue(tempCustomer);
                        customerQueue.dequeue();
                        position++;
                    }
                    case 4 -> {
                        tempLabel = tempCustomer.getRightImage();
                        tempLabel.setBounds(96, 160, 28, 61);
                        cp.add(tempLabel);
                        tempQueue.enqueue(tempCustomer);
                        customerQueue.dequeue();
                        position++;
                    }
                    case 5 -> {
                        tempLabel = tempCustomer.getRightImage();
                        tempLabel.setBounds(24, 160, 28, 61);
                        cp.add(tempLabel);
                        tempQueue.enqueue(tempCustomer);
                        customerQueue.dequeue();
                        position++;
                    }
                    default -> {
                        tempQueue.enqueue(tempCustomer);
                        customerQueue.dequeue();
                    }
                }
            }
        }
        customerQueue = tempQueue;

        // adding background as last component and repainting after the components have been added
        cp.add(background);
        cp.repaint();

        //checkWin
        if (geld > 10000) {
            customerTimer.stop();
            JOptionPane.showMessageDialog(null, "Gratulation!");
        } // end of if

    }

}
