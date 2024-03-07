package graduation.work.uniInu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoursesResponseDto {

    private Long id;

    @JsonProperty("course_name")
    private String courseName;

    private String day;

    @JsonProperty("start_time")
    private int starTime;
    @JsonProperty("end_time")
    private int endTime;

}
