package exception;


public class GraphPoetStartEndException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public GraphPoetStartEndException(String msg) {
        // TODO Auto-generated constructor stub
        super(msg);
    }
    
    public String message(){
        return "The edge has no start or end";
    }
}
