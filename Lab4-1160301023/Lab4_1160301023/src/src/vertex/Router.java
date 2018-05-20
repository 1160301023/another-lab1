package src.vertex;

public class Router extends Vertex{
    public Router(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }

    private String IP = null;

    public String getIP() {
        return IP;
    }

    public void setIP(String iP) {
        IP = iP;
    }

    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.IP = args[0];
    }
    

}
