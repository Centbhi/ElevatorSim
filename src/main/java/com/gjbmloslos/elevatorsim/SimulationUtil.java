package com.gjbmloslos.elevatorsim;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

public class SimulationUtil {

    private static final Logger logger = Logger.getLogger(SimulationUtil.class.getName());
    private volatile Thread tickThread;
    private volatile boolean running = false;
    private volatile int tickIntervalMS;
    private static int ticks = 0;

    public SimulationUtil(int tickIntervalMS){
        this.tickIntervalMS=tickIntervalMS;
    }

    public void startSimulation(){
        running=true;
        tickThread = new Thread(()->{
            while(running){
                try{
                    tick();
                    Thread.sleep(tickIntervalMS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        tickThread.start();
    }

    public void pauseSimulation(){
        running=false;
    }

    public void resumeSimulation(){
        running=true;
    }

    public void stopSimulation(){
        running=false;
        if(tickThread!=null){
            tickThread.interrupt();
            tickThread = null;
        }
    }

    public void tick(){
        ticks++;
        System.out.println("Tick "+ticks);
    }



}