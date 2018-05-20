package src.factory;

import src.vertex.Vertex;
import src.vertex.Word;

public class WordVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Word(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}