package exception;

public class HyperEdgeNotExistException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public HyperEdgeNotExistException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The HyperEdge does not exist";
    }

}
