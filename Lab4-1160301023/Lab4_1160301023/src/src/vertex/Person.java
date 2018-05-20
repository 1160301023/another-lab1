package src.vertex;

import java.util.ArrayList;
import java.util.List;
import src.edge.DirectedEdge;

public class Person extends Vertex{
    public Person(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }

    private int age;
    private String sex;
  
    List<DirectedEdge> PersonEdge = new ArrayList<>();
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<DirectedEdge> getPersonEdge() {
        return PersonEdge;
    }

    public void setPersonEdge(List<DirectedEdge> personEdge) {
        this.PersonEdge = personEdge;
    }

    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.age = Integer.valueOf(args[0]);
        this.sex = args[1];
    }
}
