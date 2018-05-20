package src.edge;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import src.vertex.Vertex;

public class WordEdge extends DirectedEdge{

    public WordEdge(String label, double weight) {
        super(label, weight);
        this.checkrep();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "WordNeighborhood";
    }
    
    @Override
    public boolean addVertices(List<Vertex> vertices) {
        // TODO Auto-generated method stub
        if(vertices.get(0).getLabel().equals(vertices.get(1).getLabel())){
            super.vertices = new ArrayList<>();
            super.vertices.add(vertices.get(0));
            return true;
        }
        super.vertices.addAll(vertices);
        return true;
    }
    
    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }
}

