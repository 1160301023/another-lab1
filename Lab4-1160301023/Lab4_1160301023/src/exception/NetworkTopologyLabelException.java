package exception;

public class NetworkTopologyLabelException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public NetworkTopologyLabelException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The label of nerwork is wrong";
    }

    
}
