package graph;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import src.edge.Edge;
import src.graph.Graph;
import src.graph.NetworkTopology;
import src.vertex.Vertex;

public class NetworkTopologyTest {

    @Test
    public void Emptytest() {
        Graph<Vertex, Edge> graph = new NetworkTopology<>();
        assertEquals(graph.vertices(), new HashSet<>());
    }

}
