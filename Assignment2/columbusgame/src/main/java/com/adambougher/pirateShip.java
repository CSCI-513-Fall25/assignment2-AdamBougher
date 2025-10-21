package com.adambougher;

import java.util.Observable;
import java.util.Observer;

public class pirateShip implements Observer, moveable {

    public int ID;
    public int x;
    public int y;

    public pirateShip(int x, int y) {
        this.x = x;
        this.y = y;
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

    @Override
    public void goNorth(gridState goToState) {
        if (goToState == gridState.WATER)
        y -= 1;
    }
    @Override
    public void goSouth(gridState goToState) {
        if (goToState == gridState.WATER)
        y += 1;
    }
    @Override
    public void goEast(gridState goToState) {
        if (goToState == gridState.WATER)
        x += 1;
    }
    @Override
    public void goWest(gridState goToState) {
        if (goToState == gridState.WATER)
        x -= 1;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }
}
