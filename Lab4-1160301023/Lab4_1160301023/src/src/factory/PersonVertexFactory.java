package src.factory;

import src.vertex.Person;
import src.vertex.Vertex;

public class PersonVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Person(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
