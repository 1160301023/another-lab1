package src.edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import src.vertex.Vertex;

public class DirectedEdge extends Edge {
	public DirectedEdge(String label, double weight) {
		super(label, weight);
		this.checkrep();
	}
	@Override
	public boolean addVertices(List<Vertex> vertices) {
		super.vertices = vertices;
		return true;
	}
	@Override
	public Set<Vertex> sourceVertices() {
		Set<Vertex> set = new HashSet<>();
		if(super.vertices.size() == 1){
			set.add(super.vertices.get(0));
			return set;
		}
		set.add(super.vertices.get(0));
		return set;
	}
	
	
	@Override
	public Set<Vertex> targetVertices() {
		Set<Vertex> set = new HashSet<>();
		if(super.vertices.size() == 1){
			set.add(super.vertices.get(0));
			return set;
		}
		set.add(super.vertices.get(1));
		return set;
	}

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "DirectedEdge";
    }
    @Override
    public boolean containVertex(Vertex v) {
        // TODO Auto-generated method stub
        if(super.vertices.contains(v))
            return true;        
        return false;
    }

    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }
}
