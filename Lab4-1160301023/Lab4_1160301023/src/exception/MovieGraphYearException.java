package exception;

public class MovieGraphYearException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphYearException() {
        // TODO Auto-generated constructor stub
        super();
    }
    
    public String message() {
        return "The year is not in the rows";
    }

}
