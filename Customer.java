
import Datenstrukturen.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Customer {

    private final List<Integer> einkaufsListe = new List<>();

    private final JLabel myCustomer = new JLabel();
    private final ImageIcon customerIconFront;
    private final ImageIcon customerIconRight;

    public Customer() {
        myCustomer.setText("");
        
        //zufälliges Aussehen generieren
        int optik = (int) (Math.random() * 2);
        if (optik == 0) {
            customerIconFront = new ImageIcon("Grafiken/customerFront.png");
            customerIconRight = new ImageIcon("Grafiken/customerRight.png");
        } else {
            customerIconFront = new ImageIcon("Grafiken/customer2Front.png");
            customerIconRight = new ImageIcon("Grafiken/customer2Right.png");
        }
        
         // zufällige Einkaufsliste generieren
        int anzahlWaren = (int) (2 + Math.random() * 4);
        System.out.println(anzahlWaren);
        for (int i = 0; i < anzahlWaren; i++) {
            int ware = (int) (Math.random() * 7);
            einkaufsListe.append(ware);
        }
    }

    public JLabel getFrontImage() {
        myCustomer.setIcon(customerIconFront);
        return myCustomer;
    }

    public JLabel getRightImage() {
        myCustomer.setIcon(customerIconRight);
        return myCustomer;
    }

    public List<Integer> getEinkaufsliste() {
        return einkaufsListe;
    }

}
