package models;
import lombok.Data;
import java.util.Objects;

@Data
public class Tests {
    private String duration;
    private String method;
    private String name;
    private String startTime;
    private String endTime;
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tests tests = (Tests) o;
        boolean ok = duration.equalsIgnoreCase(tests.duration);
        ok &= method.equalsIgnoreCase(tests.method);
        ok &= name.equalsIgnoreCase(tests.name);
        ok &= startTime == null && tests.startTime.equals("") || tests.startTime == null && startTime.equals("") || startTime.equalsIgnoreCase(tests.startTime);
        ok &= endTime == null && tests.endTime.equals("") || tests.endTime == null && endTime.equals("") || endTime.equalsIgnoreCase(tests.endTime);
        ok &= status.equalsIgnoreCase(tests.status);
        return ok;
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, method, name, startTime, endTime, status);
    }
}
