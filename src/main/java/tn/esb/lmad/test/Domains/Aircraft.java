package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import lombok.*;
import tn.esb.lmad.test.Enumerations.AircraftModel;
import java.math.BigDecimal;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Aircraft")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store
//the database is a relational one
public class Aircraft {
    @Id //JPA annotation to specify the primary key of an entity
    private String id;
    @Enumerated(EnumType.STRING)
    private AircraftModel model;
    private int maxPassengerCapacity;
    private int range;
    private BigDecimal fuelConsumption;
    //specify the relationship between Aircraft and Airline(many to one)
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
}
