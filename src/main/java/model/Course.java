package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", nullable = false)
    private long courseId;

    @Column(name  = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_credits", nullable = false)
    private Integer courseCredits;

    @Column(name = "course_status", nullable = false)
    private Boolean courseStatus;

    @ManyToOne
    @JoinColumn(name = "crs_id")
    private CourseRegistrationSession courseCRS;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher courseTeacher;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room courseRoom;

    @Column(name = "course_day")
    private String courseDay;

    @ManyToOne
    @JoinColumn(name = "shift_id", nullable = false)
    private Shift courseShift;

    @Column(name = "course_num_of_slots")
    private Integer courseNumOfSlots;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department courseDepartment;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<Student> listCourseStudents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester courseSemester;


    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(Integer courseCredits) {
        this.courseCredits = courseCredits;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public Room getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(Room courseRoom) {
        this.courseRoom = courseRoom;
    }

    public String getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay = courseDay;
    }

    public Shift getCourseShift() {
        return courseShift;
    }

    public void setCourseShift(Shift courseShift) {
        this.courseShift = courseShift;
    }

    public Integer getCourseNumOfSlots() {
        return courseNumOfSlots;
    }

    public void setCourseNumOfSlots(Integer courseNumOfSlots) {
        this.courseNumOfSlots = courseNumOfSlots;
    }

    public Department getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(Department courseDepartment) {
        this.courseDepartment = courseDepartment;
    }

    public List<Student> getListCourseStudents() {
        return listCourseStudents;
    }

    public void setListCourseStudents(List<Student> listCourseStudents) {
        this.listCourseStudents = listCourseStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseCredits=" + courseCredits +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseRoom=" + courseRoom +
                ", courseDay='" + courseDay + '\'' +
                ", courseShift=" + courseShift +
                ", courseNumOfSlots=" + courseNumOfSlots +
                ", courseDepartment=" + courseDepartment +
                ", listCourseStudents=" + listCourseStudents +
                '}';
    }
}
