package com.gjbmloslos.elevatorsim;

import com.gjbmloslos.elevatorsim.entities.Elevator;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class HelloController {
    @FXML
    private VBox root;

    @FXML
    protected void setUp() {
        root.getChildren().clear();
        setUpFloors();
//        SimulationUtil simulation = new SimulationUtil(100);
//        simulation.startSimulation();
    }

    private void setUpFloors(){
        Insets insets = new Insets(0,50,0,50);

        Border border = new Border(
                            new BorderStroke(
                                    Color.DARKGRAY,
                                    BorderStrokeStyle.SOLID,
                                    CornerRadii.EMPTY,
                                    new BorderWidths(20,10,20,10)
                            ));
        for(int i=1;i<=Configs.maxFloor;i++){
            VBox floorContainer = new VBox();
            HBox elevatorRow = new HBox();

            floorContainer.setBackground(Background.fill(Color.web("#457B9D")));
            floorContainer.setBorder(border);
            VBox.setMargin(floorContainer,insets);
            floorContainer.prefWidthProperty().bind(root.prefWidthProperty());
            floorContainer.setMinHeight(200);

            elevatorRow.setMaxHeight(Double.MAX_VALUE);
            elevatorRow.prefWidthProperty().bind(floorContainer.prefWidthProperty());
            VBox.setVgrow(elevatorRow, Priority.ALWAYS);

            for(int j = 1; j<=Configs.elevatorNum; j++){
                makeElevatorShaft(elevatorRow);
            }

            floorContainer.getChildren().add(elevatorRow);
            root.getChildren().add(floorContainer);
        }
//        spawnElevators();
//        spawnPeople();
    }

    private void makeElevatorShaft(HBox elevatorRow){
        VBox elevatorShaft = new VBox();
        elevatorShaft.setMinWidth(50);
        elevatorShaft.setMaxWidth(50);
        elevatorShaft.prefHeightProperty().bind(elevatorRow.heightProperty());
        Insets insets = new Insets(0,5,0,5);
        HBox.setMargin(elevatorShaft,insets);
        elevatorShaft.setBackground(Background.fill(Color.web("#F1FAEE")));
        elevatorShaft.setAlignment(Pos.BOTTOM_CENTER);

        elevatorRow.getChildren().add(elevatorShaft);
    }
     private void spawnElevator(VBox shaft){
        Elevator.setSpeed(Configs.speed);
        Elevator.setMaxFloor(Configs.maxFloor);
        Elevator.setCapacity(Configs.maxCapacity);
        VBox elevator = new VBox();
        elevator.setBackground(Background.fill(Color.web("#")));
        elevator.prefHeightProperty().bind(shaft.heightProperty());

        shaft.getChildren().add(elevator);
    }

    private void spawnPeople(){

    }
}