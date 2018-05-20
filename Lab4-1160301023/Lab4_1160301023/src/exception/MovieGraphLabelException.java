package exception;

public class MovieGraphLabelException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MovieGraphLabelException() {
        // TODO Auto-generated constructor stub
    }
    
    public String message(){
        return "The MovieGraph label is wrong";
    }
}
