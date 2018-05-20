package src.vertex;

public class Director extends Vertex{
    
    public Director(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }
    int age;
    String sex;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.age = Integer.valueOf(args[0]);
        this.sex = args[1];
    }

    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "Director";
    }
}
