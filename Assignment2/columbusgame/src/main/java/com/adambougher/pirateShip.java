package com.adambougher;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class pirateShip implements Observer {
    public int x;
    public int y;
    private  int ID;

    public pirateShip(int x, int y, int id){
        this.x = x;
        this.y = y;
        this.ID = id;
    }

    @Override
    public void update(Observable o, Object arg) {
        int[] shipPosition = (int[]) arg;
        int shipX = shipPosition[0];
        int shipY = shipPosition[1];

        // Move pirate towards the ship
        if (shipX > x) {
            x++;
        } else if (shipX < x) {
            x--;
        }

        if (shipY > y) {
            y++;
        } else if (shipY < y) {
            y--;
        }
        System.out.println("Pirate " + ID + " moved to: (" + x + ", " + y + ")");
    }
    
}
