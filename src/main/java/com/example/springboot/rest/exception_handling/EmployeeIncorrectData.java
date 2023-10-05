package com.example.springboot.rest.exception_handling;

public class EmployeeIncorrectData {

    String info;

    public EmployeeIncorrectData(){
    }

    public EmployeeIncorrectData(String info) {
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

    public void setInfo(String info){
        this.info = info;
    }
}
