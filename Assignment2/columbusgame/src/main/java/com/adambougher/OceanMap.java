package com.adambougher;

public class OceanMap {
    gameGrid oceanGrid;
    int scalingFactor = 50;
    public Ship ship = new Ship(5,5);
    public pirateShip [] pirates;

    public OceanMap(int size, int numIslands, int numPirates) {
        oceanGrid = new gameGrid(size);
        pirates = new pirateShip[numPirates];
        
        placeObjects(numIslands, gridState.ISLAND);
        placeObjects(numPirates, gridState.PIRATE);
    }

    // Return generated map
    public gameGrid getMap(){
        return oceanGrid;
    }

    public void placeObjects(int amt, gridState state){
        int x = (int)(Math.random() * 10);
        int y = (int)(Math.random() * 10);
        
        for (int i = 0; i < amt; i++) {
            oceanGrid.placeObject(x, y, state);

            while (oceanGrid.grid[x][y] == state) {
                x = (int)(Math.random() * 10);
                y = (int)(Math.random() * 10);
            }
        }
    }


}
