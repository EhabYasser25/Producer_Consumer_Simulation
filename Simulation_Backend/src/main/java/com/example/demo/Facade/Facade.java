package com.example.demo.Facade;

import com.example.demo.Machine;
import com.example.demo.SimQueue;
import com.example.demo.SnapShot.CareTaker;
import com.example.demo.SnapShot.Originator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/")
@Component
public class Facade {

    private ArrayList<Machine> simMachine = null;
    private ArrayList<SimQueue> simQueues = null;
    private Command simData = null;


    private Originator originator = Originator.getInstance();
    private CareTaker caretaker = CareTaker.getInstance();

    @PostMapping("playSimulation")
    public ResponseEntity<String> startSimulation(@RequestBody Command simData){
        this.simMachine = simData.getMachineList();
        this.simQueues = simData.getQueueList();
        this.simData = simData;
        originator.setQueueList(simQueues);
        originator.setMachineList(simMachine);
        for(int i = 0; i < simQueues.size(); i++)
            simQueues.get(i).setIndex(i);
        System.out.println(originator.getQueueList().get(0).getProducts().size());
        System.out.println("starting");
        try {
            this.runMachines();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Starting");
    }

    public void runMachines() throws InterruptedException {
        for(int i = 0; i < simMachine.size(); i++)
            simMachine.get(i).setIndex(i);

        for(int i = 0; i < simMachine.size(); i++){
            Thread tempThread = new Thread(simMachine.get(i));
            tempThread.start();
        }

        for(int i = 0; i < this.simQueues.get(0).getProducts().size(); i++) {
            this.simQueues.get(0).notifyNext();
            Thread.sleep((long) Math.floor(Math.random() * (4000 - 1000 + 1) + 1000));
        }
        /*for(Machine m : this.simMachine)
            m.run();*/
    }

    @GetMapping("state")
    public String retrieveState() {
        System.out.println("getting state");
        return originator.retrieveInstruction();
    }

}
