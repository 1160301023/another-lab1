package exception;

public class SocialNetWorkLabelException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkLabelException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "SocialNetWork label is wrong";
    }

}
