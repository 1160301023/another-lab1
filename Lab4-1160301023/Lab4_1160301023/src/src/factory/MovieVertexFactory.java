package src.factory;

import src.vertex.Movie;
import src.vertex.Vertex;

public class MovieVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Movie(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
