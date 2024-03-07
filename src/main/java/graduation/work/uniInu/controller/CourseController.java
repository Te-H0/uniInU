package graduation.work.uniInu.controller;

import graduation.work.uniInu.dto.CoursesResponseDto;
import graduation.work.uniInu.dto.ReqDto;
import graduation.work.uniInu.global.ApiResponse;
import graduation.work.uniInu.service.CourseService;
import graduation.work.uniInu.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final UserService userService;
    private final CourseService courseService;

    @GetMapping
    public ApiResponse<List<CoursesResponseDto>> showTimeTable(@RequestParam Long userId) {
        return new ApiResponse<>(courseService.getUserCourseList(userId));
    }

    @PostMapping
    public void uploadTimeTable(@RequestParam Long userId, @RequestBody ReqDto.RegisterCourseDto registerCourseDto) {
        log.info("userId=> {}", userId);
        log.info("course=>{}", registerCourseDto.toString());
        courseService.registerCourse(userId, registerCourseDto);

    }
}

