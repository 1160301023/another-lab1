package src.factory;

import src.vertex.Router;
import src.vertex.Vertex;

public class RouterVertexFactory extends VertexFactory {

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new Router(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }

}
