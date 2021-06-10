package model;

import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff extends User{

    public Staff(String userFirstName, String userLastName, String email, String role) {
        super(userFirstName, userLastName, email, role);
    }
}
