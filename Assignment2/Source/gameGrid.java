package com.adambougher;

public class gameGrid {
    int gridSize;
    gridState[][] grid;


    /// Constructor to initialize the grid with WATER state
    public gameGrid(int size) {
        gridSize = size;

        grid = new gridState[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = gridState.WATER;
            }
        }
    }

    /// Place an object at a specific grid cell
    public void placeObject(int x, int y, gridState state) {
        if ((x >= 0 && x < gridSize) && (y >= 0 && y < gridSize)) {
            grid[x][y] = state;
        }
    }

    /// Remove an object from a specific grid cell
    public void removeObject(int x, int y) {
        if ((x >= 0 && x < gridSize) && (y >= 0 && y < gridSize)) {
            grid[x][y] = gridState.WATER;
        }
    }

    /// Get the state of a specific grid cell
    gridState getGridState(int x, int y) {
        if ((x >= 0 && x < gridSize) && (y >= 0 && y < gridSize)) {
            return grid[x][y];
        }
        return null;
    }

}

