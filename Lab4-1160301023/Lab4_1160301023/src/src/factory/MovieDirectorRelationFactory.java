package src.factory;

import java.util.List;

import src.edge.Edge;
import src.edge.MovieDirectorRelation;
import src.vertex.Vertex;

public class MovieDirectorRelationFactory extends EdgeFactory{

    @Override
    public Edge createEdge(String label, List<Vertex> vertices, double weight) {
        // TODO Auto-generated method stub
        Edge edge = new MovieDirectorRelation(label,weight);
        edge.addVertices(vertices);
        return edge;
    }

}
