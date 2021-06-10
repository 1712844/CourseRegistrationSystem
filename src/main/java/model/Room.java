package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private long roomId;

    @Column(name = "room_name")
    private String roomName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "courseRoom")
    private List<Course> listRoomCourses = new ArrayList<>();
}
