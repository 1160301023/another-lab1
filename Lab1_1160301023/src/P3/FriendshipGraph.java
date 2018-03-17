package P3;

import java.util.List;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class FriendshipGraph {
    static ArrayList<Person> ap = new ArrayList<Person>();
    
    public static void main(String[] args){
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        
        FriendshipGraph.addVertex(rachel);
        FriendshipGraph.addVertex(ross);
        FriendshipGraph.addVertex(ben);
        FriendshipGraph.addVertex(kramer);

        FriendshipGraph.addEdge(rachel,ross);
        FriendshipGraph.addEdge(ross,rachel);
        FriendshipGraph.addEdge(ross,ben);
        FriendshipGraph.addEdge(ben,ross);

        System.out.println(FriendshipGraph.getDistance(rachel,ross));
        System.out.println(FriendshipGraph.getDistance(ross,kramer));
        System.out.println(FriendshipGraph.getDistance(rachel,ben));
    }
    
    public static void addEdge(Person p1,Person p2)
    {
        p1.l.add(p2);
    }
    
    //@SuppressWarnings("unused")
    public static int getDistance(Person p1,Person p2)
    {
        p2.isVisited = false;
        int length = p1.l.size();
        Person p = null;
        int location = 0;
        boolean isFinded = false;
        int flag = 1;
        List<Person> list = new ArrayList<>();
        List<Person> list1 = new ArrayList<>();
        for(int i=0;i<length;i++){
            list.add((Person)p1.l.get(i));
        }
        while(list.size()!=0){
            p = (Person)list.get(location);
            p.isVisited = true;
            if(p.equals(p2)||p==p2){
                isFinded = true;
            }
            else{
                for(int i=0;i < p.l.size();i++){
                   if(((Person)p.l.get(i)).isVisited==false){
                       list1.add((Person)p.l.get(i));
                   }
                }
            }
            if(isFinded)
                return flag;
            location++;
            if(location==list.size()){
                list = new ArrayList<>();
                for(int i=0;i<list1.size();i++)
                    list.add((Person)list1.get(i));
                flag++;
                list1 = new ArrayList<>();
                location = 0;
            }
        }
        return -1;
    }
    
    public static void addVertex(Person p)
    {
        ap.add(p);
        for(int i=0;i<ap.size()-1;i++)
            if(p.name==ap.get(i).name)
            {
                throw new RuntimeException("error:Each person has a unique name");
            }
    }
        
    
    public FriendshipGraph()
    {
        
    }
}
