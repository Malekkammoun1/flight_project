package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Airport")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store
//the database is a relational one
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(unique = true,length = 100,name="airport_name")
    private String name;
    private String city;
    private String country;
    private String timezone;
    private Integer runways;
    //the relationship between airport and flight
    @ManyToMany
            //generate the association table using@JoinTable
    //we use @JoinTable because the association table has only
    // 2 columns airport_code and flight_code which are 2 foreign
    //keys defining a composite primary key
    //the definition of the association table should be done in only
    //one of the two entities not in both

            @JoinTable(name = "airport_flight",
                    //the foreign key of the current entity is airport_code
                    //the referrencedColumnName is optional
                    //we have to specify the name of the primary
                    //key of the current entity in first place
                    joinColumns = @JoinColumn(name = "airport_code"),
                    //the foreign key of the other entity is flight_code
                    inverseJoinColumns=@JoinColumn(name = "flight_code"))
    Set<Flight> flights=new HashSet<>();

    public Airport(@NonNull String name, String city, String country, String timezone, Integer runways, Set<Flight> flights) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.timezone = timezone;
        this.runways = runways;
        this.flights = flights;
    }
}
