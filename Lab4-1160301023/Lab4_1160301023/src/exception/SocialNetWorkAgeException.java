package exception;

public class SocialNetWorkAgeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkAgeException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The Person age is wrong";
    }

}
