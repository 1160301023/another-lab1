package src.factory;

import java.util.List;

import src.edge.Edge;
import src.edge.SameMovieHyperEdge;
import src.vertex.Vertex;

public class SameMovieHyperEdgeFactory extends EdgeFactory{

    @Override
    public Edge createEdge(String label, List<Vertex> vertices, double weight) {
        // TODO Auto-generated method stub
        Edge edge = new SameMovieHyperEdge(label,weight);
        edge.addVertices(vertices);
        return edge;
    }

}
