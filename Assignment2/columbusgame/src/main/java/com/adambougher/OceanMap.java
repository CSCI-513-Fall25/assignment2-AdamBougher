package com.adambougher;

public class OceanMap {
    gameGrid oceanGrid;
    final int scalingFactor = 50;
    public Ship ship = new Ship(5,5);
    public pirateShip [] pirates;

    public OceanMap(int size, int numIslands, int numPirates) {
        oceanGrid = new gameGrid(size);
        oceanGrid.placeObject(ship.getX(), ship.getY(), gridState.SHIP);

        placeIslands(numIslands, gridState.ISLAND);

        pirates = new pirateShip[numPirates];
        placePirates(numPirates);
        
        for (pirateShip pirateShip : pirates) {
            ship.addObserver(pirateShip);
        }
    }

    // Return generated map
    public gameGrid getMap(){
        return oceanGrid;
    }

    public void placeIslands(int amt, gridState state){
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);
        
        for (int i = 0; i < amt; i++) {
            while (oceanGrid.grid[x][y] != gridState.WATER) {
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);
            }
            oceanGrid.placeObject(x, y, state);
        }
    }

    private void placePirates(int amt){
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);
        
        for (int i = 0; i < amt; i++) {
            while (oceanGrid.grid[x][y] != gridState.WATER) {
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);
            }
            pirates[i] = new pirateShip(x, y, i+1);
            oceanGrid.placeObject(x, y, gridState.PIRATE);
        }
    }   


}
