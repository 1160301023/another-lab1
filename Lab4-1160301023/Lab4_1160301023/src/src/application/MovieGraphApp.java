package src.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.*;
import src.edge.Edge;
import src.factory.MovieGraphFactory;
import src.graph.Graph;
import src.helper.GraphMetrics;
import src.helper.ParseCommandHelper;
import src.vertex.Vertex;

public class MovieGraphApp {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        try{
        Scanner scan = new Scanner(System.in);
        System.out.print("Input FilePath:");
        Graph<Vertex, Edge> graph = new MovieGraphFactory().createGraph(scan.next());
        if (graph == null)
            System.out.println("Load Failed");
        else
            System.out.println("Load Completed");
        while (graph != null) {
            String str = scan.nextLine();
            if (str.equals("print graph")) {
                System.out.println(graph.getName());
                for (Vertex vertex : graph.vertices()) {
                    System.out.println("[" + vertex.toString() + "]");
                }
                for (Edge edge : graph.edges()) {
                    System.out.println("[" + edge.toString() + "]");
                }
            } else {
                boolean flag = false;
                String temp[] = str.split(" ");
                switch (temp[0]) {
                case "exit":
                    graph = null;
                    break;
                case "vertex":
                    switch (temp[1]) {
                    case "--changelabel":
                        if (!graph.vertices().isEmpty()) {
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", ""))) {
                                    key.setLabel(temp[3].replace("\"", ""));
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag)
                            System.out.println("Change Completed");
                        else
                            System.out.println("Change Failed");
                        break;
                    case "--changeinfo":
                        if (!graph.vertices().isEmpty()) {
                            String[] astr = new String[1];
                            astr[0] = temp[3].replace("\"", "");
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", ""))) {
                                    key.fillVertexInfo(astr);
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag)
                            System.out.println("Change Completed");
                        else
                            System.out.println("Change Failed");
                    }
                    break;
                case "edge":
                    switch (temp[1]) {
                    case "--changelabel":
                        if (!graph.edges().isEmpty()) {
                            for (Edge key : graph.edges()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    key.setLabel(temp[3].replace("\"", ""));
                                flag = true;
                                break;
                            }
                        }
                        if (flag)
                            System.out.println("Change Completed");
                        else
                            System.out.println("Change Failed");
                        break;
                    case "--changevalue":
                        if (!graph.edges().isEmpty()) {
                            for (Edge key : graph.edges()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    key.setWeight(Double.parseDouble(temp[3].replace("\"", "")));
                                flag = true;
                                break;
                            }
                        }
                        if (flag)
                            System.out.println("Change Completed");
                        else
                            System.out.println("Change Failed");
                        break;
                    }
                    break;
                case "hyperedge":
                    switch (temp[1]) {
                    case "--addvertex":
                        List<Vertex> list = new ArrayList<>();
                        if (!graph.vertices().isEmpty()) {
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[3].replace("\"", ""))) {
                                    list.add(key);
                                    break;
                                }

                            }
                        }
                        if (!graph.edges().isEmpty()) {
                            for (Edge key : graph.edges()) {
                                if (key.getLabel().equals(temp[2].replace("\"", ""))) {
                                    if (!graph.vertices().isEmpty()) {
                                        for (Vertex vertex : key.vertices()) {
                                            list.add(vertex);
                                        }
                                    }
                                    key.addVertices(list);
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag)
                            System.out.println("Change Completed");
                        else
                            System.out.println("Change Failed");
                        break;
                    case "--deletevertex":
                        List<Vertex> list2 = new ArrayList<>();
                        if (!graph.edges().isEmpty()) {
                            for (Edge key : graph.edges()) {
                                if (key.getLabel().equals(temp[2].replace("\"", ""))) {
                                    if (!graph.vertices().isEmpty()) {
                                        for (Vertex vertex : key.vertices()) {
                                            if (!vertex.getLabel().equals(temp[3].replace("\"", "")))
                                                list2.add(vertex);
                                        }
                                    }
                                    key.addVertices(list2);
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag)
                            System.out.println("Change Completed");
                        else
                            System.out.println("Change Failed");
                        break;
                    }
                    break;
                case "graph":
                    switch (temp[1]) {
                    case "--degree":
                        if (temp.length == 2) {
                            System.out.println("degreeCentrality: " + GraphMetrics.degreeCentrality(graph));
                        } else {
                            if (!graph.vertices().isEmpty()) {
                                Vertex vertex = null;
                                for (Vertex key : graph.vertices()) {
                                    if (key.getLabel().equals(temp[2].replace("\"", "")))
                                        vertex = key;
                                }
                                if (vertex != null) {
                                    System.out.println("degreeCentrality, " + vertex.getLabel() + ": "
                                            + GraphMetrics.degreeCentrality(graph, vertex));
                                }
                            }
                        }
                        break;
                    case "--closeness":
                        if (!graph.vertices().isEmpty()) {
                            Vertex vertex = null;
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    vertex = key;
                            }
                            if (vertex != null) {
                                if (GraphMetrics.closenessCentrality(graph, vertex) == Double.MAX_VALUE)
                                    System.out.println("closenessCentrality, " + vertex.getLabel() + ": Infinite");
                                else
                                    System.out.println("closenessCentrality, " + vertex.getLabel() + ": "
                                            + GraphMetrics.closenessCentrality(graph, vertex));
                            }
                        }
                        break;
                    case "--betweenness":
                        if (!graph.vertices().isEmpty()) {
                            Vertex vertex = null;
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    vertex = key;
                            }
                            if (vertex != null) {
                                if (GraphMetrics.betweennessCentrality(graph, vertex) == Double.MAX_VALUE)
                                    System.out.println("betweennessCentrality, " + vertex.getLabel() + ": Infinite");
                                else
                                    System.out.println("betweennessCentrality, " + vertex.getLabel() + ": "
                                            + GraphMetrics.betweennessCentrality(graph, vertex));
                            }
                        }
                        break;
                    case "--inDegree":
                        if (!graph.vertices().isEmpty()) {
                            Vertex vertex = null;
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    vertex = key;
                            }
                            if (vertex != null) {
                                System.out.println("inDegreeCentrality, " + vertex.getLabel() + ": "
                                        + GraphMetrics.inDegreeCentrality(graph, vertex));
                            }
                        }
                        break;
                    case "--outDegree":
                        if (!graph.vertices().isEmpty()) {
                            Vertex vertex = null;
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    vertex = key;
                            }
                            if (vertex != null) {
                                System.out.println("outDegreeCentrality, " + vertex.getLabel() + ": "
                                        + GraphMetrics.outDegreeCentrality(graph, vertex));
                            }
                        }
                        break;
                    case "--eccentricity":
                        if (!graph.vertices().isEmpty()) {
                            Vertex vertex = null;
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "")))
                                    vertex = key;
                            }
                            if (vertex != null) {
                                if (GraphMetrics.eccentricity(graph, vertex) == Double.MAX_VALUE)
                                    System.out.println("eccentricity, " + vertex.getLabel() + ": Infinite");
                                else
                                    System.out.println("eccentricity, " + vertex.getLabel() + ": "
                                            + GraphMetrics.eccentricity(graph, vertex));
                            }
                        }
                        break;
                    case "--radius":
                        if (GraphMetrics.radius(graph) == Double.MAX_VALUE)
                            System.out.println("radius: Infinite");
                        else
                            System.out.println("radius: " + GraphMetrics.radius(graph));
                        break;
                    case "--diameter":
                        if (GraphMetrics.diameter(graph) == Double.MAX_VALUE)
                            System.out.println("diameter: Infinite");
                        else
                            System.out.println("diameter: " + GraphMetrics.diameter(graph));
                        break;
                    case "--distance":
                        if (!graph.vertices().isEmpty()) {
                            Vertex source = null, target = null;
                            for (Vertex key : graph.vertices()) {
                                if (key.getLabel().equals(temp[2].replace("\"", "").replace(",", "")))
                                    source = key;
                                if (key.getLabel().equals(temp[3].replace("\"", "").replace(",", "")))
                                    target = key;
                            }
                            if (source != null && target != null) {
                                if (GraphMetrics.distance(graph, source, target) == Double.MAX_VALUE)
                                    System.out.println("distance, " + source.getLabel() + " => " + target.getLabel()
                                            + ": Infinite");
                                else
                                    System.out.println("distance, " + source.getLabel() + " => " + target.getLabel()
                                            + ": " + GraphMetrics.distance(graph, source, target));
                            }
                        }
                        break;
                    }
                    break;
                }
                ParseCommandHelper.parseAndExecuteCommand(graph, str);
            }
        }
        }catch (MovieGraphLabelException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphYearException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphGradeException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphActorAgeException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphActorSexException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (DataMissingException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphDirectorAgeException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphDirectorSexException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphEdgeStandardException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphStartEndException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MovieGraphEdgeWeightException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (MoviGraphEdgeLabelException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (HyperEdgeException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }catch (HyperEdgeNotExistException e) {
            // TODO: handle exception
            System.out.println(e.message());
        }
        System.out.println("Exit Program~!");
    }
}
