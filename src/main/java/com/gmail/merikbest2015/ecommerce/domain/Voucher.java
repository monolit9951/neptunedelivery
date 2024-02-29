package com.gmail.merikbest2015.ecommerce.domain;

import com.gmail.merikbest2015.ecommerce.configuration.UtcInstantType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table( name = "voucher" )
public class Voucher {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "voucher_id_seq" )
    @SequenceGenerator( name = "voucher_id_seq", sequenceName = "voucher_id_seq", initialValue = 12, allocationSize = 1 )
    @Column( name = "id" )
    private Long id;

    @Column
    private String code;

    @Column
    @Type( type = UtcInstantType.CANONICAL_NAME )
    private Instant dateUntilValid;

    @Column
    private Integer quantityOfUse;

    @Column
    private BigDecimal discountPercentage;
}
