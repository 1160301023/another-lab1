package src.factory;

import java.util.List;

import src.edge.Edge;
import src.vertex.Vertex;
import src.edge.MovieActorRelation;

public class MovieActorRelationFactory extends EdgeFactory{

    @Override
    public Edge createEdge(String label, List<Vertex> vertices, double weight) {
        // TODO Auto-generated method stub
        Edge edge = new MovieActorRelation(label,weight);
        edge.addVertices(vertices);
        return edge;
    }

}
