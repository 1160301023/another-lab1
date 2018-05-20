package exception;

public class SocialNetWorkNotFoundTypeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public SocialNetWorkNotFoundTypeException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String message() {
        return "Can not find this type of Edge";
    }
}
