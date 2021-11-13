package co.kr.wokreshop.backpac.repository;

import co.kr.wokreshop.backpac.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created By bohyun on 2021/11/13
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
