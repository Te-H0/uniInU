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
    public ApiResponse<Object> uploadTimeTable(@RequestParam Long userId, @RequestBody ReqDto.RegisterCourseDto registerCourseDto) {
        log.info("userId=> {}", userId);
        log.info("course=>{}", registerCourseDto.toString());
        courseService.registerCourse(userId, registerCourseDto);

        return new ApiResponse<>(200, "수업 등록 성공!");
    }

    @DeleteMapping
    public ApiResponse<Object> deleteTimeTable(@RequestParam Long userId, @RequestParam String course) {

        courseService.deleteCourse(userId, course);

        return new ApiResponse<>(200, "수업 삭제 성공!");
    }
}

