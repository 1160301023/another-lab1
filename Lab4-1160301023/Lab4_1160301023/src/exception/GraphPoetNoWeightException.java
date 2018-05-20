package exception;

public class GraphPoetNoWeightException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public GraphPoetNoWeightException(String msg) {
        // TODO Auto-generated constructor stub
        super(msg);
    }
    
    public String message() {
        return "There is no weight in this edge";
    }
}
