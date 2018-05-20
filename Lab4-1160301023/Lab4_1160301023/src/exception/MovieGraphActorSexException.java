package exception;

public class MovieGraphActorSexException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphActorSexException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Actor Sex is wrong";
    }

}
