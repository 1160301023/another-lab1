package exception;

public class MovieGraphDirectorAgeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L; 
    
    public MovieGraphDirectorAgeException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Director age is wrong";
    }

}
