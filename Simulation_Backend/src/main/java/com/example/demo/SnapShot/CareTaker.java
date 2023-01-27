package com.example.demo.SnapShot;

import java.util.ArrayList;

public class CareTaker {

    private static final CareTaker instance = new CareTaker();

    private CareTaker(){}

    public static CareTaker getInstance(){return instance;}

    private ArrayList<Memento> mementoList = new ArrayList<>();


    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMementoByIndex(int index) {
        return mementoList.get(index);
    }


}
