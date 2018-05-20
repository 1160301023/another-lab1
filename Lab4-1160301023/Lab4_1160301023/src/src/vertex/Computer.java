package src.vertex;

public class Computer extends Vertex{

    public Computer(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }


    private String IP = null;
    
    public String getIp() {
        return IP;
    }

    public void setIp(String ip) {
        this.IP = ip;
    }

    
    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.IP = args[0];
    }

}
