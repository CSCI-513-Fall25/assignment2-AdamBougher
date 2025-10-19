package com.adambougher;

import java.util.Observable;

public class Ship extends Observable {
    public int x;
    public int y;

    public Ship(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void goEast(gridState goToState){
        if (goToState == gridState.WATER)
        x += 1;
    }

    public void goWest(gridState goToState ){
        if (goToState == gridState.WATER )
        x -= 1;
    }

    public void goNorth(gridState goToState ){
        if (goToState == gridState.WATER)
        y -= 1;
    }

    public void goSouth(gridState goToState){
        if (goToState == gridState.WATER)
        y += 1;
    } 

}
