package graduation.work.uniInu.controller;

import graduation.work.uniInu.dto.ReqDto;
import graduation.work.uniInu.global.ApiResponse;
import graduation.work.uniInu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ApiResponse<String> userSignUp(@RequestBody ReqDto.UserSignUpDto userSignUpDto) {
        userService.join(userSignUpDto);
        return new ApiResponse<>("회원 가입에 성공했습니다 !");
    }

    @PostMapping("/login")
    public ApiResponse<Long> userLogin(@RequestBody ReqDto.UserLoginDto userLoginDto) {

        return new ApiResponse<>(userService.login(userLoginDto));
    }
}
