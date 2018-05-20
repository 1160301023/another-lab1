
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
import src.graph.SocialNetwork;
import src.vertex.Vertex;

public class SocialNetworkFactory extends GraphFactory {

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
                    if (buf[1].equals("\"SocialNetwork\""))
                        graph = new SocialNetwork<>();
                    else {
                        System.out.println("The Graph is not the type of SocialNetwork");
                        return null;
                    }
                }
                if (graph == null) {
                    System.out.println("The type of Graph is NULL");
                    return null;
                }
                if (buf[0].equals("GraphName")) {
                    if (!Pattern.matches("[\\w]*", buf[1].replace("\"", ""))) {
                        throw new SocialNetWorkLabelException();
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
                    if (list.size() != 4 || str.length != 2)
                        throw new DataMissingException();
                    if (!list.get(2).equals("M") && !list.get(2).equals("W"))
                        throw new SocialNetWorkSexException();
                    if (Double.parseDouble(list.get(3)) % 1 != 0 || Double.parseDouble(list.get(3)) < 0)
                        throw new SocialNetWorkAgeException();
                    switch (list.get(1)) {
                    case "Person":
                        Vertex vertex = new PersonVertexFactory().createVertex(list.get(0), str);
                        graph.addVertex(vertex);
                        break;
                    default:
                        throw new SocialNetWorkVertexTypeException();
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
                    Edge edge = null;
                    Vertex start = null;
                    Vertex end = null;
                    switch (list.get(1)) {
                    case "FriendConnection":
                        for (Vertex vertex : graph.vertices()) {
                            if (vertex.getLabel().equals(list.get(3)) && vertex.getLabel() != null) {
                                start = vertex;
                            }
                            if (vertex.getLabel().equals(list.get(4)) && vertex.getLabel() != null) {
                                end = vertex;
                            }
                        }

                        if (list.size() != 6)
                            throw new DataMissingException();
                        if (!list.get(5).equals("Yes") && !list.get(5).equals("No"))
                            throw new SocialNetWorkEdgeStandardException();
                        edge = new FriendConnectionFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
                    case "CommentConnection":
                        if (!list.get(5).equals("Yes") && !list.get(5).equals("No"))
                            throw new SocialNetWorkEdgeStandardException();
                        for (Vertex vertex : graph.vertices()) {
                            if (vertex.getLabel().equals(list.get(3)))
                                start = vertex;
                            if (vertex.getLabel().equals(list.get(4)))
                                end = vertex;
                        }
                        edge = new CommentConnectionFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
                    case "ForwardConnection":
                        if (!list.get(5).equals("Yes") && !list.get(5).equals("No"))
                            throw new SocialNetWorkEdgeStandardException();
                        for (Vertex vertex : graph.vertices()) {
                            if (vertex.getLabel().equals(list.get(3)))
                                start = vertex;
                            if (vertex.getLabel().equals(list.get(4)))
                                end = vertex;
                        }
                        edge = new ForwardConnectionFactory().createEdge(list.get(0), Arrays.asList(start, end),
                                Double.parseDouble(list.get(2)));
                        graph.addEdge(edge);
                        break;
                    default:
                        throw new SocialNetWorkNotFoundTypeException();
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
