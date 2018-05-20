package exception;

public class SocialNetWorkSexException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkSexException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Person sex is not M or W";
    }

}
