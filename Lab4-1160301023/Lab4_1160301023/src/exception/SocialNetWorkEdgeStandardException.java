package exception;

public class SocialNetWorkEdgeStandardException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkEdgeStandardException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The fifth data is not Yes or No";
    }

}
