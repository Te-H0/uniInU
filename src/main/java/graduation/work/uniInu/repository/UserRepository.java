package graduation.work.uniInu.repository;

import graduation.work.uniInu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByStudentNumber(String studentNumber);
}
