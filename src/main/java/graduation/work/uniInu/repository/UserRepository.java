package graduation.work.uniInu.repository;

import graduation.work.uniInu.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserByStudentNumber(String studentNumber);

  Boolean existsByStudentNumber(String studentNumber);
}
