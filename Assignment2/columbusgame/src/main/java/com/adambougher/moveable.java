package com.adambougher;

public interface moveable {

    void goNorth(gridState goToState);
    void goSouth(gridState goToState);
    void goEast(gridState goToState);
    void goWest(gridState goToState);

    public int getX();
    public int getY();
    

}
