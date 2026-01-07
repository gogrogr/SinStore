
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cashier{

    private final String back = "Grafiken/cashierBack.png";
    private final String left = "Grafiken/cashierLeft.png";
    private final String right = "Grafiken/cashierRight.png";

    private final JLabel myCashier = new JLabel();
    private final ImageIcon cashierIcon = new ImageIcon("Grafiken/cashierBack.png");

    private int currentStep;
    private boolean moving;

    

    int x = 280;
    int y = 264;

    //waypoints
    //private int[] waypoints;
    //private final int[] waypointsToStorage = {280, 264, 295, 290, 312, 320, 368, 360, 416, 392, 440, 456};
    //private final int[] waypointsStorageToOne = {392, 512, 328, 528, 310, 552, 290, 592};
    //private final int[] waypointsStorageToTwo = {392, 496, 368, 528, 362, 552, 360, 592};
    //private final int[] waypointsStorageToThree = {448, 496, 480, 528, 488, 552, 496, 592};
    //private final int[] waypointsStorageToFour = {480, 496, 540, 528, 568, 552, 570, 592};
    //private final int[] waypointsStorageToFive = {480, 496, 568, 528, 640, 552, 672, 592};
    //private final int[] waypointsStorageToSix = {480, 496, 568, 528, 680, 552, 744, 592};

    public Cashier() {
        currentStep = 0;
        moving = false;
        myCashier.setBounds(x, y, 28, 61);
        myCashier.setText("");
        myCashier.setIcon(cashierIcon);
    }


    public JLabel getImage() {
        myCashier.setBounds(x, y, 28, 61);
        return myCashier;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void move(int x1, int y1){
        x += x1;
        y += y1;
    }

    public void setMoving(boolean ismoving){
        moving = ismoving;
    }

    // Passing a list of information about the route
    // integer 1-6 for each individual storage area
    // public void startRoute(List<Integer> waypointList) {
    //     if (waypointList != null && !waypointList.isEmpty()) {
    //         waypointList.toFirst();
    //         waypoints = waypointsToStorage;

    //         while (waypointList.hasAccess()) {
    //             int temp = waypointList.getContent();
    //             moving = true;
    //             switch (temp) {
    //                 case 1 -> {
    //                     waypoints = concat(waypoints, waypointsStorageToOne);
    //                     waypoints = concat(waypoints, reverse(waypointsStorageToOne));
    //                 }
    //                 case 2 -> {
    //                     waypoints = concat(waypoints, waypointsStorageToTwo);
    //                     waypoints = concat(waypoints, reverse(waypointsStorageToTwo));
    //                 }
    //                 case 3 -> {
    //                     waypoints = concat(waypoints, waypointsStorageToThree);
    //                     waypoints = concat(waypoints, reverse(waypointsStorageToThree));
    //                 }
    //                 case 4 -> {
    //                     waypoints = concat(waypoints, waypointsStorageToFour);
    //                     waypoints = concat(waypoints, reverse(waypointsStorageToFour));
    //                 }
    //                 case 5 -> {
    //                     waypoints = concat(waypoints, waypointsStorageToFive);
    //                     waypoints = concat(waypoints, reverse(waypointsStorageToFive));
    //                 }
    //                 case 6 -> {
    //                     waypoints = concat(waypoints, waypointsStorageToSix);
    //                     waypoints = concat(waypoints, reverse(waypointsStorageToSix));
    //                 }
    //             }
    //             waypointList.next();
    //         }
    //         waypoints = concat(waypoints, reverse(waypointsToStorage));
    //     }
    // }

    // // When moving has been set to true this method will trigger the movement
    // // The movement will be based on the content of the array waypoints
    // public void nextStep() {
    //     int old = currentStep;
    //     currentStep++;
    //     // changing the images and setting new Location
    //     if (!(currentStep * 2 >= waypoints.length - 1)) {

    //         // change location
    //         myCashier.setLocation(waypoints[currentStep * 2], waypoints[currentStep * 2 + 1]);

    //         // moving downwards if x gets bigger
    //         if (waypoints[currentStep * 2 + 1] > waypoints[old * 2 + 1]) {
    //             // moving right if y gets bigger
    //             if (waypoints[currentStep * 2] > waypoints[old * 2]) {
    //                 myCashier.setIcon(new ImageIcon(right));
    //             } else {
    //                 myCashier.setIcon(new ImageIcon(left));
    //             }
    //         } // moving upwards 
    //         else if (waypoints[currentStep * 2] > waypoints[old * 2]) {
    //             myCashier.setIcon(new ImageIcon(right));
    //         } else {
    //             myCashier.setIcon(new ImageIcon(left));
    //         }
    //     } // end the movement
    //     else {
    //         moving = false;
    //         myCashier.setIcon(new ImageIcon(back));
    //         currentStep = 0;
    //     }
    // }

    // // Concat for two arrays
    // public int[] concat(int[] a, int[] b) {
    //     int[] temp = new int[a.length + b.length];
    //     for (int i = 0; i < a.length; i++) {
    //         temp[i] = a[i];
    //     }
    //     for (int i = 0; i < b.length; i++) {
    //         temp[a.length + i] = b[i];
    //     }
    //     return temp;
    // }

    // // reverses a given array of waypoints 
    // // so that the cashier will move the same path backwards.
    // public int[] reverse(int[] a) {
    //     int[] temp = new int[a.length];

    //     for (int i = 0; i < a.length; i++) {
    //         // even
    //         if (i % 2 == 0) {
    //             temp[i] = a[a.length - 2 - i];
    //         } // odd
    //         else {
    //             temp[i] = a[a.length - i];
    //         }
    //     }
    //     return temp;
    // }
}
