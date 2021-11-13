package co.kr.wokreshop.backpac.entity;

import co.kr.wokreshop.backpac.enums.EnumSex;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

/**
 * Created By bohyun on 2021/11/13
 */
@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String nickName;

    private String password;

    private String mobile;

    private String email;

    @Enumerated(STRING)
    private EnumSex sex;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Builder
    public Member(String name, String nickName, String password, String mobile, String email, EnumSex sex) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
        this.sex = sex;
    }
}
