package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Seats")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store
//the database is a relational one
public class Seat {
    @Id
    //auto increment starts from 1 and increments by 1
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name="seat_number")
    private int seatNumber;
    @Column(name="seat_class",columnDefinition = "varchar(255) default 'Economy'")
    private String seatClass;
    //@Column(name ="seat_price",precision = 7,scale = 2)
    @Digits(integer = 7,fraction = 2)
    private BigDecimal seatPrice;
    @Size(min = 20,max = 25)
    private BigDecimal seatPitch;
    private boolean isAvailable;
    @Min(0)
    @Max(45)
    private BigDecimal recline;
    private String entertainmentOptions;
    @OneToMany(mappedBy = "seat")
    private Set<Flight> flight=new HashSet<Flight>();

    public Seat(int seatNumber, String seatClass, BigDecimal seatPrice, BigDecimal seatPitch, boolean isAvailable, BigDecimal recline, String entertainmentOptions) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.seatPrice = seatPrice;
        this.seatPitch = seatPitch;
        this.isAvailable = isAvailable;
        this.recline = recline;
        this.entertainmentOptions = entertainmentOptions;
    }
}
