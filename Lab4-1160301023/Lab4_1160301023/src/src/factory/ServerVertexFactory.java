package src.factory;

import src.vertex.Server;
import src.vertex.Vertex;

public class ServerVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Server(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
