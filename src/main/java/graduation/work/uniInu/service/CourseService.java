package graduation.work.uniInu.service;

import graduation.work.uniInu.dto.CoursesResponseDto;
import graduation.work.uniInu.dto.ReqDto;
import graduation.work.uniInu.entity.Course;
import graduation.work.uniInu.entity.User;
import graduation.work.uniInu.entity.Weekday;
import graduation.work.uniInu.repository.CourseRepository;
import graduation.work.uniInu.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public void registerCourse(Long userId, ReqDto.RegisterCourseDto registerCourseDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("없는 유저입니다."));

        Course course = Course.builder()
                .user(user)
                .courseName(registerCourseDto.getCourseName())
                .day(Weekday.formValue(registerCourseDto.getDay()))
                .starTime(registerCourseDto.getStarTime())
                .endTime(registerCourseDto.getEndTime())
                .build();

        courseRepository.save(course);
    }

    public List<CoursesResponseDto> getUserCourseList(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("없는 유저 입니다."));
        List<CoursesResponseDto> response = new ArrayList<>();
        List<Course> courseList = courseRepository.findAllByUserOrderByDay(user);

        for (Course course : courseList) {
            CoursesResponseDto coursesResponse = CoursesResponseDto.builder()
                    .id(course.getId())
                    .courseName(course.getCourseName())
                    .day(course.getDay().getValue())
                    .starTime(course.getStarTime())
                    .endTime(course.getEndTime())
                    .build();
            response.add(coursesResponse);
        }
        return response;
    }

    public void deleteCourse(Long userId, Long courseId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("잘못된 유저입니다."));
        Course course = courseRepository.findCourseByIdAndUser(courseId, user).orElseThrow(() -> new RuntimeException("없는 수업입니다."));
        courseRepository.delete(course);

    }

}
