package com.example.demo.Facade;

import com.example.demo.Machine;
import com.example.demo.SimQueue;

import java.util.ArrayList;

public class Command {

    private ArrayList<Machine> machineList;
    private ArrayList<SimQueue> queueList;

    public ArrayList<Machine> getMachineList() {
        return machineList;
    }

    public void setMachineList(ArrayList<Machine> machineList) {
        this.machineList = machineList;
    }

    public ArrayList<SimQueue> getQueueList() {
        return queueList;
    }

    public void setQueueList(ArrayList<SimQueue> queueList) {
        this.queueList = queueList;
    }
}
