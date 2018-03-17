package P3;

import java.util.ArrayList;

public class Person {
    String name;
    boolean isVisited = false;
    ArrayList<Person> l = new ArrayList<Person>();
    public Person(String name)
    {
        this.name = name;
    }
}
