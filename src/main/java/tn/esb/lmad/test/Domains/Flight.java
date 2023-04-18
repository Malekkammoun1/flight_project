package tn.esb.lmad.test.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import tn.esb.lmad.test.Enumerations.AircraftModel;
import tn.esb.lmad.test.Enumerations.FlightStatus;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Flight")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store
//the database is a relational one
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String flightNumber;
    private String name;
    //JsonFormat is used to format the date and time request and response
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime DepartureTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ArrivalTime;
    private BigDecimal price;
    private float duration;
    private int distance;
    private boolean isDirect;
    @Enumerated(EnumType.STRING)
    @Column(length = 10,columnDefinition = "varchar(10) default 'SCHEDULED' " )
    private FlightStatus status;
    @ManyToMany(mappedBy = "flights")
    Set<Airport> airports=new HashSet<>();
    @OneToMany(mappedBy = "Flight")
    private Set<Booking> booking=new HashSet<Booking>();
    @ManyToOne
    @JoinColumn(name = "aircraft")
    @JoinColumn(name = "seat")
    private Aircraft aircraft;
    private Seat seat;

    public Flight(String name, LocalDateTime departureTime, LocalDateTime arrivalTime, BigDecimal price, float duration, int distance, boolean isDirect, FlightStatus status, Set<Airport> airports) {
        this.name = name;
        DepartureTime = departureTime;
        ArrivalTime = arrivalTime;
        this.price = price;
        this.duration = duration;
        this.distance = distance;
        this.isDirect = isDirect;
        this.status = status;
        this.airports = airports;
    }
}
