/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
        //throw new RuntimeException("not implemented");
        int time = tweets.size();
        long[] arr = new long[time];
        for(int i=0;i<time;i++){
            arr[i] =  ((Tweet)tweets.get(i)).getTimestamp().getEpochSecond();      
        }
        
        int a=0,b=0;
        int length = arr.length;
        long max = -1;
        for(int i=0;i<length;i++)
        {
            for(int j=i+1;j<length;j++)
            {
                if(Math.abs(arr[i]-arr[j])>max)
                {
                    max = Math.abs(arr[i]-arr[j]);
                    if(arr[i]-arr[j]>0)
                    {
                        a = j;b = i;
                    }else {
                        a = i;b = j;
                    }
                }
            }
        }
        
        Timespan timespan = new Timespan(tweets.get(a).getTimestamp(),tweets.get(b).getTimestamp());
        return timespan;
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        //throw new RuntimeException("not implemented");
        StringBuilder sBuilder = new StringBuilder();
        Set<String> set = new HashSet<String>();
        int length = tweets.size();
        for(int i=0;i<length;i++)
        {
            String[] token = (((Tweet)tweets.get(i)).getText()).split(" ");
            for(int j=0;j<token.length;j++)
            {
                char[] arr = token[j].toCharArray();
                for(int k=0;k<arr.length;k++)
                {
                    if(arr[k]!='@')
                    {
                        if((arr[k]<='Z'&&arr[k]>='A')||(arr[k]<='z'&&arr[k]>='a')||(arr[k]=='-')||(arr[k]=='_')||(arr[k]>='0'&&arr[k]<='9'))
                            break;
                    }else{
                        int a = k+1;
                        int index = 0;
                        while (a<arr.length&&((arr[a]<='Z'&&arr[a]>='A')||(arr[a]<='z'&&arr[a]>='a')||(arr[a]=='-')||(arr[a]=='_')||(arr[a]>='0'&&arr[a]<='9'))) {
                                sBuilder.insert(index, Character.toLowerCase(arr[a]));
                            a++;index++;
                        }
                        set.add(sBuilder.toString());
                        sBuilder = new StringBuilder();
                        break;
                    }
                }
            }
        }
        
        return set;
    }

}
