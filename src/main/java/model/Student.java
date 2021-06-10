package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student extends User {
    @Column(name = "student_year")
    private Integer studentYear;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class studentClass;

    @ManyToMany(mappedBy = "listCourseStudents")
    List<Course> listStudentCourses = new ArrayList<>();

    public Student(String userFirstName, String userLastName, String email, String role, Gender gender, Integer studentYear, Class studentClass) {
        super(userFirstName, userLastName, email, role, gender);
        this.studentYear = studentYear;
        this.studentClass = studentClass;
    }

    public Class getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    public Integer getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(Integer studentYear) {
        this.studentYear = studentYear;
    }

    public List<Course> getListStudentCourses() {
        return listStudentCourses;
    }

    public void setListStudentCourses(List<Course> listStudentCourses) {
        this.listStudentCourses = listStudentCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", studentClass=" + studentClass +
                ", studentYear=" + studentYear +
                ", listStudentCourses=" + listStudentCourses +
                '}';
    }
}
