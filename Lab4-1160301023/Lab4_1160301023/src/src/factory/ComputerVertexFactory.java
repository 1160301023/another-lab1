package src.factory;

import src.vertex.Computer;
import src.vertex.Vertex;

public class ComputerVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Computer(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
