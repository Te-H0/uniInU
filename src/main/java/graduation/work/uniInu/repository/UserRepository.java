package graduation.work.uniInu.repository;

import graduation.work.uniInu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
