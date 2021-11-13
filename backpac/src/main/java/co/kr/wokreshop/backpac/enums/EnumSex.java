package co.kr.wokreshop.backpac.enums;

import lombok.Getter;

/**
 * Created By bohyun on 2021/11/13
 */
public enum EnumSex {
    M("남자"),
    F("여자");

    private @Getter String value;

    EnumSex(String value) {
        this.value = value;
    }
}
