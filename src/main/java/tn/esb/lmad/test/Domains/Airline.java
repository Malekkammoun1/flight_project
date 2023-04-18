package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude ={"logo"} )
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Airlines")
@Entity
public class Airline {
    @Id
    //auto increment starts from 1 and increments by 1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull //a property cannot be null
    //the column is required and must be unique
    //@Column : to specify the column name,length,...
    //in sql : it is translated into
    //CREATE TABLE airlines(code INTEGER PRIMARY KEY AUTO_INCREMENT,name VARCHAR(70) NOT NULL UNIQUE;
    @Column(unique = true,length = 100,name="airline_name")
    @EqualsAndHashCode.Include
    private String name;
    @NonNull
    private String contactInformation;
    private String headQuarters;
    @Lob //a property will be persisted as a large object type to a database-supported large object type
    private byte[] logo;
    private int fleetSize;
    public Airline(){
    }

    public Airline(Integer id, @NonNull String name, @NonNull String contactInformation, String headQuarters, byte[] logo, int fleetSize) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
        this.headQuarters = headQuarters;
        this.logo = logo;
        this.fleetSize = fleetSize;
    }
    //specify the relationship between airline and aircraft(one to many)
    @OneToMany(mappedBy = "airline")
    private Set<Aircraft> aircrafts=new HashSet<Aircraft>();
    private Set<Employee> employee=new HashSet<Employee>();

}
