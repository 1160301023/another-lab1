package factory;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.DataMissingException;
import exception.MovieGraphActorAgeException;
import exception.MovieGraphGradeException;
import exception.MovieGraphLabelException;
import exception.MovieGraphYearException;
import src.edge.Edge;
import src.factory.MovieGraphFactory;
import src.graph.Graph;
import src.vertex.Vertex;

public class MovieGraphFactoryTest {

    @Test
    public void MovieGraphLabelExceptiontest() throws Exception {
        try {
            Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph("1.txt");
        } catch (MovieGraphLabelException e) {
            // TODO: handle exception
            assertEquals(e.getClass().getName(), "MovieGraphLabelException");
        }
    }
    
    @Test
    public void MovieGraphLabelException2test() throws Exception{
        try {
            Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph("2.txt");
        } catch (MovieGraphLabelException e) {
            // TODO: handle exception
            assertEquals(e.getClass().getName(), "MovieGraphLabelException");
        }
    }

    @Test
    public void MovieGraphYearExceptiontest() throws Exception{
        try {
            Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph("3.txt");
        } catch (MovieGraphYearException e) {
            // TODO: handle exception
            assertEquals(e.getClass().getName(), "MovieGraphYearException");
        }
    }
    
    @Test
    public void MovieGraphGradeExceptiontest() throws Exception{
        try {
            Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph("4.txt");
        } catch (MovieGraphGradeException e) {
            // TODO: handle exception
            assertEquals(e.getClass().getName(), "MovieGraphGradeException");
        }
    }
    
    @Test
    public void DataMissingExceptiontest() throws Exception{
        try {
            Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph("5.txt"); 
        } catch (DataMissingException e) {
            // TODO: handle exception
            assertEquals(e.getClass().getName(), "DataMissingException");
        }
    }
    
    @Test
    public void MovieGraphActorAgeExceptiontest() throws Exception{
        try {
            Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph("6.txt"); 
        } catch (MovieGraphActorAgeException e) {
            // TODO: handle exception
            assertEquals(e.getClass().getName(), "MovieGraphActorAgeException");
        }
    }
}
