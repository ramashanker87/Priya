package com.priya.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(nullable = false)
   private String name;
    @Column( nullable= false)
    private String schoolName;
    @Column(nullable= false)
    private int age;
    @Column(nullable= false)
    private String gender;

}
