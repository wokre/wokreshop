package co.kr.wokreshop.backpac.dto;

import co.kr.wokreshop.backpac.enums.EnumSex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * Created By bohyun on 2021/11/14
 */
@Getter @Setter
public class MemberDTO {

    @NotBlank(message = "회원 Id는 필수값 입니다.")
    private String memberId;

    @NotBlank(message = "회원명은 필수값 입니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ|가-힣|a-z|A-Z|]+$", message = "한글, 영문 대소문자만 입력해야 합니다.")
    private String name;

    @NotBlank(message = "별명은 필수값 입니다.")
    @Pattern(regexp = "^[a-z]*$$", message = "영문 소문자만 입력해야 합니다.")
    private String nickName;

    @NotBlank(message = "비밀번호는 필수값 입니다.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]*$", message = "영문 대문자, 영문 소문자, 특수 문자, 숫자 각 1개 이상씩 포함하고, 10자이상이어야 합니다.")
    @Size(min = 10, message = "10자이상 입력해야 합니다.")
    private String password;

    @NotBlank(message = "휴대폰번호는 필수값 입니다.")
    @Pattern(regexp = "^[0-9]*$", message = "숫자만 입력해야 합니다.(\"-\"제외")
    @Size(max = 20, message = "20자 이상 입력할 수 없습니다.")
    private String mobile;

    @NotBlank(message = "이매일은 필수값 입니다.")
    @Email(message = "wokreshop@example.com 형식으로 입력해야 합니다.")
    private String email;

    private EnumSex sex;
}
