
package src.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.*;
import src.edge.Edge;
import src.graph.Graph;
import src.graph.GraphPoet;
import src.vertex.Vertex;

public class GraphPoetFactory extends GraphFactory {
            
    public <L extends Vertex, E extends Edge> Graph<Vertex, Edge> createGraph(String filePath) throws Exception {
        Graph<Vertex, Edge> graph = null;
        try {
            File file = new File(filePath);
            FileReader filereader = new FileReader(file);
            @SuppressWarnings("resource")
            BufferedReader BufR = new BufferedReader(filereader);
            String line = null;
            while ((line = BufR.readLine()) != null) {
                String[] buf = line.split(" = ");
                if (buf[0].equals("GraphType")) {
                    if (buf[1].equals("\"GraphPoet\""))
                        graph = new GraphPoet<>();
                    else {
                        System.out.println("The Graph is not the type of GraphPoet");
                        return null;
                    }
                }
                if (graph == null) {
                    System.out.println("The type of Graph is NULL");
                    return null;
                }
                if (buf[0].equals("GraphName")) {
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
                    switch (list.get(1)) {
                    case "Word":
                        Vertex vertex = new WordVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    default:
                        throw new GraphPoetVertexException("0");
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
                    if(Double.parseDouble(list.get(0))<0)
                        throw new GraphPoetNoWeightException("0");
                    switch (list.get(1)) {
                    case "WordEdge":
                        Vertex start = null;
                        Vertex end = null;
                        for (Vertex vertex : graph.vertices()) {
                            if (vertex.getLabel().equals(list.get(3))) {
                                start = vertex;
                            }
                            if (vertex.getLabel().equals(list.get(4))) {
                                end = vertex;
                            }
                        }
                        Edge edge = new WordEdgeFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
                    default:
                        throw new GraphPoetEdgeException("0");
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
