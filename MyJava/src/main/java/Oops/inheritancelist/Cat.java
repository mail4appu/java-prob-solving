package Oops.inheritancelist;

public class Cat extends Animal {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void scream(){
        System.out.println("Cat is screaming"+getName());
    }

}
