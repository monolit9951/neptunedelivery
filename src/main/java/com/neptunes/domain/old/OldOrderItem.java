//package com.gmail.merikbest2015.ecommerce.domain.old;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Objects;
//
//import com.gmail.merikbest2015.ecommerce.domain.Perfume;
//
//
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "order_item")
//public class OldOrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_seq")
//    @SequenceGenerator(name = "order_item_seq", sequenceName = "order_item_seq", initialValue = 12, allocationSize = 1)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "amount")
//    private Long amount;
//
//    @Column(name = "quantity")
//    private Long quantity;
//
//    @OneToOne
//    private Perfume perfume;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OldOrderItem oldOrderItem = (OldOrderItem) o;
//        return Objects.equals(id, oldOrderItem.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
