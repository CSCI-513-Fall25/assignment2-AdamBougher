package com.adambougher;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class pirateShip extends Ship  implements Observer {

    public int ID;

    public pirateShip(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Observable o, Object arg) {
        int[] shipPosition = (int[]) arg;
        int shipX = shipPosition[0];
        int shipY = shipPosition[1];

        if (Math.abs(shipY - y) > Math.abs(shipX - x)) {
            if (shipY < y) {
                moveTowardsShip(0); // Move North
            } else if (shipY > y) {
                moveTowardsShip(1); // Move South
            }
        }else{
            if (shipX < x) {
                moveTowardsShip(3); // Move West
            } else if (shipX > x) {
                moveTowardsShip(2); // Move East
            }
        }
    }

    private void moveTowardsShip(int dir) {
        switch(dir){
            case 0: // North
                goNorth(gridState.WATER);
                break;
            case 1: // South
                goSouth(gridState.WATER);
                break;
            case 2: // East
                goEast(gridState.WATER);
                break;
            case 3: // West
                goWest(gridState.WATER);
                break;
        }
    }

    
}
