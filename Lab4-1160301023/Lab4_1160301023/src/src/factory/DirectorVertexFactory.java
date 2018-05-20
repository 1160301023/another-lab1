package src.factory;

import src.vertex.Director;
import src.vertex.Vertex;

public class DirectorVertexFactory extends VertexFactory{

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Director(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
