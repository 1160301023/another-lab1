package src.graph;

import src.edge.Edge;
import src.vertex.*;

public class SocialNetwork<L extends Vertex,E extends Edge> extends ConcreteGraph<L, E>{

   public SocialNetwork() {
    // TODO Auto-generated constructor stub
       checkRep();
   }
   @Override
   public boolean addEdge(E edge) {
    // TODO Auto-generated method stub
       if(edge.vertices.size()!=2)
           return false;
       boolean flag = true;
       for(E e : super.edges){
           if(e.vertices.get(0).getLabel().equals(edge.vertices.get(0).getLabel())&&
                   e.vertices.get(1).getLabel().equals(edge.vertices.get(1).getLabel())&&
                   e.weight!=edge.weight)
           {
               flag = false;
               super.edges.remove(e);
               this.changeweight(e.weight, edge.weight);
           }
       }
       
       if(flag){
           addweight(edge.weight);
       }
       
       super.edges.add(edge);
       
       return true;
   }
   
   @Override
    public boolean removeEdge(E edge) {
        // TODO Auto-generated method stub
        if(super.edges.contains(edge))
        {
            super.edges.remove(edge);
            deleteweight(edge.weight);
            return true;
        }
        return false;
    }
   
   public void addweight(double wa) {
       for(E e:super.edges)
       {
           e.weight = e.weight*(1-wa);
       }
   }
   
   public void changeweight(double wa,double wb) {
       for(E e:super.edges)
       {
           e.weight = e.weight*(1-wb)/(1-wa);
       }
   }
   
   public void deleteweight(double wa) {
       for(E e:super.edges)
       {
           e.weight = e.weight/(1-wa);
       }
   }
   
   @Override
   public void checkRep(){
       for(Vertex v:super.vertices()){
           assert v.type().equals("Person");
       }
       for(Edge edge : edges()){
           assert edge.type().equals("FriendTie") || edge.type().equals("CommentTie") || edge.type().equals("ForwardTie");
       }
       double sum = 0.0;
       for(int i =0;i<super.edges.size();i++){
           sum = sum + super.edges.get(i).getWeight();
       }
       assert sum - 1.0<= 0.0000001;
   }
}
