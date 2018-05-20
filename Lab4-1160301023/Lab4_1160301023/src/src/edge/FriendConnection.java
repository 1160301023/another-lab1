package src.edge;

import java.util.regex.Pattern;

public class FriendConnection extends DirectedEdge{

    public FriendConnection(String label, double weight) {
        super(label, weight);
        this.checkrep();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "FriendConnection";
    }
    
    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }
}
