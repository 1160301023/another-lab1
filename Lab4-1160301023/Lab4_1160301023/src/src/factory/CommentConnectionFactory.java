package src.factory;

import java.util.List;

import src.edge.CommentConnection;
import src.edge.Edge;
import src.vertex.Vertex;

public class CommentConnectionFactory extends EdgeFactory{

    @Override
    public Edge createEdge(String label, List<Vertex> vertices, double weight) {
        // TODO Auto-generated method stub
        Edge edge = new CommentConnection(label,weight);
        edge.addVertices(vertices);
        return edge;
    }


}
