package Oops.inheritance.immutability;

import java.util.Date;

public class Child extends Parent {
    public Child(int id, String name, Date date) {
        super(id, name, date);
    }

    @Override
    public int getId() {
        return super.getId();
    }
}
