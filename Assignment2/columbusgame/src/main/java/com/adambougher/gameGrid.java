package com.adambougher;

public class gameGrid {
    int gridSize;
    gridState[][] grid;


    public gameGrid(int size) {
        gridSize = size;

        grid = new gridState[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = gridState.WATER;
            }
        }
    }

    public void placeObject(int x, int y, gridState state) {
        if ((x >= 0 && x < gridSize) && (y >= 0 && y < gridSize)) {
            grid[x][y] = state;
        }
    }

    public void removeObject(int x, int y) {
        if ((x >= 0 && x < gridSize) && (y >= 0 && y < gridSize)) {
            grid[x][y] = gridState.WATER;
        }
    }

    gridState getGridState(int x, int y) {
        if ((x >= 0 && x < gridSize) && (y >= 0 && y < gridSize)) {
            return grid[x][y];
        }
        return null;
    }

}

