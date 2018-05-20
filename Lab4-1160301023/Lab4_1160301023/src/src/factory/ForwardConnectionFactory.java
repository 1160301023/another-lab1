package src.factory;

import java.util.List;

import src.edge.Edge;
import src.edge.ForwardConnection;
import src.vertex.Vertex;

public class ForwardConnectionFactory extends EdgeFactory{

    @Override
    public Edge createEdge(String label, List<Vertex> vertices, double weight) {
        // TODO Auto-generated method stub
        Edge edge = new ForwardConnection(label,weight);
        edge.addVertices(vertices);
        return edge;
    }

}
