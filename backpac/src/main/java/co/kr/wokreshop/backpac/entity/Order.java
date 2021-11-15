package co.kr.wokreshop.backpac.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

/**
 * Created By bohyun on 2021/11/13
 */
@Entity
@Table(name = "orders")
@Data
@ToString(exclude = "member")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member;

    private String orderNumber;

    private String productName;

    private LocalDateTime paymentDate;
}
