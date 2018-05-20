package src.edge;

import java.util.regex.Pattern;

public class SameMovieHyperEdge extends HyperEdge{

    public SameMovieHyperEdge(String label, double weight) {
        super(label, -1);
        this.checkrep();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "SameMovieHyperEdge";
    }
    
    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }
}
