package com.example.demo.SnapShot;

import com.example.demo.Machine;
import com.example.demo.SimQueue;

import java.util.ArrayList;

public class Memento {

    private ArrayList<Machine> machineList;
    private ArrayList<SimQueue> queueList;

    public Memento(ArrayList<Machine> machineList, ArrayList<SimQueue> queueList) {
        this.machineList = machineList;
        this.queueList = queueList;
    }

    public ArrayList<Machine> getMachineList() {
        return machineList;
    }

    public ArrayList<SimQueue> getQueueList() {
        return queueList;
    }


}
