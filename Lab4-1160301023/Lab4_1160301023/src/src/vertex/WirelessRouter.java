package src.vertex;

public class WirelessRouter extends Vertex{
	private String IP;
	public WirelessRouter(String label) {
		super(label);
	}
	
	@Override
	public void fillVertexInfo(String[] args) {
		IP  = args[0];
	}
	@Override
	public String type() {
		return "WirelessRouter";
	}

	@Override
	public String toString() {
		String s = "VertexType(" + this.type() + ")"+" "+this.getLabel() + "<" + IP +">";
		return s;
	}

}
