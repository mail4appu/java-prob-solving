package Oops.inheritancelist;

public class Animal {
    private String name;

    public void scream(){
        System.out.println("Animal is screaming"+getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
