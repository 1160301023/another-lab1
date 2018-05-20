package src.helper;

import src.graph.Graph;
import src.vertex.Vertex;
import java.util.HashMap;
import java.util.Map;

import src.edge.DirectedEdge;
import src.edge.Edge;
import src.edge.UndirectedEdge;

public class GraphMetrics{
    
    public static <L, E> double degreeCentrality(Graph<L,E> g, L v)
    {
        double sum = 0;
        
        for(E e : g.edges())
        {
            if(((Edge)e).vertices.contains(v)&&((Edge)e).type()!="HyperEdge")
                sum += 1;
        }
        return sum;   
    }
    
    public static <L, E> double degreeCentrality(Graph<L,E> g)
    {
        double sum = 0;
        
        for(L vertex : g.vertices())
        {
            for(E e : g.edges())
            {
                if(((Edge)e).vertices.contains(vertex)&&((Edge)e).type()!="HyperEdge")
                    sum += 1;
            }
        }
        return sum;   
    }
    
    public static <L,E> double closenessCentrality(Graph<L,E> g, L v) 
    {
        double sum = 0;
        for(L l:g.vertices())
        {
            sum += distance(g, l, v);
        }
        return 1/sum;
    }
    
    public static <L, E> double betweennessCentrality(Graph<L, E> g, L v) {
        boolean directflag = false;
        for (E key : g.edges()) {
            if (key instanceof DirectedEdge) {
                directflag = true;
                break;
            } else if (key instanceof UndirectedEdge) {
                directflag = false;
            }
        }
        Map<L, Map<L, Map<L, Integer>>> map = new HashMap<>();
        int V = g.vertices().size();
        for (L vertex : g.vertices()) {
            Map<L, Map<L, Integer>> Dij = new HashMap<>();
            map.put(vertex, Dij);
            Map<L, Integer> vertexmap = new HashMap<>();
            vertexmap.put(vertex, 1);
            Dij.put(vertex, vertexmap);
            Map<L, Double> DisMap = new HashMap<>();
            Map<L, Boolean> FlagMap = new HashMap<>();
            for (L key : g.vertices()) {
                DisMap.put(key, Double.MAX_VALUE);
                FlagMap.put(key, false);
            }
            DisMap.put(vertex, 0.0);

            for (int count = 0; count < V - 1; count++) {
                double min = Double.MAX_VALUE, minnum = Double.MAX_VALUE;
                L temp = null;
                minnum = Double.MAX_VALUE;
                for (L key : g.targets(vertex).keySet()) {
                    if (FlagMap.get(key) == false) {
                        for (Double key2 : g.targets(vertex).get(key)) {
                            if(key2<0.1)
                                minnum=1;
                            else if (key2 < minnum)
                                minnum = key2;
                        }
                        if (minnum < min) {
                            min = minnum;
                            temp = key;
                        }
                    }
                }
                for (L key : DisMap.keySet()) {
                    if (FlagMap.get(key) == false) {
                        if (DisMap.get(key) < minnum)
                            minnum = DisMap.get(key);
                        if (minnum < min) {
                            min = minnum;
                            temp = key;
                        }
                    }
                }
                if (!FlagMap.get(vertex)) {
                    temp = vertex;
                    min = 0;
                }
                if (temp != null) {
                    for (L key : g.targets(temp).keySet()) {
                        {
                            double miny = Double.MAX_VALUE;
                            for (Double key2 : g.targets(temp).get(key)) {
                                if(key2<0.1)
                                    miny=1;
                                else if (miny > key2)
                                    miny = key2;
                            }
                            if (!FlagMap.get(key) && min + miny <= DisMap.get(key)+0.05&&min + miny >= DisMap.get(key)-0.05 && min + miny >= 0.1) {
                                for (L keyver : Dij.get(temp).keySet()) {
                                    if (Dij.get(key).containsKey(keyver)) {
                                        Integer inta = Dij.get(key).get(keyver) + 1;
                                        Dij.get(key).remove(keyver);
                                        Dij.get(key).put(keyver, inta);
                                    } else
                                        Dij.get(key).put(keyver, 1);
                                }
                                if (Dij.get(key).containsKey(key)) {
                                    Integer inta = Dij.get(key).get(key) + 1;
                                    Dij.get(key).remove(key);
                                    Dij.get(key).put(key, inta);
                                } else
                                    Dij.get(key).put(key, 1);

                            } else if (!FlagMap.get(key) && min + miny < DisMap.get(key) && min + miny >= 0) {
                                    DisMap.put(key, min + miny);
                                    Dij.remove(key);
                                    Map<L, Integer> vermap = new HashMap<>();
                                    if(Dij.get(temp)==null)
                                        System.out.println(temp.toString()+key.toString());
                                    for (L keyver : Dij.get(temp).keySet()) {
                                        vermap.put(keyver, Dij.get(temp).get(keyver));
                                    }
                                    vermap.put(key, 1);
                                    Dij.put(key, vermap);
                                }
                        }
                    }
                    FlagMap.put(temp, true);
                }
            }
        }
        double sum = 0;
        double Betweenness = 0;
        double Betwee = 0;
        for (L vertex1 : g.vertices()) {
            for (L vertex2 : map.get(vertex1).keySet()) {
                double max = Double.MIN_VALUE;
                for (L vertex3 : map.get(vertex1).get(vertex2).keySet()) {
                    if (max < map.get(vertex1).get(vertex2).get(vertex3) && map.get(vertex1).get(vertex2).size() > 2)
                        max = map.get(vertex1).get(vertex2).get(vertex3);
                }
                Betwee = max;
                if (map.get(vertex1).get(vertex2).keySet().contains(v) && vertex1 != v && vertex2 != v)
                    Betweenness = map.get(vertex1).get(vertex2).get(v);
                else if (!map.get(vertex1).get(vertex2).keySet().contains(v) || vertex1 == v || vertex2 == v)
                    Betweenness = 0;
                if (max != Double.MAX_VALUE)
                    sum += Betweenness / Betwee;
            }
        }
        if (directflag)
            return Math.round(sum / (V - 1) / (V - 2) * 100) * 0.01;
        else
            return Math.round(sum / (V - 1) / (V - 2) * 2 * 100) * 0.01;
    }

    
    public static <L, E> double inDegreeCentrality(Graph<L, E> g, L v) {
        double sum = 0;
        for (E e : g.edges()) {
            if (((Edge) e).vertices.get(1).equals(v) && ((Edge) e).type() != "HyperEdge")
                sum += 1;
        }
        return sum;
    }
    
