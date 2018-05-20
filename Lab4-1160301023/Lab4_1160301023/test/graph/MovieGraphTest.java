package graph;

import static org.junit.Assert.*;

import org.junit.Test;

import src.edge.Edge;
import src.helper.ParseCommandHelper;
import src.graph.Graph;
import src.graph.MovieGraph;
import src.vertex.Vertex;

public class MovieGraphTest {

    @Test
    public void test() {
        Graph<Vertex, Edge> graph2 = new MovieGraph<>();

        assertEquals(0, graph2.vertices().size());
        assertEquals(0, graph2.edges().size());

        String str = "vertex --add \"Robbins\" \"Actor\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "vertex --add \"Morgan\" \"Actor\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "vertex --add \"Hanks\" \"Actor\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "vertex --add \"Frank\" \"Director\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "vertex --add \"Redmption\" \"Movie\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "vertex --add \"GreenMile\" \"Movie\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);

        str = "edge --add aaa \"MovieDirectorRelation\" [weighted=Y] [-1] [directed=Y] \"Frank\", \"Redmption\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "edge --add aaaa \"MovieDirectorRelation\" [weighted=Y] [-1] [directed=Y] \"Frank\", \"GreenMile\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "edge --add aaaaa \"MovieActorRelation\" [weighted=Y] [1] [directed=Y] \"Robbins\", \"Redmption\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "edge --add aaaaaa \"MovieActorRelation\" [weighted=Y] [2] [directed=Y] \"Morgan\", \"Redmption\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "edge --add aaaaaaa \"MovieActorRelation\" [weighted=Y] [1] [directed=Y] \"GreenMile\", \"Hanks\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        str = "hyperedge --add aaaaaaaa \"SameMovieHyperEdge\" \"Robbins\", \"Morgan\"";
        ParseCommandHelper.parseAndExecuteCommand(graph2, str);
        assertEquals(6, graph2.vertices().size());
        assertEquals(5, graph2.edges().size());
    }

}
