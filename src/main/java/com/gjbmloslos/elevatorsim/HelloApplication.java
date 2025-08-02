package com.gjbmloslos.elevatorsim;

import com.gjbmloslos.elevatorsim.entities.Elevator;
import com.gjbmloslos.elevatorsim.entities.Person;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280,720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

//    public void callElevator(Elevator elevator,Person person){
//        if(elevator.getFloor()==person.getCurrFloor()){
//            elevator.pickup(person);
//            if(person.getCurrFloor()>person.getDestination()){
//                elevator.setGoingUp(false);
//            }else{
//                elevator.setGoingUp(true);
//            }
//            elevator.move();
//        }
//        else if(elevator.getFloor()>person.getCurrFloor()){
//            elevator.setGoingUp(false);
//        }else{
//            elevator.setGoingUp(true);
//        }
//    }
//
//    private void startTicker(){
//        new AnimationTimer(){
//
//            @Override
//            public void handle(long now) {
//            }
//        };
//    }
    public static void main(String[] args) {
        launch();
    }
}