package exception;

public class MovieGraphGradeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphGradeException() {
        // TODO Auto-generated constructor stub
        super();
    }
    
    public String message() {
        return "The Grage is not in the row [0,10]";
    }

}
