package com.neptunes.domain;

import com.neptunes.configuration.HashMapConverter;
import com.neptunes.enums.DiscountType;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "discount")
@Builder
public class Discount {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "discount_id_seq" )
    @SequenceGenerator( name = "discount_id_seq", sequenceName = "discount_id_seq", initialValue = 54, allocationSize = 1 )
    @Column( name = "id" )
    private Long id;

    @Convert(converter = HashMapConverter.class)
    private Map<Long, BigDecimal> discountPerQuantity;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private Long relationId;
}
