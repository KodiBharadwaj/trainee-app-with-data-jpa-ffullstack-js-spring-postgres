package com.ust.traineeapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainee_db")
//@NamedQueries(
//        {@NamedQuery(query = "form Trainee where location=:location", name = "findByLocation")}
//)
public class Trainee {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // for auto increment
    @Column(name = "trainee_id")
    //@JsonProperty("trainee_id") // renames the id here
    private int id;

    @Column(name = "trainee_name", length = 50)
    private String name;

    @Column(length = 100)
    private String location;

    @Column(name = "joined_date")
    @DateTimeFormat(pattern = "dd/MMM/yyyy") // to change the pattern of the date format
    private LocalDate joinedDate;
    


//    @OneToOne(cascade = CascadeType.ALL)
//    private Project project;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Project> projects;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Project project;

}
