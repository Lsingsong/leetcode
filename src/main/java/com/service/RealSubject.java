package com.service;

public class RealSubject implements Subject{
    private final String name = "ligang";
    @Override
    public void visit() {
        System.out.println(name);
    }
}
