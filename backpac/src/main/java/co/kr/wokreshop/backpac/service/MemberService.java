package co.kr.wokreshop.backpac.service;

import co.kr.wokreshop.backpac.dto.MemberDTO;
import co.kr.wokreshop.backpac.entity.Member;
import co.kr.wokreshop.backpac.entity.Order;
import co.kr.wokreshop.backpac.exception.BackPacException;
import co.kr.wokreshop.backpac.params.MemberParam;
import co.kr.wokreshop.backpac.repository.MemberRepository;
import co.kr.wokreshop.backpac.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

/**
 * Created By bohyun on 2021/11/14
 */
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public Member getMember(String memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> {
            throw new IllegalArgumentException("회원 정보를 조회할 수 없습니다.");
        });
        return member;
    }

    @Transactional
    public Member join(MemberDTO memberDTO) {
        Member member = memberRepository.findById(memberDTO.getMemberId()).orElse(null);
        if (member == null) {
            member = Member.builder().dto(memberDTO).build();
            return memberRepository.save(member);
        }
        else {
            throw new BackPacException("회원이 존재합니다.");
        }
    }

    public Page<Member> getList(MemberParam params, Pageable pageable) {
        MemberSpecification specification = new MemberSpecification(params);
        Page<Member> page = memberRepository.findAll(specification, pageable);

        page.getContent().stream().forEach(m -> {
            Order order = m.getOrders().stream()
                    .sorted(Comparator.comparing(Order::getPaymentDate).reversed())
                    .findFirst().orElse(null);
            m.setLastOrder(order);
        });
        return page;
    }
}
