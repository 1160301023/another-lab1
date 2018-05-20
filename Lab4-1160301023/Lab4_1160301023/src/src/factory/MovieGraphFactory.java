package src.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.*;
import src.edge.Edge;
import src.graph.Graph;
import src.graph.MovieGraph;
import src.vertex.Vertex;

public class MovieGraphFactory extends GraphFactory {

    
    @Override
    public <L extends Vertex, E extends Edge> Graph<Vertex, Edge> createGraph(String filePath) throws Exception {
        // TODO Auto-generated method stub
        Graph<Vertex, Edge> graph = null;
        try {
            File file = new File(filePath);
            FileReader filereader = new FileReader(file);
            @SuppressWarnings("resource")
            BufferedReader BufR = new BufferedReader(filereader);
            String line;
            while ((line = BufR.readLine()) != null) {
                String[] buf = line.split(" = ");
                if (buf[0].equals("GraphType")) {
                    if (buf[1].equals("\"MovieGraph\""))
                        graph = new MovieGraph<>();
                    else {
                        System.out.println("The Graph is not the type of MovieGraph");
                        return null;
                    }
                }
                if (graph == null) {
                    System.out.println("The type of Graph is NULL");
                    return null;
                }
                if (buf[0].equals("GraphName")) {
                    if (!Pattern.matches("[\\w]*", buf[1].replace("\"", ""))) {
                        throw new MovieGraphLabelException();
                    }
                    graph.setName(buf[1].replace("\"", ""));
                } else if (buf[0].equals("Vertex")) {
                    Pattern p = Pattern.compile("\"([^\"]*)\"");
                    Matcher m = p.matcher(buf[1]);
                    List<String> list = new ArrayList<>();
                    String[] str = new String[3];
                    int i = 0;
                    while (m.find(i)) {
                        list.add(m.group().replace("\"", ""));
                        i = m.start() + m.group().length();
                    }
                    for (i = 2; i < list.size(); i++) {
                        str[i - 2] = list.get(i);
                    }
                    Vertex vertex = null;
                    if (!Pattern.matches("[\\w]*", list.get(0))) {
                        throw new MovieGraphLabelException();
                    }
                    switch (list.get(1)) {
                    case "Movie":
                        if (Double.parseDouble(str[0]) % 1 != 0 || Double.parseDouble(str[0]) < 1900
                                || Double.parseDouble(str[0]) > 2018)
                            throw new MovieGraphYearException();
                        if (Double.parseDouble(str[2]) < 0 || Double.parseDouble(str[2]) > 10)
                            throw new MovieGraphGradeException();
                        if (str.length != 3)
                            throw new DataMissingException();
                        vertex = new MovieVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    case "Actor":
                        if (Double.parseDouble(str[0]) <= 0 || Double.parseDouble(str[0]) % 1 != 0)
                            throw new MovieGraphActorAgeException();
                        if (!str[1].equals("M") && !str[1].equals("W"))
                            throw new MovieGraphActorSexException();
                        vertex = new ActorVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    case "Director":
                        if (Double.parseDouble(str[0]) <= 0 || Double.parseDouble(str[0]) % 1 != 0)
                            throw new MovieGraphDirectorAgeException();
                        if (!str[1].equals("M") && !str[1].equals("W"))
                            throw new MovieGraphDirectorSexException();
                        vertex = new DirectorVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    }
                } else if (buf[0].equals("Edge")) {
                    Pattern p = Pattern.compile("\"([^\"]*)\"");
                    Matcher m = p.matcher(buf[1]);
                    List<String> list = new ArrayList<>();
                    int i = 0;
                    while (m.find(i)) {
                        list.add(m.group().replace("\"", ""));
                        i = m.start() + m.group().length();
                    }
                    if (list.size() != 6)
                        throw new DataMissingException();
                    if (!list.get(5).equals("Yes") && !list.get(5).equals("No"))
                        throw new MovieGraphEdgeStandardException();
                    Edge edge = null;
                    Vertex start = null;
                    Vertex end = null;
                    switch (list.get(1)) {
                    case "MovieActorRelation":
                        
                        for (Vertex vertex : graph.vertices()) {

                            if (vertex.getLabel().equals(list.get(3))&&vertex.getLabel()!=null)
                            { start = vertex;}
                            if (vertex.getLabel().equals(list.get(4))&&vertex.getLabel()!=null)
                            { end = vertex;}
                        }
                        
                        if(Double.parseDouble(list.get(2))==-1)
                            throw new MovieGraphEdgeWeightException();
                        edge = new MovieActorRelationFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
                    case "MovieDirectorRelation":
                        if(Double.parseDouble(list.get(2))!=-1)
                            throw new MovieGraphEdgeWeightException();

                        for (Vertex vertex : graph.vertices()) {
                            if (vertex.getLabel().equals(list.get(3)) && vertex.getLabel() != null) {
                                start = vertex;
                         }
                            if (vertex.getLabel().equals(list.get(4)) && vertex.getLabel() != null) {
                                end = vertex;

                            }

                        }
                        edge = new MovieDirectorRelationFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
                    }
                } else if (buf[0].equals("HyperEdge")) {
                    Pattern p = Pattern.compile("\"([^\"]*)\"");
                    Matcher m = p.matcher(buf[1]);
                    List<String> list = new ArrayList<>();
                    int i = 0;
                    while (m.find(i)) {
                        list.add(m.group().replace("\"", ""));
                        i = m.start() + m.group().length();
                    }
                    Edge edge = null;
                    if (!Pattern.matches("[\\w]*", list.get(0)))
                    {
                        throw new MoviGraphEdgeLabelException();
                    }
                    switch (list.get(1)) {
                    case "SameMovieHyperEdge":
                        List<Vertex> vertexlist = new ArrayList<>();
                        for (int j = 2; j < list.size(); j++) {
                            for (Vertex vertex : graph.vertices()) {
                                if (vertex.getLabel().equals(list.get(j)))
                                    vertexlist.add(vertex);
                            }
                        }
                        if(vertexlist.size() != list.size()-2)
                            throw new DataMissingException();
                        if(vertexlist.size()<2)
                            throw new HyperEdgeException();
                        edge = new SameMovieHyperEdgeFactory().createEdge(list.get(0), vertexlist, -1);
                        graph.addEdge(edge);
                        break;
                        default:
                            throw new HyperEdgeNotExistException();
                    }
                }

            }
            BufR.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        return graph;
    }

}
