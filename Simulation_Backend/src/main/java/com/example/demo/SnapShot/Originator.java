package com.example.demo.SnapShot;

import com.example.demo.Machine;
import com.example.demo.SimQueue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@Component
public class Originator {

    private static final Originator instance = new Originator();

    private Originator(){}

    public static Originator getInstance(){return instance;}

    private ArrayList<Machine> machineList;
    private ArrayList<SimQueue> queueList;
    private Queue<String> instructions = new LinkedList<>();


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

    public void addInstruction(String s) {
        instructions.add(s);
    }

    public String retrieveInstruction() {
        return instructions.poll();
    }

}
