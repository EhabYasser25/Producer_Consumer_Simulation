package com.example.demo;

import com.example.demo.SnapShot.Originator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Queue;

import static java.lang.Thread.sleep;

public class Machine implements Runnable{
    private int time;
    int min = 3000;
    int max = 10000;
    int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);

    public Machine() {
        this.time = random_int;
        System.out.println(time);
    }

    @Autowired
    private Originator originator;
    private int targetQueue;
    private int [] resourcesQueues = null;

    private Product  currentProduct = null;

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public int getTarget() {
        return targetQueue;
    }
    public void setTarget(int target) {
        this.targetQueue = target;
    }

    public int[] getResources() {
        return resourcesQueues;
    }
    public void setResources(int[] resourcesQueues) {
        this.resourcesQueues = resourcesQueues;
    }

    public void  Notify (){
        if(resourcesQueues == null)
            return;
        for(int i=0 ; i<resourcesQueues.length ; i++)
        {
             originator.getQueueList().get(resourcesQueues[i]).Update(this);
            if (currentProduct != null)
                break;
        }
    }

    public void produce() throws InterruptedException {
        originator.getQueueList().get(targetQueue).addProduct(currentProduct);
        currentProduct = null;
        this.consume();
    }

    public void consume() throws InterruptedException {
        while(currentProduct == null)
            this.Notify();
        Thread.sleep(this.time);
        this.produce();
    }

    @Override
    public void run() {
        try {
            this.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
