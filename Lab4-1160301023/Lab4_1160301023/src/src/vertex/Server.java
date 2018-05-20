package src.vertex;

public class Server extends Vertex{

    public Server(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }

    private String IP = null;

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.IP = args[0];
    }
}
