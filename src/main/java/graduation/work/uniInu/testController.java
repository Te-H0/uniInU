package graduation.work.uniInu;

import graduation.work.uniInu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class testController {
    private final UserService userService;

    @GetMapping("/verify")
    public boolean sendCode(String email) throws IOException {
        /**
         * TODO
         *  email로 바꿔야함
         */
        return userService.sendUserCertifyCode("xogh8755@inu.ac.kr");
    }

    @GetMapping("/verify-code")
    public boolean verifyCode(@RequestParam int code) throws IOException {
        /**
         * TODO
         *  email로 바꿔야함
         */
        return userService.userCertify(code, "xogh8755@inu.ac.kr");
    }
}
