package com.gjbmloslos.elevatorsim;

import com.gjbmloslos.elevatorsim.constants.Configs;
import com.gjbmloslos.elevatorsim.constants.UIConfigs;
import com.gjbmloslos.elevatorsim.entities.Elevator;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class HelloController {
    @FXML
    private StackPane root;

    @FXML
    protected void setUp() {
        root.getChildren().clear();
        setUpFloors();
//        SimulationUtil simulation = new SimulationUtil(100);
//        simulation.startSimulation();
    }

    private void setUpFloors(){
        VBox floorsWrapper = new VBox();
        StackPane.setMargin(floorsWrapper, UIConfigs.WrapperMarginPadding);
        floorsWrapper.setPadding(UIConfigs.WrapperMarginPadding);
        floorsWrapper.setBackground(UIConfigs.floorWrapperColor);
        floorsWrapper.setAlignment(Pos.BOTTOM_CENTER);

        floorsWrapper.setPrefHeight(Configs.maxFloor*UIConfigs.floorHeight);
        floorsWrapper.setMaxHeight(Configs.maxFloor*UIConfigs.floorHeight);
        floorsWrapper.prefWidthProperty().bind(root.widthProperty());

        for(int i=1;i<=Configs.maxFloor;i++){
            VBox floor = new VBox();
            floor.setBackground(UIConfigs.floorColor);
            VBox.setMargin(floor, UIConfigs.floorMargin);
            floor.prefWidthProperty().bind(floorsWrapper.prefWidthProperty());
            floor.setPrefHeight(UIConfigs.floorHeight);
            floorsWrapper.getChildren().add(floor);
        }

        HBox shaftWrapper = new HBox();
        for(int i=1;i<=Configs.elevatorNum;i++){
            VBox elevatorShaft = makeElevatorShaft();
            elevatorShaft.prefHeightProperty().bind(floorsWrapper.heightProperty());
            elevatorShaft.getChildren().add(spawnElevator(true)); //tempParam
            shaftWrapper.getChildren().add(elevatorShaft);
        }
        StackPane.setMargin(shaftWrapper, UIConfigs.WrapperMarginPadding);
        shaftWrapper.setPadding(UIConfigs.WrapperMarginPadding);

        shaftWrapper.prefWidthProperty().bind(root.widthProperty());
        shaftWrapper.prefHeightProperty().bind(floorsWrapper.heightProperty());
        shaftWrapper.maxHeightProperty().bind(floorsWrapper.heightProperty());

        root.getChildren().addAll(floorsWrapper,shaftWrapper);
    }

    private VBox makeElevatorShaft(){
        VBox elevatorShaft = new VBox();
        elevatorShaft.setPrefWidth(UIConfigs.elevatorWidth*1.5);
        HBox.setMargin(elevatorShaft,UIConfigs.shaftMargins);
        elevatorShaft.setBackground(UIConfigs.shaftColor);
        //spawnElevator
        return elevatorShaft;
    }

    private VBox spawnElevator(Boolean isEmployee){
        Elevator.setSpeed(Configs.speed);
        Elevator.setMaxFloor(Configs.maxFloor);
        Elevator.setCapacity(Configs.maxCapacity);
        VBox elevator = new VBox();
        Elevator elevatorEntity = new Elevator(isEmployee,1,true);
        //TODO: put the VBox inside Elevator.class, preserves reference &

        elevator.setPrefWidth(UIConfigs.elevatorWidth);
        HBox.setMargin(elevator,UIConfigs.shaftMargins);
//        if(isStudent){
//            elevator.setBackground(UIConfigs.studentElevColor);
//            elevator.set
//        }
        return elevator;
    }

    private void spawnPeople(){

    }
}