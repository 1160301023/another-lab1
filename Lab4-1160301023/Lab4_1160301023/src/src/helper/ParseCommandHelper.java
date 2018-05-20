package src.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import src.edge.*;
import src.graph.*;
import src.vertex.*;;

public class ParseCommandHelper {
    @SuppressWarnings("unchecked")
    public static <L, E> void parseAndExecuteCommand(Graph<L, E> g, String command) {
        boolean flag = true;
        String[] temp = command.split(" ");
        switch (temp[0]) {
        case "vertex":
            switch (temp[1]) {
            case "--add":
                Vertex vertex = null;
                for (L key : g.vertices()) {
                    if (((Vertex) key).getLabel().equals(temp[2].replace("\"", "")))
                        flag = false;
                }
                if (flag)
                    switch (temp[3].replace("\"", "")) {
                    case "Word":
                        if (g instanceof GraphPoet)
                            vertex = new Word(temp[2].replace("\"", ""));
                        break;
                    case "Person":
                        if (g instanceof SocialNetwork)
                            vertex = new Person(temp[2].replace("\"", ""));
                        break;
                    case "Computer":
                        if (g instanceof NetworkTopology)
                            vertex = new Computer(temp[2].replace("\"", ""));
                        break;
                    case "Router":
                        if (g instanceof NetworkTopology)
                            vertex = new Router(temp[2].replace("\"", ""));
                        break;
                    case "Server":
                        if (g instanceof NetworkTopology)
                            vertex = new Server(temp[2].replace("\"", ""));
                        break;
                    case "Actor":
                        if (g instanceof MovieGraph)
                            vertex = new Actor(temp[2].replace("\"", ""));
                        break;
                    case "Director":
                        if (g instanceof MovieGraph)
                            vertex = new Director(temp[2].replace("\"", ""));
                        break;
                    case "Movie":
                        if (g instanceof MovieGraph)
                            vertex = new Movie(temp[2].replace("\"", ""));
                        break;
                    case "WirelessRouter":
                        if(g instanceof NetworkTopology)
                            vertex = new WirelessRouter(temp[2].replace("\"", ""));
                        break;
                    }
                if (vertex != null) {
                    g.addVertex((L) vertex);
                    System.out.println("Add Completed");
                } else
                    System.out.println("Add Failed");
                break;
            case "--delete":
                boolean fl = false;
                if (!g.vertices().isEmpty()) {
                    for (L key : g.vertices())
                    {
                        if (Pattern.matches(temp[2].replace("\"", ""), ((Vertex) key).getLabel()))
                        {
                            fl = g.removeVertex(key);
                        }
                    }
                }
                if (fl)
                    System.out.println("Delete Completed");
                else
                    System.out.println("Delete Failed");
                break;
            }
            break;
        case "edge":
            switch (temp[1]) {
            case "--add":
                Edge edge = null;
                Vertex v1 = null, v2 = null;
                if (!g.vertices().isEmpty()) {
                    for (L key : g.vertices()) {
                        if (((Vertex) key).getLabel().equals((temp[7].replace(",", "")).replace("\"", ""))) {
                            v1 = (Vertex) key;
                        }
                        if (((Vertex) key).getLabel().equals(temp[8].replace("\"", ""))) {
                            v2 = (Vertex) key;
                        }
                    }
                }

                if (v1 != null && v2 != null) {

                    temp[5] = temp[5].replace("[", "");
                    temp[5] = temp[5].replace("]", "");
                    switch (temp[3].replace("\"", "")) {
                    case "WordEdge":
                        if (g instanceof GraphPoet) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof WordEdge)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                edge = new WordEdge(temp[2].replace("\"", ""), Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));

                            }
                        }
                        break;
                    case "FriendConnection":
                        if (g instanceof SocialNetwork) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof FriendConnection)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                edge = new FriendConnection(temp[2], Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));
                            }
                        }
                        break;
                    case "CommentConnection":
                        if (g instanceof SocialNetwork) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof CommentConnection)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                edge = new CommentConnection(temp[2], Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));
                            }
                        }
                        break;
                    case "ForwardConnection":
                        if (g instanceof SocialNetwork) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof ForwardConnection)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                edge = new ForwardConnection(temp[2], Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));
                            }
                        }
                        break;
                    case "NetworkConnection":
                        if (g instanceof NetworkTopology) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof NetworkConnection)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                if (v1 instanceof Computer && v2 instanceof Computer)
                                    break;
                                edge = new NetworkConnection(temp[2], Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));
                            }
                        }
                        break;
                    case "MovieActorRelation":
                        if (g instanceof MovieGraph) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof MovieActorRelation)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                edge = new MovieActorRelation(temp[2], Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));
                            }
                        }
                        break;
                    case "MovieDirectorRelation":
                        if (g instanceof MovieGraph) {
                            if (!g.edges().isEmpty()) {
                                for (E key : g.edges()) {
                                    if (((Edge) key).vertices().contains(v1) && ((Edge) key).vertices().contains(v2))
                                        if (((Edge) key) instanceof MovieDirectorRelation)
                                            flag = false;
                                }
                            }
                            if (flag) {
                                edge = new MovieDirectorRelation(temp[2], Double.parseDouble(temp[5]));
                                edge.addVertices(Arrays.asList(v1, v2));
                            }
                        }
                        break;
                    }
                }

                if (edge != null) {
                    g.addEdge((E) edge);
                    System.out.println("Add Completed");
                } else
                    System.out.println("Add Failed");
                break;
            case "--delete":
                boolean fl = false;
                if (!g.edges().isEmpty()) {
                    for (E key : g.edges())
                        if (Pattern.matches(temp[2].replace("\"", ""), ((Edge) key).getLabel()))
                        {
                            fl = g.removeEdge(key);
                        }
                }
                if (fl)
                    System.out.println("Delete Completed");
                else
                    System.out.println("Delete Failed");
                break;
            }
            break;
        case "hyperedge":
            switch (temp[1]) {
            case "--add":
                if(!(g instanceof MovieGraph))
                {
                    System.out.println("Add Failed");
                    break;
                }
                if (temp[3].replace("\"", "").equals("SameMovieHyperEdge")) {
                    Edge edge = null;
                    if (!g.edges().isEmpty()) {
                        List<Vertex> list = new ArrayList<>();
                        for (int i = 4; i < temp.length; i++) {
                            for (L key : g.vertices()) {
                                if (((Vertex) key).getLabel().equals(temp[4].replace("\"", "").replace(",", "")))
                                    list.add((Vertex) key);
                            }
                        }
                        if (list.size() >= 2) {
                            edge = new SameMovieHyperEdge(temp[2].replace("\"", ""), -1);
                            edge.addVertices(list);
                        }
                    }
                    if (edge != null)
                        System.out.println("Add Completed");
                    else
                        System.out.println("Add Failed");
                }
                break;
            }
            break;
        }

    }
}
