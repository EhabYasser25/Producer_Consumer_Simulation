package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SimQueue {
    private Queue<Product> products = new LinkedList<>();
    private final int maxSize = 100;
    ArrayList<Integer> targetMachines = new ArrayList<>();

    public ArrayList<Integer> getTargetMachines() {
        return targetMachines;
    }
    public void setTargetMachines(ArrayList<Integer> targetMachines) {
        this.targetMachines = targetMachines;
    }

    public void Update (Machine M){
        if(products.isEmpty())
            return;
        Product temp = products.remove();
        M.setCurrentProduct(temp);
    }

    public void addProduct(Product P)
    {
        products.add(P);
    }
}
