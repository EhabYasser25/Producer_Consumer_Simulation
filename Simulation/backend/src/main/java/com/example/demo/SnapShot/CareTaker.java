package com.example.demo.SnapShot;

import java.util.ArrayList;

public class CareTaker {

    private ArrayList<Memento> mementoList;


    public CareTaker() {
        mementoList = new ArrayList<Memento>();
    }


    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMementoByIndex(int index) {
        return mementoList.get(index);
    }


}
