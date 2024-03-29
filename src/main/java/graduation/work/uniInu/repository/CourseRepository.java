package graduation.work.uniInu.repository;

import graduation.work.uniInu.entity.Course;
import graduation.work.uniInu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByUserOrderByDay(User user);

    Optional<Course> findCourseByIdAndUser(Long id, User user);

}
