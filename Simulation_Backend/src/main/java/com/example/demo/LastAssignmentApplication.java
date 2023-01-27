package com.example.demo;

import com.example.demo.Facade.Command;
import com.example.demo.Facade.Facade;
import com.example.demo.SnapShot.Originator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class LastAssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LastAssignmentApplication.class, args);
//		Facade temp = new Facade();
//		Command tempCommand = new Command();
//		Machine m0 = new Machine();
//		m0.setTime(3000);
//		Machine m1 = new Machine();
//		m1.setTime(3000);
//		Machine m2 = new Machine();
//		m2.setTime(3000);
//		Machine m3 = new Machine();
//		m3.setTime(3000);
//		Machine m4 = new Machine();
//		m4.setTime(3000);
//		SimQueue q0 = new SimQueue();
//		SimQueue q1 = new SimQueue();
//		SimQueue q2 = new SimQueue();
//		Product p0 = new Product();
//		p0.setColor("red");
//		Product p1 = new Product();
//		p1.setColor("green");
//		Product p2 = new Product();
//		p2.setColor("blue");
//		Product p3 = new Product();
//		p3.setColor("yellow");
//		Product p4 = new Product();
//		p4.setColor("orange");
//		q0.addProduct(p0);
//		q0.addProduct(p1);
//		q0.addProduct(p2);
//		q0.addProduct(p3);
//		q0.addProduct(p4);
//		q0.setTargetMachines(new int[]{0,1});
//		q1.setTargetMachines(new int[]{2,3});
//		q2.setTargetMachines(new int[]{4});
//		m0.setTargetQueue(1);
//		m1.setTargetQueue(1);
//		m2.setTargetQueue(2);
//		m3.setTargetQueue(2);
//		ArrayList<Machine> machines = new ArrayList<Machine>(Arrays.asList(m0,m1,m2,m3,m4));
//		ArrayList<SimQueue> queues = new ArrayList<SimQueue>(Arrays.asList(q0,q1,q2));
//		tempCommand.setMachineList(machines);
//		tempCommand.setQueueList(queues);
//		Originator og = ctx.getBean(Originator.class);
//		og.setMachineList(machines);
//		og.setQueueList(queues);
//		for(Machine m : machines)
//			m.setOriginator(og);
//		for(SimQueue q : queues)
//			q.setOriginator(og);
//		temp.startSimulation(tempCommand);
	}

}
