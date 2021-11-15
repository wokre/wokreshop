package co.kr.wokreshop.backpac.entity;

import co.kr.wokreshop.backpac.dto.MemberDTO;
import co.kr.wokreshop.backpac.enums.EnumSex;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Comparator;
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
    private String memberId;

    private String name;

    private String nickName;

    private String password;

    private String mobile;

    private String email;

    @Enumerated(STRING)
    private EnumSex sex;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @Transient
    private Order LastOrder = null;

    @Builder
    public Member(MemberDTO dto) {
        this.memberId = dto.getMemberId();
        this.name = dto.getName();
        this.nickName = dto.getNickName();
        this.password = dto.getPassword();
        this.mobile = dto.getMobile();
        this.email = dto.getEmail();
        this.sex = dto.getSex();
    }
}
