package kz.narxoz.javaee.finalSpring.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname ;

    @Column(name = "age")
    private int age  ;

    @Column(name = "phonenumber")
    private long phonenumber   ;

    @Column(name = "address")
    private String address   ;

    @Column(name = "position")
    private String position    ;

    @Column(name = "salary")
    private int salary   ;


}
