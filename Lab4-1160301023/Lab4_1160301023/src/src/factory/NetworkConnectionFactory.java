package src.factory;

import java.util.List;

import src.edge.Edge;
import src.edge.NetworkConnection;
import src.vertex.Vertex;

public class NetworkConnectionFactory extends EdgeFactory{

    @Override
    public Edge createEdge(String label, List<Vertex> vertices, double weight) {
        // TODO Auto-generated method stub
        Edge edge = new NetworkConnection(label,weight);
        edge.addVertices(vertices);
        return edge;
    }

}
