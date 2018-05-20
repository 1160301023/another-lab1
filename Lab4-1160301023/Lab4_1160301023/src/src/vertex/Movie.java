package src.vertex;

public class Movie extends Vertex{

    public Movie(String label) {
        super(label);
        // TODO Auto-generated constructor stub
    }
    int year;
    String country;
    double grade;
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public void fillVertexInfo(String[] args) {
        // TODO Auto-generated method stub
        this.year = Integer.valueOf(args[0]);
        this.country = args[1];
        this.grade = Double.valueOf(args[2]);
    }
    
    @Override
    public String type() {
        // TODO Auto-generated method stub
        return "Movie";
    }

}
