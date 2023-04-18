package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="EmployeeContact")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store
//the database is a relational one
public class EmployeeContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String emailAddress;
    private String phoneNumber;
    private String mailingAddress;
    //specify the relationship between employee contact and employee(1 to 1)
    @OneToOne
    private Employee employee;

    public EmployeeContact(String emailAddress, String phoneNumber, String mailingAddress) {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
    }
}
