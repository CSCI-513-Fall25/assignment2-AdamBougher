
package com.adambougher;

import javafx.application.Application;
import javafx.event.EventHandler;
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
    OceanMap oceanMap = new OceanMap();
    boolean[][] oceanGrid = oceanMap.getMap();

    Image shipImage = new Image("ship.png",50,50,true,true);
    // Now instantiate and load the image View. Actually this probably needs to be
    // a class level variable so you would already have defined ImageView shipImageview
    ImageView shipImageView = new ImageView(shipImage);

    @Override
    public void start(Stage oceanStage) throws Exception {
        Pane root = new AnchorPane();
        Scene scene = new Scene(root,500, 500);
        oceanStage.setScene(scene);
        oceanStage.setTitle("Columbus");
        oceanStage.show();

        startSailing(scene, oceanMap.ship);

        for(int x = 0; x < 50; x++){
            for(int y = 0; y < 50; y++){
                Rectangle rect = new Rectangle(x*scale,y*scale,scale,scale);
                rect.setStroke(Color.BLACK); // We want the black outline
                rect.setFill(Color.PALETURQUOISE); // I like this color better than BLUE
                root.getChildren().add(rect); // Add to the node tree in the pane
            }
        }

        shipImageView.setX(oceanMap.ship.getX() * scale);
        shipImageView.setY(oceanMap.ship.getY() * scale);
        root.getChildren().add(shipImageView);

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void startSailing(Scene scene, Ship ship) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                switch (ke.getCode()) {
                    case RIGHT:
                        ship.goEast();
                        break;
                    case LEFT:
                        ship.goWest();
                        break;
                    case UP:
                        ship.goNorth();
                        break;
                    case DOWN:
                        ship.goSouth();
                        break;
                    default:
                        break;
                }
                shipImageView.setX(ship.getX() * scale);
                shipImageView.setY(ship.getY() * scale);
            }
        });
    }

}
