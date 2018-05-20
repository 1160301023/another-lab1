package exception;

public class MoviGraphEdgeLabelException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MoviGraphEdgeLabelException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Edge label is wrong";
    }

}
