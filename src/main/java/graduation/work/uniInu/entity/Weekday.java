package graduation.work.uniInu.entity;

import lombok.Getter;

@Getter
public enum Weekday {
    MON("월요일"), TUE("화요일"), WED("수요일"), THU("목요일"), FRI("금요일");

    private final String value;

    Weekday(String value) {
        this.value = value;
    }

    public static Weekday formValue(String value) {
        for (Weekday day : Weekday.values()) {
            if (day.value.equals(value)) {
                return day;
            }
        }
        throw new RuntimeException("시간표 날짜 오류");
    }
}
