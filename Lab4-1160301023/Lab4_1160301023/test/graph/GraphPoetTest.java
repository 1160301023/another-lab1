package graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import src.edge.DirectedEdge;
import src.edge.Edge;
import src.graph.GraphPoet;
import src.vertex.Vertex;
import src.vertex.Word;

public class GraphPoetTest {

    @Test
    public void AddVertextest() {
        GraphPoet<Vertex, Edge> graph = new GraphPoet<>();
        Word word1 = new Word("word1");
        Word word2 = new Word("word2");
        Word word3 = new Word("word3");
        Word word4 = new Word("word4");
        Word word5 = new Word("word5");
        
        graph.addVertex(word1);
        graph.addVertex(word2);
        graph.addVertex(word3);
        graph.addVertex(word4);
        graph.addVertex(word5);
        
        List<Word> list = new ArrayList<>();
        list.add(word1);
        list.add(word2);
        list.add(word3);
        list.add(word4);
        list.add(word5);
        
        assertEquals(list, graph.vertices);
    }

    @Test
    public void AddEdgetest(){
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
        
        List<Word> list = new ArrayList<>();
        list.add(word3);
        list.add(word2);
        
        assertEquals(directedEdge1.vertices.get(0), word1);
        assertEquals(list, directedEdge2.vertices);
    }
}
