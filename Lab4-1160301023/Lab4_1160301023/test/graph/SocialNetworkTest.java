package graph;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import src.edge.DirectedEdge;
import src.edge.Edge;
import src.graph.Graph;
import src.graph.SocialNetwork;
import src.vertex.Vertex;
import src.vertex.Word;

public class SocialNetworkTest {

    @Test
    public void test() {
        Graph<Vertex, Edge> graph =  new SocialNetwork<>();
        Word word1 = new Word("word1");
        Word word2 = new Word("word2");
        Word word3 = new Word("word3");
        
        DirectedEdge directedEdge1 = new DirectedEdge("Edge1", 0.1);
        directedEdge1.vertices.add(word1);
        directedEdge1.vertices.add(word2);
        DirectedEdge directedEdge2 = new DirectedEdge("Edge1", 0.5);
        directedEdge2.vertices.add(word3);
        directedEdge2.vertices.add(word2);
        DirectedEdge directedEdge3 = new DirectedEdge("Edge1", 0.4);
        directedEdge3.vertices.add(word2);
        directedEdge3.vertices.add(word3);
        
        graph.addEdge(directedEdge1);
        Set<DirectedEdge> set = new HashSet<>();
        set.add(directedEdge1);
        assertEquals(set, graph.edges());
        
        graph.removeEdge(directedEdge1);
        set.remove(directedEdge1);
        
        
        assertEquals(set, graph.edges());
    }

}
