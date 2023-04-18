package tn.esb.lmad.test.Domains;

import jakarta.persistence.*;
import lombok.*;
import tn.esb.lmad.test.Enumerations.PaymentMethodType;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor //generates a constructor with required fields(final fields and @Nonnull fields)
//@AllArgsConstructor //Because the id is auto generated,we don't need this annotation
//@NoArgsConstructor zeyed khater lezemna au moins deux parametres contact w haja okhra
@Table(name="Booking")
@Entity//JPA annotation to make this object ready for storage in a JPA-based data store

public class Booking {
    @Id
    //auto increment starts from 1 and increments by 1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate bookingDate;

    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(length = 10,columnDefinition = "varchar(10) default 'CASH'")
    private PaymentMethodType paymentMethod;
    @Column(columnDefinition = "boolean default false")
    private Boolean isPaid;
    //Specify the relationship between Booking and Passenger(* to 1)
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Booking(LocalDate bookingDate, BigDecimal price, PaymentMethodType paymentMethod) {
        this.bookingDate = bookingDate;
        this.price = price;
        this.paymentMethod = paymentMethod;
    }
}
