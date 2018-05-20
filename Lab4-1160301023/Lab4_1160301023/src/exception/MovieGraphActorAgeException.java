package exception;

public class MovieGraphActorAgeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphActorAgeException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Actor age is wrong";
    }

}
