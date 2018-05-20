package src.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;


import src.edge.Edge;
import src.vertex.Vertex;

public interface Graph<L,E> {
    
    /**
     * return an empty graph
     * @return
     */
    public static <L extends Vertex,E extends Edge> Graph<L,E> empty() {
        Graph<L,E> concreteGraph = new ConcreteGraph<>();
        return concreteGraph;
    }
    
    /**
     * Add points to the graph
     * True if the vertex does not exist in the original graph
     * @param v
     * @return
     */
    public boolean addVertex(L v);
    
    /**
     * Delete points from the graph
     * True if there is an edge in the original graph
     * @param v
     * @return
     */
    public boolean removeVertex(L v);
    
    /**
     * Return the set of vertex in the figure
     * @return
     */
    public Set<L> vertices();
    
    /**
     * Returns the weight of all edges with target as the vertex
     * @param target
     * @return
     */
    public Map<L, List<Double>> sources(L target);
    
    /**
     * Returns the weight of all edges that end with source
     * @param source
     * @return
     */
    public Map<L, List<Double>> targets(L source);
    
    /**
     * Add vertex to the graph
     * True if the edge does not exist in the origin graph
     * @param edge
     * @return
     */
    public boolean addEdge(E edge);
    
    /**
     * Delete add from the graph
     * True if the edge exists in the origin graph
     * @param edge
     * @return
     */
    public boolean removeEdge(E edge);
    
    
    /**
     * return the set of edges
     * @return
     */
    public Set<E> edges();
    
    /**
     * Set the Name of Graph.
     * 
     * @param the name of Graph. (String)
     */
    public void setName(String name);
    
    /**
     * Get the Name of Graph.
     * 
     * @return String, Name of Graph.
     */
    public String getName();
}
