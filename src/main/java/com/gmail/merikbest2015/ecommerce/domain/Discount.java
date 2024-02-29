package com.gmail.merikbest2015.ecommerce.domain;

import com.gmail.merikbest2015.ecommerce.configuration.HashMapConverter;
import com.gmail.merikbest2015.ecommerce.enums.DiscountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.relation.Relation;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@ToString
@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "discount_id_seq" )
    @SequenceGenerator( name = "discount_id_seq", sequenceName = "discount_id_seq", initialValue = 54, allocationSize = 1 )
    @Column( name = "id" )
    private Long id;

    @Convert(converter = HashMapConverter.class)
    private Map<Long, BigDecimal> discountPerQuantity;

    private DiscountType type;

    private Long relationId;
}