    public static <L,E> double outDegreeCentrality(Graph<L,E> g, L v)
    {
        double sum = 0;
        for (E e : g.edges()) {
            if (((Edge) e).vertices.get(0).equals(v) && ((Edge) e).type() != "HyperEdge")
                sum += 1;
        }
        return sum;
    }
    
    public static <L , E> double distance(Graph<L,E> g,L v1, L v2)
    {
        int size = g.vertices().size();
        double[][] dist = new double[size][size];
        Map<String, Integer> map = new HashMap<>();
        int flag = 0;
        for(L l:g.vertices())
        {
            map.put(((Vertex)l).getLabel(), flag);
            flag++;
        }
        int[][] edge = new int[size][size];
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)
            {
                edge[i][j] = i;
                if(i==j)
                {
                    dist[i][j]=0;
                }else {
                    dist[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        
        for(E e:g.edges())
        {
            String a1 = ((Edge)e).vertices.get(0).getLabel();
            String a2 = ((Edge)e).vertices.get(1).getLabel();
            int b1 = map.get(a1);
            int b2 = map.get(a2);
            double w = ((Edge)e).weight;
            if(w < dist[b1][b2]){
                dist[b1][b2] = w;
                dist[b2][b1] = w;
            }
        }
        
        for (int k = 0; k < size; k++) {
            for (int v = 0; v < size; v++) {
                for (int w = 0; w < size; w++) {
                    if (dist[v][k] + dist[k][w] < dist[v][w]) {
                        dist[v][w] = dist[v][k] + dist[k][w];
                        edge[v][w] = edge[k][w];
                    }
                }
            }
        }
        
        int b1 = map.get(((Vertex)v1).getLabel());
        int b2 = map.get(((Vertex)v2).getLabel());
        return dist[b1][b2];
    }


    public static <L, E> double eccentricity(Graph<L, E> g, L v) {
        int V = g.vertices().size();
        Map<L, Double> DisMap = new HashMap<>();
        Map<L, Boolean> FlagMap = new HashMap<>();
        for (L key : g.vertices()) {
            DisMap.put(key, Double.MAX_VALUE);
            FlagMap.put(key, false);
        }
        DisMap.put(v, 0.0);

        for (int count = 0; count < V - 1; count++) {
            double min = Double.MAX_VALUE, minnum = Double.MAX_VALUE;
            L temp = null;
            minnum = Double.MAX_VALUE;
            for (L key : g.targets(v).keySet()) {
                if (FlagMap.get(key) == false) {
                    for (Double key2 : g.targets(v).get(key)) {
                        if(key2<0.1)
                            minnum=1;
                        else if (key2 < minnum)
                            minnum = key2;
                    }
                    if (minnum < min) {
                        min = minnum;
                        temp = key;
                    }
                }
            }
            for (L key : DisMap.keySet()) {
                if (FlagMap.get(key) == false) {
                    if (DisMap.get(key) < minnum)
                        minnum = DisMap.get(key);
                    if (minnum < min) {
                        min = minnum;
                        temp = key;
                    }
                }
            }
            if (!FlagMap.get(v)) {
                temp = v;
                min = 0;
            }
            if (temp != null) {
                for (L key : g.targets(temp).keySet()) {
                    {
                        double miny = Double.MAX_VALUE;
                        for (Double key2 : g.targets(temp).get(key)) {
                            if(key2<0.1)
                                miny=1;
                            else if (miny > key2)
                                miny = key2;
                        }
                        if (!FlagMap.get(key) && min + miny < DisMap.get(key) && min + miny > 0) {
                            DisMap.put(key, min + miny);
                        }
                    }
                }
                FlagMap.put(temp, true);
            }
        }
        double eccentricity = Double.MIN_VALUE;
        for (L key : DisMap.keySet()) {
            if (DisMap.get(key) > eccentricity)
                eccentricity = DisMap.get(key);
        }
        return eccentricity;
    }

    public static <L, E> double radius(Graph<L, E> g) {
        double radius = Double.MAX_VALUE;
        for (L vertex : g.vertices()) {
            double eccentricity = eccentricity(g, vertex);
            if (radius > eccentricity)
                radius = eccentricity;
        }
        return radius;
    }

    public static <L, E> double diameter(Graph<L, E> g) {
        double diameter = Double.MIN_VALUE;
        for (L vertex : g.vertices()) {
            double eccentricity = eccentricity(g, vertex);
            if (diameter < eccentricity)
                diameter = eccentricity;
        }
        return diameter;
    }
}


