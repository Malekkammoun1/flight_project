package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Employee")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store
//the database is a relational one
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String jobTitle;
    private BigDecimal salary;
    @OneToOne(mappedBy = "employee")
    //mappedBy="employee"means that the relationships is owned by the other side(EmployeeContact)
    //the two sides of the relationship comes from the same relationship
    @JoinColumn(name = "contact id")
    private EmployeeContact employeeContact;
    @JoinColumn(name = "airline_id")
    private Airline airline;
    @ManyToOne
    @JoinColumn(name = "employeeCt")
    private EmployeeContact employeeCt;

    public Employee(String name, String jobTitle, BigDecimal salary) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }
}
