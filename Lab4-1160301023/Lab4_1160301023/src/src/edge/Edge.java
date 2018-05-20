package src.edge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import src.vertex.*;

public abstract class Edge {
    public List<Vertex> vertices = new ArrayList<>();
    private String label;
    public double weight = -1;
    
    public abstract boolean addVertices(List<Vertex> vertices);
    public abstract Set<Vertex> sourceVertices();
    public abstract Set<Vertex> targetVertices();
    public abstract boolean containVertex(Vertex v);
    
    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Edge(String label, double weight) {
        this.label = label;
        this.weight = weight;
    }
    
    public String type() {
        return null;
    }
    
    
    public int hashCode()
    {
        return this.label.hashCode();
    }
    
    public Set<Vertex> vertices() {
        // TODO Auto-generated method stub
        Set<Vertex> set = new HashSet<>();
        set.addAll(vertices);
        return set;
    }
    
    public boolean equals(Edge edge) {
        // TODO Auto-generated method stub
        if(edge.getLabel().equals(this.getLabel())&&edge.getWeight()==this.getWeight()&&edge.hashCode()==this.hashCode())
            return true;
        return false;
    }

    public String toString()
    {
        return this.type();
    }
}
