package src.graph;

import java.util.ArrayList; 
import java.util.List;
import src.edge.Edge;
import src.edge.MovieActorRelation;
import src.edge.MovieDirectorRelation;
import src.edge.SameMovieHyperEdge;
import src.vertex.Actor;
import src.vertex.Director;
import src.vertex.Movie;
import src.vertex.Vertex;

public class MovieGraph<L extends Vertex,E extends Edge> extends ConcreteGraph<L, E>{
	
    public MovieGraph(String name) {
		this.setName(name);
	}
	public MovieGraph(){
		checkRep();
	}

	List<Actor> actor = new ArrayList<>();
	List<Movie> movie = new ArrayList<>();
	List<Director> director = new ArrayList<>();
	
	List<MovieActorRelation> movieActorRelation = new ArrayList<>();
	List<MovieDirectorRelation> movieDirectorRelation = new ArrayList<>();
	List<SameMovieHyperEdge> sameMovieHyperEdge = new ArrayList<>();
	
	@Override
	public boolean addVertex(L v) {
		if(vertices().contains(v)){
			return false;
		}
		if(v.type().equals("Actor")){
			actor.add((Actor) v);
		}else if (v.type().equals("Movie")) {
			movie.add((Movie)v);
		}else if(v.type().equals("Director")){
			director.add((Director) v);
		}
		super.vertices.add(v);
		return true;
	}
	@Override
	public boolean removeVertex(L v) {
		if(!vertices().contains(v)){
			return false;
		}
		if(v.type().equals("Actor")){
			actor.remove(v);
		}else if (v.type().equals("Movie")) {
			movie.remove(v);
		}else if(v.type().equals("Director")){
			director.remove(v);
		}
		return true;
	}
	
	@Override
	public boolean addEdge(E edge) {
		if(edges().contains(edge)){
			return false;
		}
		super.edges.add(edge);
		if(edge.type().equals("MovieActorRelation")){
			movieActorRelation.add((MovieActorRelation) edge);
		}else if(edge.type().equals("MovieDirectorRelation")){
			movieDirectorRelation.add((MovieDirectorRelation) edge);
		}else if(edge.type().equals("SameMovieHyperEdge")){
			sameMovieHyperEdge.add((SameMovieHyperEdge) edge);
		}
		checkRep();
		return true;
	}

	@Override
	public boolean removeEdge(E edge) {
		if(!edges().contains(edge)){
			return false;
		}
		super.edges.remove(edge);
		if(edge.type().equals("MovieActorRelation")){
			movieActorRelation.remove(edge);
		}else if(edge.type().equals("MovieDirectorRelation")){
			movieDirectorRelation.remove(edge);
		}else if(edge.type().equals("SameMovieHyperEdge")){
			sameMovieHyperEdge.remove(edge);
		}
		return true;
	}

	@Override
    public void checkRep(){
        for(Vertex v:vertices()){
            assert v.type().equals("Actor") || v.type().equals("Director") || v.type().equals("Movie");
        }
        for(Edge edge : edges()){
            assert edge.type().equals("MovieActorRelation") || edge.type().equals("MovieDirectorRelation")
            || edge.type().equals("SameMovieHyperEdge");
        }
    }
}
