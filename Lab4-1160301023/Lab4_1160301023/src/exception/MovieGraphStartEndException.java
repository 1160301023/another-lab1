package exception;

public class MovieGraphStartEndException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public MovieGraphStartEndException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String message() {
        return "The MovieDirectorRelation or MovieActorRelation has no start or end";
    }
}
