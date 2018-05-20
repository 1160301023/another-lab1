package exception;

public class SocialNetWorkEdgeStratEndException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkEdgeStratEndException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Socialedge has no start or end";
    }

}
