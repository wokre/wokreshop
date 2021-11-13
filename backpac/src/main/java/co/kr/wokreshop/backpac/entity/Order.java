package co.kr.wokreshop.backpac.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

/**
 * Created By bohyun on 2021/11/13
 */
@Entity
@Table(name = "order")
@Data
@ToString(exclude = "member")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String orderNumber;

    private String productName;

    private LocalDateTime paymentDate;
}
