package Oops.inheritance.immutability;

import java.util.Date;

public class Parent {

    private final int id;
    private final String name;
    private final Date date;

    public Parent(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
        System.out.println("date in parent"+date);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
