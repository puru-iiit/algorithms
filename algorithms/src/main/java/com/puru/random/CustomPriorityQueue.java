package com.puru.random;

import java.util.Arrays;
import java.util.Comparator;

class Patient{
    private String name;
    private int age;
    private int id;

    public Patient(String name, int age){
        this.name = name;
        this.age=age;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int id){
        this.id = id;
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("id:").append(id).append("-Name:").append(name).append("-Age:").append(age);

        return sb.toString();

    }

}


