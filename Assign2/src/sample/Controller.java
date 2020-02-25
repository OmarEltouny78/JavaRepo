package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    Student Father = new Student("a","a",0);
    Courses father_course = new Courses("0000","nn",0,"none");
    Lectures father_Lectures = new Lectures("nn",0,9,7,17);


    public void onClickEvent(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }

    public void click(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Student Center");
        Label IDl = new Label("Enter student ID in Text Area below");
        TextField ID_Text_Area = new TextField();
        Label Namel = new Label("Student Name");
        TextField name_TextArea = new TextField();
        Label GPAl = new Label("GPA");
        TextField GPA_TextArea = new TextField();
        Button j = new Button("To confirm the operation press thiIs button");
        Label editLabel = new Label("To edit Student information, enter the ID of the student you want to edit( GPA only!!!) ");
        TextField edit_GPA = new TextField();
        Label GPA_Label = new Label("Enter name here");
        TextField new_GPA = new TextField();
        Label GPA_a = new Label("Enter new GPA here");
        TextField new_a = new TextField();
        Button a = new Button("Press Button when you are done ");
        Button dis = new Button("Display all students ");
        TextArea display = new TextArea();
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(IDl,ID_Text_Area,Namel,name_TextArea,GPAl,GPA_TextArea,j,editLabel,edit_GPA,GPA_Label,new_GPA,GPA_a,new_a,a,dis,display);
        j.setOnAction(e -> isDouble(GPA_TextArea));
        j.setOnAction(e -> wrongGPA(GPA_TextArea));
        j.setOnAction(e -> AddStudent(ID_Text_Area,name_TextArea,GPA_TextArea));
        a.setOnAction(e -> isDouble(new_a));
        a.setOnAction(e -> wrongGPA(new_a));
        a.setOnAction(e ->EditStudent(edit_GPA,new_GPA,new_a));
        dis.setOnAction(e -> display(display));
        stage.setScene(new Scene(layout, 450, 450));
        stage.show();

    }
    public void AddStudent(TextField ID, TextField name, TextField GPA){
        if(isDouble(GPA)&&wrongGPA(GPA)){
            Student a = new Student(ID.getText(),name.getText(),Double.parseDouble(GPA.getText()));
            Father.addCurrentStudent(a);
            ID.setText("Added");
            name.setText("");
            GPA.setText("");
        }

    }
    public void EditStudent(TextField input,TextField name, TextField output){
        if(isDouble(output)&&wrongGPA(output)){
            if(Father.findStudent(input.getText())!=null){
                Father.editStudent(input.getText(),Double.parseDouble(output.getText()));
                input.setText("");
                name.setText("");
                output.setText("");
            }
            else{
                input.setText("Student not found");
            }
        }
    }
    public void display(TextArea a){
        a.setText(Father.display());

    }

    public void onLecture(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Lecture.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Lectures Center");
        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll();
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
    }

    public void onCourse(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Course.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Course Center");
        C

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll();
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
    }
    private boolean isDouble(TextField input){
        try
        { double Gpa = Double.parseDouble(input.getText());
            return true;

        }catch(NumberFormatException e){
            input.setText("reenter the GPA");

        }
        return false;


    }
    private boolean wrongGPA(TextField input){
        boolean GPArf = true;
        if(isDouble(input)){
            double GPA = Double.parseDouble(input.getText());
            if((GPA>4.3)||(GPA<0)){
                GPArf = false;
                input.setText("out of bounds GPA");
            }

        }
        return GPArf;
    }

}
