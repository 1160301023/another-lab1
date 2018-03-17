package P3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FriendshipGraphTest {

    
    @Test
    public void getDistanceTest() {
       // fail("Not yet implemented");
        Person P1 = new Person("1");
        Person P2 = new Person("2");
        Person P3 = new Person("3");
        Person P4 = new Person("4");
        Person P5 = new Person("5");
        Person P6 = new Person("6");
        Person P7 = new Person("7");
        
        FriendshipGraph.addVertex(P1);
        FriendshipGraph.addVertex(P2);
        FriendshipGraph.addVertex(P3);
        FriendshipGraph.addVertex(P4);
        FriendshipGraph.addVertex(P5);
        FriendshipGraph.addVertex(P6);
        FriendshipGraph.addVertex(P7);

        FriendshipGraph.addEdge(P1,P2);
        FriendshipGraph.addEdge(P2,P1);
        FriendshipGraph.addEdge(P1,P3);
        FriendshipGraph.addEdge(P3,P1);
        FriendshipGraph.addEdge(P2,P4);
        FriendshipGraph.addEdge(P4,P2);
        FriendshipGraph.addEdge(P3,P4);
        FriendshipGraph.addEdge(P4,P3);
        FriendshipGraph.addEdge(P3,P5);
        FriendshipGraph.addEdge(P5,P3);
        FriendshipGraph.addEdge(P5,P6);
        FriendshipGraph.addEdge(P6,P5);

        assertEquals(2, FriendshipGraph.getDistance(P1,P4));
        assertEquals(3, FriendshipGraph.getDistance(P1,P6));
        assertEquals(-1, FriendshipGraph.getDistance(P2,P7));
    }
    
    @Test
    public void addVertexTest()
    {
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(rachel);
        al.add(ross);
        al.add(ben);
        al.add(kramer);

        for(int i=0;i<FriendshipGraph.ap.size();i++)
            assertEquals(((Person)al.get(i)).name, ((Person)FriendshipGraph.ap.get(i)).name);
    }
    
    @Test
    public void addEdgeTest()
    {
        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");
        
        rachel.l.add(ross);
        ross.l.add(rachel);
        ross.l.add(ben);
        ben.l.add(ross);
        
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(rachel);
        al.add(ross);
        al.add(ben);
        al.add(kramer);

        for(int i=0;i<FriendshipGraph.ap.size();i++)
        {
            assertEquals(((Person)al.get(i)).l,(FriendshipGraph.ap.get(i)).l);
        }
    }

}
