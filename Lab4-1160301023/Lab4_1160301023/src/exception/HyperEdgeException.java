package exception;

public class HyperEdgeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public HyperEdgeException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The HyperEdge is not up to specification";
    }

}
