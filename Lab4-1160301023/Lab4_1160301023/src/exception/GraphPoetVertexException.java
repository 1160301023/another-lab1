package exception;

public class GraphPoetVertexException extends Exception{

    /**
     * GraphPoet   Vertex    Exception
     */
    private static final long serialVersionUID = 1L;

    public GraphPoetVertexException() {
        // TODO Auto-generated constructor stub
        super();
    }
    
    public GraphPoetVertexException(String msg) {
        // TODO Auto-generated constructor stub
        super(msg);
    }
    
    public String message(){
        return "Vertex type gets wrong";
    }
}
