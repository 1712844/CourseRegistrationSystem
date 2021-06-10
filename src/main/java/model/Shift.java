package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shift_id")
    private long shiftId;
    
    @Column(name = "shift_time")
    private String shiftTime;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseShift")
    private List<Course> listShiftCourses = new ArrayList<>();
}
