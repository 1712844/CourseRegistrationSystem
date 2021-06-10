package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CourseRegistrationSession")
public class CourseRegistrationSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crs_id")
    private Long crsId;

    @Column(name = "crs_begin_date")
    private Date crsBeginDate;

    @Column(name = "crs_end_date")
    private Date crsEndDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseCRS")
    private List<Course> listCRSCourse =  new ArrayList<>();
}
