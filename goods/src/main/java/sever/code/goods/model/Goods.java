package sever.code.goods.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "features")
    private String features;

//    @Column(name = "review_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date reviewDate;
//
//    @Column(name = "review_content")
//    private String reviewContent;
//
//    @Column(name = "review_rating")
//    private int reviewRating;

}