package org.example;
public class Dev {

    private int age;
    private int size;

    private Laptop laptop;

    private Computer DeskComp;

    public Computer getDeskComp() {
        return DeskComp;
    }

    public void setDeskComp(Computer deskComp) {
        DeskComp = deskComp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Dev(int size) {
        this.size = size;
        System.out.println("This is the Size: " + size);
    }

    public void build(){
        System.out.println("Working on awesome project");
    }
}
