package src.edge;

import java.util.regex.Pattern;

public class ForwardConnection extends DirectedEdge{

    public ForwardConnection(String label, double weight) {
        super(label, weight);
        this.checkrep();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "ForwardConnection";
    }
    
    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }
}