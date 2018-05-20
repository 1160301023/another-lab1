package src.factory;

import src.vertex.Router;
import src.vertex.Vertex;
import src.vertex.WirelessRouter;

public class WirelessRouterVertexFactory extends VertexFactory{

    @Override
    public Vertex createVertex(String label, String[] args) {
        // TODO Auto-generated method stub
        Vertex vertex = new WirelessRouter(label);
        vertex.fillVertexInfo(args);
        return vertex;
    }
}
