package sample;

import javafx.event.ActionEvent;

import java.util.LinkedList;
import java.util.List;

public class Lectures {
    private String day;
    private int start_time;
    private int end_time;
    private int end_day;
    private int start_day;
    private List<Lectures> lecturesList;

    public Lectures(String day, int start_time, int end_time, int end_day, int start_day) {
        this.day = day;
        this.start_time = start_time;
        this.end_time = end_time;
        this.end_day = end_day;
        this.start_day = start_day;
        lecturesList = new LinkedList<>();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getEnd_day() {
        return end_day;
    }

    public void setEnd_day(int end_day) {
        this.end_day = end_day;
    }

    public int getStart_day() {
        return start_day;
    }

    public void setStart_day(int start_day) {
        this.start_day = start_day;
    }
    public void addLecture(String a,int x, int y, int w, int z){
            if(((x<z)&&(x>w))||(y<z)&&(y>w)){
                if(!(a.equalsIgnoreCase("Friday"))||!(a.equalsIgnoreCase("Saturday"))){
                    Lectures lectures = new Lectures(a,x,y,w,z);
                    lecturesList.add(lectures);
                }
                else {
                    System.out.println("Invalid day or time stamp");
                }
        }
    }
    public void removeLecture(String a ,int x,int y,int w, int z){
        Lectures b = new Lectures(a,x,y,w,z);
        for (Lectures l: lecturesList
             ) {
            if(b.equals(l)){
                lecturesList.remove(l);
            }
            else{
                System.out.println("Lecture is not found");
            }
        }
    }
    public void editLecture(String a, int x , int y, int w, int z){
        removeLecture(a,x,y,w,z);
        addLecture(a,x,y,w,z);
    }
    public Lectures findLecture(String a , int x, int y, int w, int z){
        Lectures found = null;
        Lectures b = new Lectures(a,x,y,w,z);
        for (Lectures l: lecturesList
        ){
            if(b.equals(l)){
                found =b;
            }


        }
        return found;
    }


}
