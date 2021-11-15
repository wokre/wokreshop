package co.kr.wokreshop.backpac.service;

import co.kr.wokreshop.backpac.entity.Member;
import co.kr.wokreshop.backpac.params.MemberParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By bohyun on 2021/11/15
 */
public class MemberSpecification implements Specification<Member> {

    private MemberParam params;

    public MemberSpecification(MemberParam params) {
        this.params = params;
    }

    @Override
    public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        List<Predicate> list = new ArrayList<>();
        String value;
        if (StringUtils.hasText(params.getName())) {
            value = "%" + params.getName() + "%";
            list.add(cb.like(root.get("name"), value));
        }
        if (StringUtils.hasText(params.getEmail())) {
            value = "%" + params.getEmail() + "%";
            list.add(cb.like(root.get("email"), value));
        }

        return cb.and(list.toArray(new Predicate[0]));
    }
}
