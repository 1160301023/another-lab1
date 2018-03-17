/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SocialNetworkTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.parse("2016-02-17T11:56:00Z");
    private static final Instant d4 = Instant.parse("2016-02-17T12:03:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", ".@JudicialWatch lawsuit uncovered ANOTHER Russia Dossier used to undermine @RealDonaldTrump--this one created by Obama State\u2026", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype @anhongzhan", d2);
    private static final Tweet tweet3 = new Tweet(3, "TotalBroadcast", "Who started the rumor that #Obama was from #Kenya?", d3);
    private static final Tweet tweet4 = new Tweet(4, "cy_yenke", "Let's keep in mind Obama had scandals early on in his administration", d4);
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        //Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2,tweet3,tweet4));
        assertTrue("expected empty graph", !followsGraph.isEmpty());
        assertEquals(4,followsGraph.size());
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> set = new HashSet<>();
        set.add("JudicialWatch".toLowerCase());
        set.add("RealDonaldTrump--this".toLowerCase());
        map.put("alyssa".toLowerCase(), set);
        set = new HashSet<>();
        map.put("TotalBroadcast",set);
        set = new HashSet<>();
        set.add("anhongzhan".toLowerCase());
        map.put("bbitdiddle".toLowerCase(),set);
        set = new HashSet<>();
        map.put("cy_yenke", set);
        assertEquals(map,followsGraph);
    }
    
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertTrue("expected empty list", influencers.isEmpty());
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
