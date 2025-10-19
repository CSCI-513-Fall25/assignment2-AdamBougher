package com.adambougher;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class pirateShip extends Ship  implements Observer {

    public pirateShip(int x, int y) {
        super(x, y);
    }

    @Override
    public void update(Observable o, Object arg) {
       
    }
    
}
