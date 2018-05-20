package exception;

public class GraphPoetEdgeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public GraphPoetEdgeException(String msg){
        super(msg);
    }
    
    public String message(){
        return "The Edge type gets wrong";
    }
}
