package src.vertex;

public class Word extends Vertex{
    public Word(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }

    String label;
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.label = args[0];
    }
}
