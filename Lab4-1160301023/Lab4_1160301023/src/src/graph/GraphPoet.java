package src.graph;

import src.edge.Edge;
import src.vertex.Vertex;

public class GraphPoet<L extends Vertex,E extends Edge> extends ConcreteGraph<L,E> implements Graph<L, E>{

    public GraphPoet() {
        // TODO Auto-generated constructor stub
        checkRep();
    }
    // Abstraction function:
    //   VertexSet use HashSet for save all vertices of Graph.
    //   EdgeSet use HashSet for save all edges of Graph.
    //   GraphName of save name of Graph.
    // Representation invariant:
    //   VertexSet and EdgeSet do not be null.
    // Safety from rep exposure:
    //   all of field members is protected.in methods use these protected member,
    //   use defensive copy to avoid sharing field members.
    
   /* public GraphPoet(String name) {
            this.setName(name);
    }
*/
    /**
     * Add vertex to the graph
     * True if the edge does not exist in the origin graph
     * @param edge
     * @return
     */
    @Override
    public boolean addEdge(E edge) {
        // TODO Auto-generated method stub
        for (E e : super.edges) {
            if (e.vertices.get(0).getLabel().equals(edge.vertices.get(0).getLabel())
                    && e.vertices.get(0).getLabel().equals(edge.vertices.get(0).getLabel())) {
                e.weight += 1;
                return true;
            }
        }
        super.edges.add(edge);
        return true;
    }
 
    @Override
    public void checkRep(){
        for(Vertex v : vertices()){
            assert v.type().equals("Word");
        }
        for(Edge edge : edges()){
            assert edge.type().equals("WordNeighborhood");
        }
    }
}
