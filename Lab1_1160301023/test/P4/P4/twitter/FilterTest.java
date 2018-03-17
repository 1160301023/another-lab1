/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilterTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.parse("2016-02-17T12:00:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest so much yijie6@gmail.com?", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "@blair rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "Anhongzhan6", "I talk the homework is amazingly hard and difficult @Blair @bessie ", d3);
    private static final Tweet tweet4 = new Tweet(4, "yijie6", "the homework is amazingly hard, difficult, man-sized, untoward and tough ", d3);
    private static final Tweet tweet5 = new Tweet(5, "Anhongzhan6", "I talk the homework is amazingly hard and difficult @Blair @bessie ", d3);
   
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    @Test
    public void testWrittenByEmptyTweets() {
        List<Tweet> writtenBy = Filter.writtenBy(new ArrayList<Tweet>(), "rachit");
        assertTrue(writtenBy.isEmpty());
    }
    @Test
    public void testWrittenByMultipleTweetsSingleResult1() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1, tweet2), "alyssa");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
    }    
    @Test
    public void testWrittenByMultipleTweetsOneMoreResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet2, tweet3,tweet4,tweet5), "Anhongzhan6");
        
        assertEquals("expected two tweets", 2, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet3));
    }
    @Test
    public void testInTimespanMultipleTweetsNoResult() {
        Instant testStart = Instant.parse("2018-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2018-02-17T12:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(
                Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertTrue("expected empty list", inTimespan.isEmpty());
    }
    @Test
    public void testInTimespanMultipleTweetsOneResults() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T11:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2), new Timespan(testStart, testEnd));
        
        assertEquals("expected 1 tweet within timespan", 2, inTimespan.size());
        assertTrue("expected correct tweet within timespan", inTimespan.contains(tweet1));
        assertTrue("expected correct tweet within timespan", inTimespan.contains(tweet2));
    }
    @Test
    public void testInTimespanMultipleTweetsMultipleResults() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T13:00:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1, tweet2,tweet3), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet1, tweet2,tweet3)));
        assertEquals("expected same order", 0, inTimespan.indexOf(tweet1));
        assertEquals("expected same order", 1, inTimespan.indexOf(tweet2));
    }
    @Test
    public void testContainingNoResult() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1), Arrays.asList(""));
        
        assertTrue("Expected no tweet with the word", containing.isEmpty());
    }
    @Test
    public void testContainingOneResults() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet3, tweet1), Arrays.asList("Hard"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain one tweet", containing.containsAll(Arrays.asList(tweet3)));
        assertEquals("expected same order", 0, containing.indexOf(tweet3));
    }
    @Test
    public void testContainingMultipleResults() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1, tweet2,tweet3), Arrays.asList("talk"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1, tweet2,tweet3)));
        assertEquals("expected same order", 0, containing.indexOf(tweet1));
        assertEquals("expected same order", 2, containing.indexOf(tweet3));
    }

    /*
     * Warning: all the tests you write here must be runnable against any Filter
     * class that follows the spec. It will be run against several staff
     * implementations of Filter, which will be done by overwriting
     * (temporarily) your version of Filter with the staff's version.
     * DO NOT strengthen the spec of Filter or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Filter, because that means you're testing a stronger
     * spec than Filter says. If you need such helper methods, define them in a
     * different class. If you only need them in this test class, then keep them
     * in this test class.
     */

}
