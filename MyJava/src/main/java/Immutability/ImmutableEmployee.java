package Immutability;

/**
 * @author appu
 * 
 * http://howtodoinjava.com/core-java/related-concepts/how-to-make-a-java-class-immutable/
 *
 * State of an object can be modfied in
 *
 * 1) By setter
 * 2) By constructor
 * 3) By inheriting class. When inherited class's object is created, JVM calls its suprer class constructor. thus
 *    state of the parent class is modified.
 *
 *
 *    When a mutable object is part of immutable class, the getter of mutableField should always
 *    return new object of mutable field.
 *
 *    Other wise, after getting the mutable object, mutable field's state can be changed with its own setters which thus chages the
 *    immutable object's state.
 *
 *
 *
 *
 *
 *
 */
public final class ImmutableEmployee {
    private final  String name;

    private final int age;

    private final Address address;

    public ImmutableEmployee(String name, int age, Address address) {
        this.name = name;
        this.age=age;
        this.address=new Address();
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * @return Returning new address is  very important
     */
    public Address getAddress() {
        return new Address();
    }
}
