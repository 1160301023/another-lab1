/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter  ;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ExtractTest {

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
    public void testGetTimespanTwoTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet2,tweet3,tweet4));
        
        assertEquals("expected start", d1, timespan.getStart());
        assertEquals("expected end", d4, timespan.getEnd());
    }
    
    @Test
    public void testGetMentionedUsersNoMention() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet1, tweet2,tweet3,tweet4));
        
        Set<String> set = new HashSet<>();
        set.add("JudicialWatch".toLowerCase());
        set.add(("RealDonaldTrump--this").toLowerCase());
        set.add(("anhongzhan").toLowerCase());
        assertEquals(set,mentionedUsers);
        //assertTrue("expected empty set", mentionedUsers.isEmpty());
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * Extract class that follows the spec. It will be run against several staff
     * implementations of Extract, which will be done by overwriting
     * (temporarily) your version of Extract with the staff's version.
     * DO NOT strengthen the spec of Extract or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Extract, because that means you're testing a
     * stronger spec than Extract says. If you need such helper methods, define
     * them in a different class. If you only need them in this test class, then
     * keep them in this test class.
     */

}
