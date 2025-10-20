
package com.adambougher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends  Application {

    final int dimension = 10; // We are creating 10X10 maps
    final int scale = 50; // Scale everything by 50. You can experiment here.
    OceanMap oceanMap = new OceanMap(dimension, 10, 2);
    gameGrid oceanGrid = oceanMap.getMap();

    Image shipImage = new Image("ship.png",scale,scale,true,true);
    Image islandImage = new Image("island.jpg",scale,scale,true,true);
    Image pirateImage = new Image("pirateShip.png",scale,scale,true,true);
    // Now instantiate and load the image View. Actually this probably needs to be
    // a class level variable so you would already have defined ImageView shipImageview
    ImageView shipImageView = new ImageView(shipImage);
    ImageView islandImageView = new ImageView(islandImage);
    ImageView[] pirateImageViews = new ImageView[2];

    @Override
    public void start(Stage oceanStage) throws Exception {
        Pane root = new AnchorPane();
        Scene scene = new Scene(root,500, 500);
        oceanStage.setScene(scene);
        oceanStage.setTitle("Columbus");
        oceanStage.show();

        startSailing(scene, oceanMap.ship);


        int id = 0;

        for(int x = 0; x < dimension; x++){
            for(int y = 0; y < dimension; y++){
                Rectangle rect;
                switch(oceanGrid.grid[x][y]){
                    case ISLAND:
                        islandImageView = new ImageView(islandImage);
                        islandImageView.setX(x*scale+1);
                        islandImageView.setY(y*scale+1);
                        root.getChildren().add(islandImageView);
                        break;
                    case SHIP:
                        rect = new Rectangle(x*scale,y*scale,scale,scale);
                        rect.setStroke(Color.BLACK);
                        rect.setFill(Color.RED);
                        root.getChildren().add(rect);
                    default:
                        rect = new Rectangle(x*scale,y*scale,scale,scale);
                        rect.setStroke(Color.BLACK);
                        rect.setFill(Color.PALETURQUOISE);
                        root.getChildren().add(rect); // Add to the node tree in the pane
                }
            }
        }

        for (int i = 0; i < oceanMap.pirates.length; i++) {
            pirateImageViews[i] = new ImageView(pirateImage);
            pirateImageViews[i].setX(oceanMap.pirates[i].getX() * scale);
            pirateImageViews[i].setY(oceanMap.pirates[i].getY() * scale);
            root.getChildren().add(pirateImageViews[i]);
        }

        for (pirateShip pirate : oceanMap.pirates) {
            oceanGrid.removeObject(pirate.getX(), pirate.getY());
            // Update the position of the pirate ImageView
            // You'll need to keep track of ImageView objects for each pirate
        }

        oceanGrid.removeObject(oceanMap.ship.getX(), oceanMap.ship.getY());

        shipImageView.setX(oceanMap.ship.getX() * scale);
        shipImageView.setY(oceanMap.ship.getY() * scale);

        oceanGrid.placeObject(oceanMap.ship.getX(), oceanMap.ship.getY(), gridState.SHIP);

        root.getChildren().add(shipImageView);

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void startSailing(Scene scene, Ship ship) {
        scene.setOnKeyPressed((KeyEvent ke) -> {
            oceanGrid.removeObject(ship.getX(), ship.getY());
            switch (ke.getCode()) {
                case RIGHT:
                    ship.goEast(oceanGrid.getGridState(ship.getX() + 1, ship.getY()));
                    break;
                case LEFT:
                    ship.goWest(oceanGrid.getGridState(ship.getX() - 1, ship.getY()));
                    break;
                case UP:
                    ship.goNorth(oceanGrid.getGridState(ship.getX(), ship.getY() - 1));
                    break;
                case DOWN:
                    ship.goSouth(oceanGrid.getGridState(ship.getX(), ship.getY() + 1));
                    break;
                default:
                    break;
            }
            shipImageView.setX(ship.getX() * scale);
            shipImageView.setY(ship.getY() * scale);
            oceanGrid.placeObject(ship.getX(), ship.getY(), gridState.SHIP);
            updatePiratePositions();
        });
    }

    private void updatePiratePositions() {
        for (int i = 0; i < oceanMap.pirates.length; i++) {
            pirateShip pirate = oceanMap.pirates[i];

            oceanGrid.removeObject(pirate.getX(), pirate.getY());

            pirateImageViews[i].setX(pirate.getX() * scale);
            pirateImageViews[i].setY(pirate.getY() * scale);
            
            oceanGrid.placeObject(pirate.getX(), pirate.getY(), gridState.PIRATE);
        }
    }

}
