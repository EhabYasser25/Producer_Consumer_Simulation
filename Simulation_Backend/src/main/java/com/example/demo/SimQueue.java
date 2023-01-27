package com.example.demo;

import com.example.demo.SnapShot.CareTaker;
import com.example.demo.SnapShot.Originator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class SimQueue {
    private Queue<Product> products = new LinkedList<>();
    private final int maxSize = 100;
    private int index;

    private Originator originator = Originator.getInstance();
    private CareTaker caretaker = CareTaker.getInstance();

    private int[] targetMachines = null;



    public synchronized Product request(){
        return products.poll();
    }

    public void notifyNext(){
        for(int i : targetMachines)
            this.originator.getMachineList().get(i).update(this);
    }
    public void addProduct(Product P)
    {
        products.add(P);
        originator.addInstruction("queue " + String.valueOf(products.size()));
    }

    public Queue<Product> getProducts() {
        return products;
    }

    public void setProducts(Queue<Product> products) {
        this.products = products;
    }

    public int[] getTargetMachines() {
        return targetMachines;
    }

    public void setTargetMachines(int[] targetMachines) {
        this.targetMachines = targetMachines;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
