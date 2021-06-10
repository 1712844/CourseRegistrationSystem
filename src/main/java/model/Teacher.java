package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Teacher")
public class Teacher extends User{


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseTeacher")
    private List<Course> listTeacherCourses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department teacherDepartment;

    public List<Course> getListTeacherCourses() {
        return listTeacherCourses;
    }

    public void setListTeacherCourses(List<Course> listTeacherCourses) {
        this.listTeacherCourses = listTeacherCourses;
    }
    public Teacher(String userFirstName, String userLastName, String email, String role) {
        super(userFirstName, userLastName, email, role);
    }
}
