package src.factory;

import src.edge.Edge;
import src.graph.Graph;
import src.vertex.Vertex;

public abstract class GraphFactory {
    
    public abstract <L extends Vertex,E extends Edge> Graph<Vertex,Edge> createGraph(String filePath) throws Exception;
}
