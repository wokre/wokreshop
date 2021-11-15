package co.kr.wokreshop.backpac;

import org.junit.jupiter.api.Test;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created By bohyun on 2021/11/13
 */
public class TempTest {

    @Test
    void BEncrypt_test() {

    }

    @Test
    void regex_test() {
        String regex = "^010-?([0-9]{3,4})-?([0-9]{4})$";
        String phone = "010-1124-9999";

        Pattern pattern = Pattern.compile(regex);
        assertEquals(true, pattern.matcher(phone).matches());

        regex = "^[0-9]*$";
//        regex = "^010-?([0-9]{3,4})-?([0-9]{4})$";
        phone = "01011249999";
        pattern = Pattern.compile(regex);
        assertEquals(true, pattern.matcher(phone).matches());

        regex = "^[a-z]*$";
        phone = "abc";
        pattern = Pattern.compile(regex);
        assertEquals(true, pattern.matcher(phone).matches());

        regex = "^[ㄱ-ㅎ|가-힣|a-z|A-Z|]+$";
        phone = "a나bc가";
        pattern = Pattern.compile(regex);
        assertEquals(true, pattern.matcher(phone).matches());

        regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]*$";
//        regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{10,}$";
        phone = "Password#1";
        pattern = Pattern.compile(regex);
        assertEquals(true, pattern.matcher(phone).matches());
    }

    @Test
    void random_test() {
        String uuid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
        System.out.println(uuid + " / " + uuid.length());
        String collect = Arrays.stream(uuid.split("")).distinct().limit(12).collect(Collectors.joining());
        System.out.println(collect + " / " + collect.length());
    }
}
