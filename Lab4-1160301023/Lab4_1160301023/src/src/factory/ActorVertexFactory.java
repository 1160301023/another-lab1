package src.factory;

import src.vertex.Actor;
import src.vertex.Vertex;

public class ActorVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Actor(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
