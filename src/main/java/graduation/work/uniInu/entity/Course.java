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
@Table(name = "time_table")
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "day")
    @Enumerated(value = EnumType.STRING)
    private Weekday day;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "start_time")
    private int starTime;

    @Column(name = "end_time")
    private int endTime;
}
