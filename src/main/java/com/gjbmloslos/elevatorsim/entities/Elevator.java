package com.gjbmloslos.elevatorsim.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public class Elevator {
    private boolean forEmployee;
    private int floor;
    private boolean goingUp;
    private static double speed;
    private static int capacity;
    private static int maxFloor;

    private static final Logger logger = Logger.getLogger(Elevator.class.getName());

    public Elevator(boolean forEmployee, int floor, boolean goingUp) {
        this.forEmployee = forEmployee;
        this.floor = floor;
        this.goingUp = goingUp;
    }

    private ArrayList<Person> persons = new ArrayList<>();

    public void move(){
        if(goingUp){
            floor++;
            if(floor==maxFloor){
                goingUp = false;
                logger.fine("Elevator direction change, going up");
            }
        }else{
            floor--;
            if(floor==1){
                goingUp = true;
                logger.fine("Elevator direction change, going down");
            }
        }
    }

    public void pickup(Person person){
        if(persons.size()<capacity){
            persons.add(person);
        }else{
            logger.fine("Elevator is full capacity");
        }
    }

    public boolean hasPersonWithDestBelow(){
        for(Person person:persons){
            if(person.getDestination()<floor){
                return true;
            }
        }
        return false;
    }

    public boolean hasPersonWithDestAbove(){
        for(Person person:persons){
            if(person.getDestination()>floor){
                return true;
            }
        }
        return false;
    }

    public void checkDropoff(){
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getDestination() == floor) {
                iterator.remove();
                logger.fine("Dropped off person " + person.getId() + " at " + floor);
            }
        }
    }

    public void dropOff() {
    }

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        Elevator.capacity = capacity;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isGoingUp() {
        return goingUp;
    }

    public void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }

    public static void setMaxFloor(int maxFloor) {
        Elevator.maxFloor = maxFloor;
    }

    public static void setSpeed(double speed) {Elevator.speed = speed;}

}
