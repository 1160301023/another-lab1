package exception;

public class NetworkTopologyStartEndException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public NetworkTopologyStartEndException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "The NetworkTopology has no start or end";
    }

}
