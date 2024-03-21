package graduation.work.uniInu;

import graduation.work.uniInu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserService userService;

    @GetMapping("/test")
    public String testApi() {
        return "YES~!";
    }
}

