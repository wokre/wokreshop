package co.kr.wokreshop.backpac.repository;

import co.kr.wokreshop.backpac.entity.Member;
import co.kr.wokreshop.backpac.enums.EnumSex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created By bohyun on 2021/11/13
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository repository;

    @Test
    void save_test() {
        Member member = Member.builder().name("test").nickName("tester").email("test@test.com").mobile("010-1111-1111").password("1234").sex(EnumSex.M).build();
        Member save = repository.save(member);

        Assertions.assertEquals("tester", save.getName());
    }
}