package com.adambougher;

public class OceanMap {
    public gameGrid oceanGrid;
    final int scalingFactor = 50;
    public Ship ship = new Ship(5,5);
    public pirateShip [] pirates;

    public OceanMap(int size, int numIslands, int numPirates) {
        oceanGrid = new gameGrid(size);
        oceanGrid.placeObject(ship.getX(), ship.getY(), gridState.SHIP);

        placeIslands(numIslands);

        pirates = placePirates(numPirates);
        
    }

    // Return generated map
    public gameGrid getMap(){
        return oceanGrid;
    }

    public void placeIslands(int amt){
        int x  = (int)(Math.random() * oceanGrid.gridSize);
        int y = (int)(Math.random() * oceanGrid.gridSize);
        
        for (int i = 0; i < amt; i++) {
            while (oceanGrid.grid[x][y] != gridState.WATER) {
                x = (int)(Math.random() * oceanGrid.gridSize);
                y = (int)(Math.random() * oceanGrid.gridSize);
            }
            oceanGrid.placeObject(x, y, gridState.ISLAND);
        }
    }

    private pirateShip [] placePirates(int amt){
        int x  = (int)(Math.random() * oceanGrid.gridSize);
        int y = (int)(Math.random() * oceanGrid.gridSize);
        pirateShip [] p = new pirateShip[amt];
        
        for (int i = 0; i < amt; i++) {
            while (oceanGrid.grid[x][y] != gridState.WATER) {
                x = (int)(Math.random() * oceanGrid.gridSize);
                y = (int)(Math.random() * oceanGrid.gridSize);
            }
            p[i] = new pirateShip(x, y);
            ship.addObserver(p[i]);
            oceanGrid.placeObject(x, y, gridState.PIRATE);
        }

        return p;
    }   

    public pirateShip getShip(int  x, int y){
        for (pirateShip pirateShip : pirates) {
            if (pirateShip.x == x && pirateShip.y == y) {
                return pirateShip;
            }
        }
        return null;
    }

}
