package sample;

import java.util.*;

public class Courses {
    private String course_code;
    private String course_name;
    private int no_students;
    private Set<Student> students;
    private Set<Courses> coursesSet;

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    private String Major;
    private List<String> prerequisites;

    public Courses(String course_code, String course_name, int no_students, String Major) {
        this.course_code = course_code;
        this.course_name = course_name;
        this.no_students = no_students;
        this.Major = Major;
        coursesSet = new HashSet<>();
        prerequisites = new LinkedList<>();
        students = new HashSet<>();
    }

    public Set addStudent(Student student, String ID, String name, int GPA){
        student = new Student(ID,name,GPA);
        students.add(student);
        no_students++;
        return students;
    }
    public Student searchStudent(String ID, String name, int GPA){
        Student a = new Student(ID,name,GPA);
        if((students.contains(a))){
            return a;
        }
        else{
            return null;
        }
    }
    public void dropStudent(String ID, String name, int GPA){
        if(students.isEmpty()){
            System.out.println("No students were added to the course");
        }
        Student a = new Student(ID,name,GPA);
        if((students.contains(a))){
            students.remove(a);
        }
        else {
            System.out.println("Student not found in this course");
        }
    }
    public Set MajorCourseDisplay(String major){
        Set output = null;
        for (Courses s: coursesSet
             ) {
            if(major.equalsIgnoreCase(s.getMajor())){
                output.add(s);
            }

        }
        return output;

    }
    public void displayPre(){
        for (String a:
                prerequisites
             ) {
            System.out.println(a);
            
        }
    }
    public Set addCourses(Courses c){
        coursesSet.add(c);
        return coursesSet;
    }


}
