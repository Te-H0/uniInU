package graduation.work.uniInu.controller;

import com.univcert.api.UnivCert;
import graduation.work.uniInu.dto.ReqDto;
import graduation.work.uniInu.global.ApiResponse;
import graduation.work.uniInu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse<String> userSignUp(@RequestBody ReqDto.UserSignUpDto userSignUpDto) {
        boolean result = userService.join(userSignUpDto);

        if (result)
            return new ApiResponse<>("회원 가입에 성공했습니다 !");
        else
            throw new RuntimeException("이미 가입된 회원입니다!");
    }

    @PostMapping("/login")
    public ApiResponse<Long> userLogin(@RequestBody ReqDto.UserLoginDto userLoginDto) {

        return new ApiResponse<>(userService.login(userLoginDto));
    }

    @GetMapping("/verify")
    public boolean sendCode(@RequestParam String email) throws IOException {
        return userService.sendUserCertifyCode(email);
    }

    @GetMapping("/verify-code")
    public boolean verifyCode(@RequestParam int code, @RequestParam String email) throws IOException {
        return userService.userCertify(code, email);
    }

    @GetMapping("/reset")
    public Boolean resetVerify(@RequestParam String email) throws IOException {
        Map<String, Object> response = UnivCert.clear("982dedbe-9220-4370-b4be-f1273fb78c46", email);
        log.info("response=>{}", response);
        return (Boolean) response.get("success");
    }
}
