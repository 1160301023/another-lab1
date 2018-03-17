/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter consists of methods that filter a list of tweets for those matching a
 * condition.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Filter {

    /**
     * Find tweets written by a particular user.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param username
     *            Twitter username, required to be a valid Twitter username as
     *            defined by Tweet.getAuthor()'s spec.
     * @return all and only the tweets in the list whose author is username,
     *         in the same order as in the input list.
     */
    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
        //throw new RuntimeException("not implemented");
        List<Tweet> list = new ArrayList<Tweet>();
        for(int i=0;i<tweets.size();i++)
        {
            if(((Tweet)tweets.get(i)).getAuthor().equalsIgnoreCase(username))
            {
                list.add((Tweet)tweets.get(i));
            }
        }
        return list;
    }

    /**
     * Find tweets that were sent during a particular timespan.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param timespan
     *            timespan
     * @return all and only the tweets in the list that were sent during the timespan,
     *         in the same order as in the input list.
     */
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
        //throw new RuntimeException("not implemented");
        List<Tweet> list = new ArrayList<Tweet>();
        for(int i=0;i<tweets.size();i++)
        {
            if(((Tweet)tweets.get(i)).getTimestamp().getEpochSecond()>=timespan.getStart().getEpochSecond()&&
                    ((Tweet)tweets.get(i)).getTimestamp().getEpochSecond()<=timespan.getEnd().getEpochSecond())
            {
                list.add((Tweet)tweets.get(i));
            }
        }
        return list;
    }

    /**
     * Find tweets that contain certain words.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param words
     *            a list of words to search for in the tweets. 
     *            A word is a nonempty sequence of nonspace characters.
     * @return all and only the tweets in the list such that the tweet text (when 
     *         represented as a sequence of nonempty words bounded by space characters 
     *         and the ends of the string) includes *at least one* of the words 
     *         found in the words list. Word comparison is not case-sensitive,
     *         so "Obama" is the same as "obama".  The returned tweets are in the
     *         same order as in the input list.
     */
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
        //throw new RuntimeException("not implemented");
        List<Tweet> list = new ArrayList<Tweet>();
        int tlength = tweets.size();
        int wlength = words.size();
        int flag = 1;
        boolean[] isExist = new boolean[wlength];
        for(int i=0;i<tlength;i++)
        {
            for(int z=0;z<wlength;z++)
                isExist[z] = false;
            String[] token = ((Tweet)tweets.get(i)).getText().split(" ");
            for(int j=0;j<wlength;j++)
            {
                for(int k=0;k<token.length;k++)
                {
                    if(token[k].equalsIgnoreCase((String)words.get(j)))
                    {
                        isExist[j] = true;
                    }
                }
            }
            
            for(int j=0;j<wlength;j++)
            {
                if(isExist[j]==false)
                    flag = 0;
            }
            
            if(flag==1)
                list.add((Tweet)tweets.get(i));
            flag = 1;
        }
        
        return list;
    }


}
