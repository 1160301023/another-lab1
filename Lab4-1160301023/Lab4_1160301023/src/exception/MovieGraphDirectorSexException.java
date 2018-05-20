package exception;

public class MovieGraphDirectorSexException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphDirectorSexException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String message() {
        return "The Director sex is wrong";
    }
}
