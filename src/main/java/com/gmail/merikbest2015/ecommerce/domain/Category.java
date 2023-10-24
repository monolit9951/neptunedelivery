package com.gmail.merikbest2015.ecommerce.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq")
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq", initialValue = 20, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String nameUa;

    @Column
    private String nameRu;

    @Column
    private String nameEn;

    @Column
    private String url;

    @Column
    private String img;
}
