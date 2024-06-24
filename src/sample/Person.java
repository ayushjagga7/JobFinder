package sample;
public class Person {
    private int u_id = 0;
    private String firstName = null;
    private String lastName = null;
    private String degree = null;
    private double cgpa = 0.0;
    private String college = new String();

    public Person() {
    }
    public Person(int u_id, String firstName, String lastName, String degree, double cgpa, String college) {
        this.u_id = u_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.cgpa = cgpa;
        this.college = college;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getU_id() {
        return u_id;
    }
    public String getDegree() {
        return degree;
    }
    public double getCgpa() {
        return cgpa;
    }
    public String getCollege() {
        return college;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    public void setCollege(String college) {
        this.college = college;
    }
}