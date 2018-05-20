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
import src.graph.NetworkTopology;
import src.vertex.Vertex;

public class NetworkTopologyFactory extends GraphFactory {

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
                    if (buf[1].equals("\"NetworkTopology\""))
                        graph = new NetworkTopology<>();
                    else {
                        System.out.println("The Graph is not the type of NetworkTopology");
                        throw new NetworkTopologyLabelException();
                    }
                }
                if (graph == null) {
                    System.out.println("The type of Graph is NULL");
                    return null;
                }
                if (buf[0].equals("GraphName")) {
                    if(buf[1].replace("\"", "").equals("NetworkTopology"))
                        throw new NetworkTopologyLabelException();
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
                    if(list.size()!=3||str.length!=list.size()-2)
                        throw new DataMissingException();
                    Vertex vertex = null;
                    switch (list.get(1)) {
                    case "Computer":
                        vertex = new ComputerVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    case "Server":
                        vertex = new ServerVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    case "Router":
                        vertex = new RouterVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    case "WirelessRouter":
                        vertex = new WirelessRouterVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    default:
                        throw new NetworkTopologyVertexTypeException();
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
                    if(list.size()!=6)
                        throw new DataMissingException();
                    Edge edge = null;
                    Vertex start = null;
                    Vertex end = null;
                    switch (list.get(1)) {
                    case "NetworkConnection":
                        for (Vertex vertex : graph.vertices()) {
                            if (vertex.getLabel().equals(list.get(3)))
                            {    start = vertex;}
                            if (vertex.getLabel().equals(list.get(4)))
                            {   end = vertex;}

                        }
                        edge = new NetworkConnectionFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
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
