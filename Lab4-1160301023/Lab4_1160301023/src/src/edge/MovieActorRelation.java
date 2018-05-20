package src.edge;

import java.util.regex.Pattern;

public class MovieActorRelation extends UndirectedEdge{

    public MovieActorRelation(String label, double weight) {
        super(label, -1);
        this.checkrep();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "MovieActorRelation";
    }
    
    public void checkrep() {
        assert vertices!=null;
        assert Pattern.matches("\\w+", this.type());
    }
}
