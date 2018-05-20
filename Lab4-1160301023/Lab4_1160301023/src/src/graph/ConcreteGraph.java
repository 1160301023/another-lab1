
package src.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import src.edge.*;
import src.vertex.*;

class ConcreteGraph<L extends Vertex, E extends Edge>
    implements Graph<L, E> {
    

    //Abstraction function:
    //   VertexSet use HashSet for save all vertices of Graph.
    //   EdgeSet use HashSet for save all edges of Graph.
    //   GraphName of save name of Graph.
    // Representation invariant:
    //   VertexSet and EdgeSet do not be null.
    // Safety from rep exposure:
    //   all of field members is protected.in methods use these protected member,
    //   use defensive copy to avoid sharing field members.
    protected String name = null;

    public void checkRep(){
        
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<L> vertices = new ArrayList<>();
    List<E> edges = new ArrayList<>();
    
    /**
     * Add points to the graph
     * True if the vertex does not exist in the original graph
     * @param v
     * @return
     */
    @Override
    public boolean addVertex(L v) {
        // TODO Auto-generated method stub
        if(vertices.contains(v))
            return false;
        vertices.add(v);
        return true;
    }

    /**
     * Delete points from the graph
     * True if there is an edge in the original graph
     * @param v
     * @return
     */
    @Override
    public boolean removeVertex(L v) {
        // TODO Auto-generated method stub
        if(vertices.contains(v))
        {
            vertices.remove(v);
            for(E e:edges){
                if(e.vertices.get(0).equals(v)||e.vertices.get(1).equals(v)){
                    edges.remove(e);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Return the set of vertex in the figure
     * @return
     */
    @Override
    public Set<L> vertices() {
        // TODO Auto-generated method stub
        Set<L> set = new HashSet<>();
        for(L list:vertices)
            set.add(list);
        return set;
    }

    /**
     * Returns the weight of all edges with target as the vertex
     * @param target
     * @return
     */
    @Override
    public Map<L, List<Double>> sources(L target) {
        // TODO Auto-generated method stub
        List<Double> list = new ArrayList<>();
        Map<L, List<Double>> map = new HashMap<>();
        
        for(E edge:edges)
        {
            if(target.getLabel().equals(edge.vertices.get(0).getLabel())){
                list.add(edge.weight);
            }
        }
        
        map.put(target, list);
        return map;
    }

    /**
     * Returns the weight of all edges that end with source
     * @param source
     * @return
     */
    @Override
    public Map<L, List<Double>> targets(L source) {
        // TODO Auto-generated method stub
        List<Double> list = new ArrayList<>();
        Map<L, List<Double>> map = new HashMap<>();
        
        for(E edge:edges)
        {
            if(source.getLabel().equals(edge.vertices.get(1).getLabel())){
                list.add(edge.weight);
            }
        }
        
        map.put(source, list);
        return map;
    }

    /**
     * Add vertex to the graph
     * True if the edge does not exist in the origin graph
     * @param edge
     * @return
     */
    @Override
    public boolean addEdge(E edge) {
        // TODO Auto-generated method stub
        if(edges.contains(edge))
            return false;
        edges.add(edge);
        return true;
    }

    /**
     * Delete add from the graph
     * True if the edge exists in the origin graph
     * @param edge
     * @return
     */
    @Override
    public boolean removeEdge(E edge) {
        // TODO Auto-generated method stub
        if(edges.contains(edge))
        {
            edges.remove(edge);
            return true;
        }
        return false;
    }

    /**
     * return the set of edges
     * @return
     */
    @Override
    public Set<E> edges() {
        // TODO Auto-generated method stub
        Set<E> set = new HashSet<>();
        for(E edge:edges)
        {
            set.add(edge);
        }
        return set;
    }
    
    
}

