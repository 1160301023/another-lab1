package src.graph;

import java.util.ArrayList;
import java.util.List;

import src.edge.Edge;
import src.vertex.Computer;
import src.vertex.Router;
import src.vertex.Server;
import src.vertex.Vertex;

public class NetworkTopology<L extends Vertex,E extends Edge> extends ConcreteGraph<L,E> {
        
    //Abstract Function 
    //Use three linked lists to store three different types of Vertex
    // Representation invariant:
    //Edge cannot be hyperedge
    // Safety from rep exposure:
    //all of field members is private
    
    List<Computer> computers = new ArrayList<>();
    List<Server> servers = new ArrayList<>();
    List<Router> routers = new ArrayList<>();
    public NetworkTopology() {
        checkRep();
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
        if(edge.vertices.size()!=2)
            return false;
        if(super.edges.contains(edge))
            return false;
        super.edges.add(edge);
        return true;
    }
    
    @Override
    public void checkRep(){
        for(Vertex vertex : vertices()){
            assert vertex.type().equals("Computer") || vertex.type().equals("Router") || vertex.type().equals("Server");
        }
        for(Edge edge : edges()){
            assert edge.type().equals("NetworkConnection");
        }
    }
}
