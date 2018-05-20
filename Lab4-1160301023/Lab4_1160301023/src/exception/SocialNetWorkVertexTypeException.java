package exception;

public class SocialNetWorkVertexTypeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkVertexTypeException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The vertex type is not <Person>";
    }

}
