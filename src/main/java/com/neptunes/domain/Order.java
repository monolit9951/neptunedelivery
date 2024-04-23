package com.neptunes.domain;

import com.neptunes.configuration.UtcInstantType;
import com.neptunes.dto.order.request.ClientInfo;
import com.neptunes.dto.order.request.DeliveryAddress;
import com.neptunes.dto.order.request.OrderCartItem;
import com.neptunes.enums.DeliveryType;
import com.neptunes.enums.PaymentType;
import com.neptunes.enums.StatusType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;


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
    private Instant toDateTime;

    @Type( type = "jsonb" )
    @Column( columnDefinition = "jsonb" )
    private ClientInfo clientInfo;

    @Type( type = "jsonb" )
    @Column( columnDefinition = "jsonb" )
    private DeliveryAddress deliveryAddress;

    @Column
    private String comment;

    @Column
    private Integer peopleCount;

    @Type( type = "jsonb" )
    @Column( columnDefinition = "jsonb" )
    private List<OrderCartItem> cartItems;

    @Column
    private Integer sticksCount;

    @Column
    private Integer studySticksCount;

    @Column
    @Enumerated( EnumType.STRING )
    private DeliveryType deliveryType;

    @Column
    @Enumerated( EnumType.STRING )
    private PaymentType paymentType;

    @NotNull
    @Column
    @Enumerated( EnumType.STRING )
    private StatusType statusType;

    @Column
    private String code;
}
