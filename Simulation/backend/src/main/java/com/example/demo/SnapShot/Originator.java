package com.example.demo.SnapShot;

import com.example.demo.Machine;
import com.example.demo.SimQueue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Originator {

    private ArrayList<Machine> machineList;
    private ArrayList<SimQueue> queueList;

    public Originator() {
        this.machineList = new ArrayList<Machine>();
    }


    public ArrayList<Machine> getMachineList() { return machineList; }

    public void setMachineList(ArrayList<Machine> machineList) { this.machineList = machineList; }

    public ArrayList<SimQueue> getQueueList() { return queueList; }

    public void setQueueList(ArrayList<SimQueue> queueList) { this.queueList = queueList; }





    public void RetreiveStateFromMemento(Memento memento) {
        machineList = machineList;
        queueList = queueList;
    }

    public Memento newMemento() {
        return new Memento(machineList,queueList);
    }
    
}
