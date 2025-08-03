package com.gjbmloslos.elevatorsim;

import com.gjbmloslos.elevatorsim.constants.Configs;
import com.gjbmloslos.elevatorsim.constants.UIConfigs;
import com.gjbmloslos.elevatorsim.entities.Elevator;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.util.ArrayList;


public class HelloController {
    ArrayList<Elevator> elevators = new ArrayList<>();
    VBox floorsWrapper;
    @FXML
    private StackPane root;

    @FXML
    protected void setUp() {
        root.getChildren().clear();
        setUpFloors();
        setUpElevators();
//        SimulationUtil simulation = new SimulationUtil(100);
//        simulation.startSimulation();
    }

    private void setUpFloors(){
        floorsWrapper = new VBox();
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

        root.getChildren().add(floorsWrapper);
    }

    private void setUpElevators(){
        HBox shaftWrapper = new HBox();
        for(int i = 1; i<=Configs.studentElevatorNum; i++){
            VBox elevatorShaft = makeElevator(false);
            shaftWrapper.getChildren().add(elevatorShaft);
        }
        for(int i = 1; i<=Configs.employeeElevatorNum;i++){
            VBox elevatorShaft = makeElevator(true);
            shaftWrapper.getChildren().add(elevatorShaft);
        }

        StackPane.setMargin(shaftWrapper, UIConfigs.WrapperMarginPadding);
        shaftWrapper.setPadding(UIConfigs.WrapperMarginPadding);

        shaftWrapper.prefWidthProperty().bind(root.widthProperty());
        shaftWrapper.prefHeightProperty().bind(floorsWrapper.heightProperty());
        shaftWrapper.maxHeightProperty().bind(floorsWrapper.heightProperty());

        root.getChildren().add(shaftWrapper);
    }

    private VBox makeElevator(Boolean isEmployee){
        VBox elevatorShaft = new VBox();
        elevatorShaft.setPrefWidth(UIConfigs.elevatorWidth*1.5);
        elevatorShaft.prefHeightProperty().bind(floorsWrapper.heightProperty());
        HBox.setMargin(elevatorShaft,UIConfigs.shaftMargins);
        elevatorShaft.setBackground(UIConfigs.shaftColor);
        elevatorShaft.setAlignment(Pos.BOTTOM_CENTER);

        Elevator.setSpeed(Configs.speed);
        Elevator.setMaxFloor(Configs.maxFloor);
        Elevator.setCapacity(Configs.maxCapacity);
        Elevator elevatorEntity = new Elevator(isEmployee,1,true);

        elevatorEntity.getVbox().setPrefWidth(UIConfigs.elevatorWidth);
        elevatorEntity.getVbox().setMaxWidth(UIConfigs.elevatorWidth);
        elevatorEntity.getVbox().setPrefHeight(UIConfigs.elevatorHeight);
        HBox.setMargin(elevatorEntity.getVbox(),UIConfigs.shaftMargins);

        elevators.add(elevatorEntity);

        elevatorShaft.getChildren().add(elevatorEntity.getVbox());
        return elevatorShaft;
    }


    private void spawnPeople(){

    }
}