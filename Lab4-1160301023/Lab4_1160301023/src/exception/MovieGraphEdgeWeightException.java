package exception;

public class MovieGraphEdgeWeightException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MovieGraphEdgeWeightException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Edge Weight is Wrong";
    }
}
