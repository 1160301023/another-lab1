package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.GraphPoetVertexException;
import src.edge.Edge;
import src.factory.GraphPoetFactory;
import src.graph.Graph;
import src.vertex.Vertex;

public class GraphPoetFactoryTest {

    @Test
    public void GraphPoetVertexExceptiontest() throws Exception {
        boolean flag = false;
        try{
        Graph<Vertex, Edge> graph = new GraphPoetFactory().createGraph("0.txt");
        }catch (GraphPoetVertexException e) {
            // TODO: handle exception
            flag = true;
            System.out.println(e.message());
            assertEquals(e.getClass().getName(), "GraphPoetVertexException111");
        }
        
    }

}
