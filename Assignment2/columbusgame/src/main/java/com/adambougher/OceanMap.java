package com.adambougher;

public class OceanMap {
    boolean[][] oceanGrid = new boolean[10][10];
    int scalingFactor = 50;
    public Ship ship = new Ship(5,5);

    // Return generated map
    public boolean[][] getMap(){
        return oceanGrid;
    }


}
