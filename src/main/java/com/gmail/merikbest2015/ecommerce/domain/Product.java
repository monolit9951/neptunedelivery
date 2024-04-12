package com.gmail.merikbest2015.ecommerce.domain;

import com.gmail.merikbest2015.ecommerce.configuration.UtcInstantType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;


@Getter
@Setter
@ToString
@Entity
@Table( name = "product" )
@Where( clause = "removal_date IS NULL" )
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "product_id_seq" )
    @SequenceGenerator( name = "product_id_seq", sequenceName = "product_id_seq", initialValue = 21,
            allocationSize = 1 )
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String nameRu;

    @Column
    private String nameEn;

    @Column
    private String nameUa;

    @Column
    private Integer price;

//    @Type( type = "jsonb" )
//    @Column( columnDefinition = "jsonb" )
//    private List<Long> categoriesId;

    @Column
    private Long categoryId;

    @Column
    private Integer allergensId;

    @Column
    private Double weight;

    @Column
    private String url;

    @Column
    private String img;

    @Column
    private Integer status;

    @Column
    private String description;

    @Column
    private String descriptionRu;

    @Column
    private String descriptionEn;

    @Column
    private String descriptionUa;

    @Column
    private Integer size;

    @Column
    private Integer sale;

    @Column
    private Integer cartCount;

    @Column
    private Integer sort;

    @Column
    private Integer box;

    @Type( type = UtcInstantType.CANONICAL_NAME )
    private Instant removalDate;

    @OneToOne
    private Discount discount;


    @Override
    public boolean equals( Object o ) {
        if( this == o )
            return true;
        if( o == null || getClass() != o.getClass() )
            return false;
        Product product = (Product)o;
        return Objects.equals( id, product.id );
    }


    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}

