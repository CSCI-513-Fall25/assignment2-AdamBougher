package com.adambougher;

import javafx.scene.effect.Light.Point;

public class Ship {
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

    public void goEast(){
        x += 1;
    }

    public void goWest(){
        x -= 1;
    }

    public void goNorth(){
        y -= 1;
    }

    public void goSouth(){
        y += 1;
    }
    

}
