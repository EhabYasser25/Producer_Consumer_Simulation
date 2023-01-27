package com.example.demo;

import com.example.demo.SnapShot.CareTaker;
import com.example.demo.SnapShot.Originator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.sleep;

public class Machine implements Runnable{
    private int time;

    private int index;

    private Queue<SimQueue> notificationBuffer = new LinkedList<SimQueue>();

    private Originator originator = Originator.getInstance();
    private CareTaker caretaker = CareTaker.getInstance();
    private int targetQueue = -1;

    private Product currentProduct = null;


    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public void produce() throws InterruptedException {
        if(targetQueue == -1)
            return;
        Thread.sleep(this.time);
        SimQueue target = originator.getQueueList().get(targetQueue);
        target.addProduct(currentProduct);
        System.out.println("Machine " + this.index + " produced product of color " + currentProduct.getColor() + " and fed to queue " + this.targetQueue);
        target.notifyNext();
        currentProduct = null;
        originator.addInstruction("machine " + String.valueOf(index) +" #ffffff");
        this.consume();
    }

    public void consume() throws InterruptedException {
        while(currentProduct == null) {
            while (this.notificationBuffer.isEmpty()){Thread.sleep(10);}
            SimQueue requester = notificationBuffer.poll();
            this.currentProduct = requester.request();
            originator.addInstruction("queue " + String.valueOf(requester.getIndex()) + " " + requester.getProducts().peek().getColor() + " " + String.valueOf(requester.getProducts().size()));
        }
        System.out.println("Machine " + this.index + " consumed product of color " + currentProduct.getColor() + " from a queue");
        originator.addInstruction("machine " + String.valueOf(index) + " " + currentProduct.getColor());
        caretaker.addMemento(originator.newMemento());
        this.produce();
    }
    public void update(SimQueue q){
        System.out.println("Machine " + this.index + "  is notified");
        this.notificationBuffer.add(q);
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting machine " + this.index + " target is " + this.targetQueue);
            this.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTargetQueue() {
        return targetQueue;
    }

    public void setTargetQueue(int targetQueue) {
        this.targetQueue = targetQueue;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
