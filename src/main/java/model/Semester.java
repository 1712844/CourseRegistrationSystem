package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "Semester")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "semester_id")
    private Long semesterId;

    @Column(name = "semester_year")
    private Long semesterYear;

    @Column(name = "semester_start_date")
    private Date semesterStartDate;

    @Column(name = "semester_end_date")
    private Date semesterEndDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseSemester")
    List<Course> listSemesterCourses = new ArrayList<>();

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public Long getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(Long semesterYear) {
        this.semesterYear = semesterYear;
    }

    public Date getSemesterStartDate() {
        return semesterStartDate;
    }

    public void setSemesterStartDate(Date semesterStartDate) {
        this.semesterStartDate = semesterStartDate;
    }

    public Date getSemesterEndDate() {
        return semesterEndDate;
    }

    public void setSemesterEndDate(Date semesterEndDate) {
        this.semesterEndDate = semesterEndDate;
    }

    public List<Course> getListSemesterCourses() {
        return listSemesterCourses;
    }

    public void setListSemesterCourses(List<Course> listSemesterCourses) {
        this.listSemesterCourses = listSemesterCourses;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterId=" + semesterId +
                ", semesterYear=" + semesterYear +
                ", semesterStartDate=" + semesterStartDate +
                ", semesterEndDate=" + semesterEndDate +
                ", listSemesterCourses=" + listSemesterCourses +
                '}';
    }
}
