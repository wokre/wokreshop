package co.kr.wokreshop.backpac.repository;

import co.kr.wokreshop.backpac.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created By bohyun on 2021/11/13
 */
public interface MemberRepository extends JpaRepository<Member, String>, JpaSpecificationExecutor<Member> {
    Page<Member> findAll(Specification<Member> specification, Pageable pageable);
}
