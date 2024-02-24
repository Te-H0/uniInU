package graduation.work.uniInu.service;

import com.univcert.api.UnivCert;
import graduation.work.uniInu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean sendUserCertifyCode(String email) throws IOException {
        Map<String, Object> response = UnivCert.certify("982dedbe-9220-4370-b4be-f1273fb78c46", email, "인천대학교", false);
        return (boolean) response.get("success");
    }

    public boolean userCertify(int code, String email) throws IOException {
        Map<String, Object> response = UnivCert.certifyCode("982dedbe-9220-4370-b4be-f1273fb78c46", email, "인천대학교", code);
        return (boolean) response.get("success");
    }
}
