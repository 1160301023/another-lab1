package src.vertex;

public abstract class Vertex {
    private String label;
    private boolean isVisited = false;
    public boolean isVisited() {
        return isVisited;
    }
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    public String type() {
        return null;
    }
    public Vertex(String label){
        this.label = label;
    }
    public abstract void fillVertexInfo (String[] args) ;
    
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    
    public String toString() {
        return null;
    }
    
    public void equals() {
        
    }
    
}
