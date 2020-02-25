package sample;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String ID;
    private String name;
    private double GPA;
    private Set<Student> student_set;


    public Student(String ID, String name, double GPA) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
        student_set = new HashSet<>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public void addCurrentStudent(Student a){
        student_set.add(a);
    }
    public void removeStudent(String ID){

        for (Student s: student_set
             ) {
            if(ID.equalsIgnoreCase(s.getID())){
                student_set.remove(s);
            }

        }

    }
    public Student findStudent(String ID){
        Student a = null;
        for (Student s: student_set
             ) {
            if(ID.equalsIgnoreCase(s.getID())){
                a = s;
            }
        }
        return a;
    }
    public Student editStudent(String ID,double GPA){
        Student s = null;

        if(findStudent(ID)==null){
            System.out.println("sample.Student does not exist");
        }
        else{
            s = findStudent(ID);
        }
        s.setGPA(GPA);
        return s;
    }
    public String display(){
        String a = "";
        for (Student s:
                student_set
             ) {
            a += s.toString() + " ";

        }
        return a;
    }

    @Override
    public String toString() {
        return "The ID of the student is " + ID + " and his/her name " + name + " his current GPA " + GPA;
    }
}
