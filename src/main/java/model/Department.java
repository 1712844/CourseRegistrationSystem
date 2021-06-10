package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacherDepartment")
    private List<Teacher> listDepartmentTeachers = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseDepartment")
    private List<Course> listDepartmentCourses = new ArrayList<>();
}
