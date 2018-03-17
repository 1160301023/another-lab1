package P4.twitter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;




public class MySocialNetwork {
    @SuppressWarnings("null")
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        //throw new RuntimeException("not implemented");
        int length = tweets.size();
        Tweet tweet = null;
        Map<String, Set<String>> map = new HashMap<>();
        for(int i=0;i<length;i++)
        {
            tweet = (Tweet)tweets.get(i);
            String[] str = tweet.getText().split(" ");
            char[] token;
            for(int j=0;j<str.length;j++)
            {
                token = str[j].toCharArray();
                if(token[0]=='#')
                {
                    StringBuilder b = new StringBuilder();
                    int a = 0;
                    for(int k=0;k<token.length-1;k++){
                        if((token[k+1]<='Z'&&token[k+1]>='A')||(token[k+1]<='z'&&token[k+1]>='a')||(token[k+1]>='0'&&token[k+1]<='9'))
                            {b.insert(a, token[k+1]);a++;}
                        else
                            a++;
                    }
                    if(map.containsKey(b.toString().toLowerCase()))
                    {
                        map.get(b.toString().toLowerCase()).add(tweet.getAuthor().toLowerCase());
                    }else {
                        Set<String> set = new HashSet<>();
                        set.add(tweet.getAuthor().toLowerCase());
                        map.put(b.toString().toLowerCase(), set);
                    }
                }
            }
        }
        return map;
    }

    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
        //throw new RuntimeException("not implemented");
        List<String> list = new ArrayList<String>();
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        for(Map.Entry<String, Set<String>> entry : followsGraph.entrySet())
        {
            Object[] object = entry.getValue().toArray();
            for(int i=0;i<object.length;i++)
            {
                if(map.containsKey(object[i].toString().toLowerCase()))
                {
                    for(int j=0;j!=i&&j<object.length;j++)
                        map.get(object[i].toString().toLowerCase()).add(object[j].toString().toLowerCase());
                }else {
                    Set<String> set = new HashSet<>();
                    for(int j=0;j!=i&&j<object.length;j++)
                        set.add(object[j].toString());
                    map.put(object[i].toString().toLowerCase(), set);
                }
            }
        }
        
        int max = -1;
        for(Map.Entry<String, Set<String>> entry : map.entrySet())
        {
            if(entry.getValue().size()>max)
                max = entry.getValue().size();
        }
        
        for(int i=max;i>=0;i--)
        {
            for(Map.Entry<String, Set<String>> entry : map.entrySet())
            {
                if(entry.getValue().size()==i)
                    list.add(entry.getKey());
            }
        }
        return list;
    }
}
