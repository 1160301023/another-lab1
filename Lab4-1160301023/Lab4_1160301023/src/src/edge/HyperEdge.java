package src.edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import src.vertex.Vertex;

public class HyperEdge extends Edge{

    public HyperEdge(String label, double weight) {
        super(label, weight);
        this.checkrep();
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean addVertices(List<Vertex> vertices) {
        // TODO Auto-generated method stub
        if(vertices.isEmpty()||vertices.size()<=2)
            return false;
        super.vertices = vertices;
        return true;
    }

    @Override
    public Set<Vertex> sourceVertices() {
        // TODO Auto-generated method stub
        Set<Vertex> set = new HashSet<>();
        set.addAll(super.vertices);
        return set;
    }

    @Override
    public Set<Vertex> targetVertices() {
        // TODO Auto-generated method stub
        Set<Vertex> set = new HashSet<>();
        set.addAll(super.vertices);
        return set;
    }

    @Override
    public boolean containVertex(Vertex v) {
        // TODO Auto-generated method stub
        if(super.vertices.contains(v))
            return true;
        return false;
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "HyperEdge";
    }
    
    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }

}
