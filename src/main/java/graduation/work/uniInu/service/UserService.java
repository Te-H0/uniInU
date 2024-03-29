package graduation.work.uniInu.service;

import com.univcert.api.UnivCert;
import graduation.work.uniInu.dto.ReqDto;
import graduation.work.uniInu.entity.User;
import graduation.work.uniInu.global.exception.BadRequestException;
import graduation.work.uniInu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean sendUserCertifyCode(String email) throws IOException {
        Map<String, Object> response = UnivCert.certify("982dedbe-9220-4370-b4be-f1273fb78c46", email, "인천대학교", false);
        return (boolean) response.get("success");
    }

    public boolean userCertify(int code, String email) throws IOException {
        Map<String, Object> response = UnivCert.certifyCode("982dedbe-9220-4370-b4be-f1273fb78c46", email, "인천대학교", code);
        return (boolean) response.get("success");
    }

    public boolean join(ReqDto.UserSignUpDto userSignUpDto) {
        if (userRepository.existsByStudentNumber(userSignUpDto.getStudentNumber())) {
            return false;
        } else {
            User joinUser = User.builder()
                    .name(userSignUpDto.getName())
                    .password(passwordEncoder.encode(userSignUpDto.getPassword()))
                    .studentNumber(userSignUpDto.getStudentNumber())
                    .build();

            userRepository.save(joinUser);
            return true;
        }
    }

    public long login(ReqDto.UserLoginDto userLoginDto) {
        User loginUser = userRepository.findUserByStudentNumber(userLoginDto.getStudentNumber()).orElseThrow(() -> new BadRequestException("존재하지 않는 유저 입니다."));

        if (!passwordEncoder.matches(userLoginDto.getPassword(), loginUser.getPassword())) {
            throw new BadRequestException("비밀번호가 틀립니다.");
        }
        return loginUser.getId();

    }
}
