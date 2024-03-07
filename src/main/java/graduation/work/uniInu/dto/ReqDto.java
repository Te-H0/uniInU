package graduation.work.uniInu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ReqDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserVerifyDto {

        private String email;
        private int code;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSignUpDto {
        private String name;

        @JsonProperty("student_number")
        private String studentNumber;

        private String password;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserLoginDto {
        @JsonProperty("student_number")
        private String studentNumber;

        private String password;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterCourseDto {

        @JsonProperty("course_name")
        private String courseName;

        private String day;

        @JsonProperty("start_time")
        private int starTime;

        @JsonProperty("end_time")
        private int endTime;
    }


}
