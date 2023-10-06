package com.gmail.merikbest2015.ecommerce.domain;

import com.gmail.merikbest2015.ecommerce.configuration.UtcInstantType;
import com.gmail.merikbest2015.ecommerce.dto.order.request.OrderCartItem;
import com.gmail.merikbest2015.ecommerce.enums.DeliveryType;
import com.gmail.merikbest2015.ecommerce.enums.PaymentType;
import com.gmail.merikbest2015.ecommerce.enums.StatusType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.EMPTY_POST_INDEX;


@Getter
@Setter
@ToString
@Entity
@TypeDef( name = "jsonb", typeClass = JsonBinaryType.class )
@Table( name = "orders" )
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "order_id_seq" )
    @SequenceGenerator( name = "order_id_seq", sequenceName = "order_id_seq", initialValue = 6, allocationSize = 1 )
    @Column( name = "id" )
    private Long id;

    @Type( type = UtcInstantType.CANONICAL_NAME )
    private Instant toDate;

    @Type( type = UtcInstantType.CANONICAL_NAME )
    private Instant toTime;

    @Column
    private String firstName;

    @Column
    private String phoneNumber;

    @Column
    private Long cityId;

    @Column
    private String street;

    @Column
    private String houseNumber;

    @Column
    private String houseEntrance;

    @Column
    private String houseFloor;

    @Column
    private String apartmentNumber;

    @NotNull( message = EMPTY_POST_INDEX )
    @Min( value = 5, message = "Post index must contain 5 digits" )
    private Integer postIndex;

    @Column
    private String comment;

    @Column
    private Integer peopleQuantity;

    @Type( type = "jsonb" )
    @Column( columnDefinition = "jsonb" )
    private List<OrderCartItem> cartItems;

    @Column
    private Integer studyQuantity;

    @Column
    private Integer simpleQuantity;

    @Column
    @Enumerated( EnumType.STRING )
    private DeliveryType deliveryType;

    @Column
    @Enumerated( EnumType.STRING )
    private PaymentType paymentType;

    @Column
    @Enumerated( EnumType.STRING )
    private StatusType statusType;
}
