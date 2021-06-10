package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "class_id", nullable = false)
    private Long classId;

    @Column(name = "class_name", nullable = false)
    private String className;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentClass")
    List<Student> listClassStudents = new ArrayList<>();


    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getListClassStudents() {
        return listClassStudents;
    }

    public void setListClassStudents(List<Student> listClassStudents) {
        this.listClassStudents = listClassStudents;
    }


}
