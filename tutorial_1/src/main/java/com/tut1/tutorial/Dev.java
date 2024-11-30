package com.tut1.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component ///Tells spring boot to create an object of this class in it's container
public class Dev {
    // if we want to call "compile" method for the Laptop class we need to create and instance of Laptop
    // Laptop laptopObj; //this is null by default "nullPointerException"
    //laptopObj.compile;

    //   @Autowired setter injection
    //    public void setLaptop(Laptop laptop){
    //        this.laptop = laptop;
    //    }

//    @Autowired // field injection
//    private Laptop laptopObj;

    //since Autowire searches by type it will look for a type of computer and then connect
    @Autowired
    private Computer comp;


    public void build(){
        System.out.println("Working on awesome project");
        comp.compile();
    }
}
