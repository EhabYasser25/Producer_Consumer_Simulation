package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LastAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastAssignmentApplication.class, args);

		System.out.println("[Khaled][Magdy][Nagi]");
		for(int i = 0; i < 3; i++) {
			Machine machine = new Machine();
			Thread machineThread = new Thread(machine);
			machineThread.start();
		}
	}

}
