package exception;

public class MovieGraphEdgeStandardException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphEdgeStandardException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The edge's fifth data is not Yes or No";
    }

}
