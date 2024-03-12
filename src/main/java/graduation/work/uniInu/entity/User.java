package graduation.work.uniInu.entity;

import graduation.work.uniInu.global.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "User")
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "student_number")
    private String studentNumber;

    private String password;
}
