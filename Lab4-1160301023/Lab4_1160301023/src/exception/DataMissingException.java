package exception;

public class DataMissingException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public DataMissingException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The datas are missing";
    }

}
