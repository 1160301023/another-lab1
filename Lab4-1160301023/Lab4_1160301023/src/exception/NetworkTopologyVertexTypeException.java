package exception;

public class NetworkTopologyVertexTypeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public NetworkTopologyVertexTypeException() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
        return "NetworkTopology has no kind of this type";
    }

}
