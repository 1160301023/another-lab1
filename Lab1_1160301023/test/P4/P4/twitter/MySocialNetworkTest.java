package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MySocialNetworkTest {

    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.parse("2016-02-17T11:56:00Z");
    private static final Instant d4 = Instant.parse("2016-02-17T12:03:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", ".@JudicialWatch lawsuit uncovered ANOTHER Russia Dossier used to #mit undermine @RealDonaldTrump--this one created by Obama State\u2026", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 #mit minutes #hype @anhongzhan", d2);
    private static final Tweet tweet3 = new Tweet(3, "TotalBroadcast", "Who started the #mit rumor that #Obama was from #Kenya?", d3);
    private static final Tweet tweet4 = new Tweet(4, "cy_yenke", "Let's keep in mind #mit Obama had #anhOngzhan scandals #Kenya early on in his administration", d4);

    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    @Test
    public void test() {
        //fail("Not yet implemented");
        Map<String, Set<String>> followsGraph = MySocialNetwork.guessFollowsGraph(Arrays.asList(tweet1,tweet2,tweet3,tweet4));
        assertEquals(5, followsGraph.size());
        Set<String> set = new HashSet<>();
        set.add("alyssa".toLowerCase());
        set.add("bbitdiddle".toLowerCase());
        set.add("TotalBroadcast".toLowerCase());
        set.add("cy_yenke");
        assertEquals(set, followsGraph.get("mit"));
        set = new HashSet<>();
        set.add("bbitdiddle".toLowerCase());
        assertEquals(set, followsGraph.get("hype"));
        
        List<String> list = MySocialNetwork.influencers(followsGraph);
        assertEquals(4,list.size());
        List<String> list2 = new ArrayList<>();
        list2.add("totalbroadcast");
        list2.add("cy_yenke");
        list2.add("alyssa");
        list2.add("bbitdiddle");
        assertEquals(list2, list);
    }

}
