package pl.test.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Arrays;
import java.util.List;

@Value
public class HumanType {
    String name;

    public static final String STUDENT = "student";
    public static final String LECTURER = "lecturer";

    private static final List<String> humanTypes = Arrays.asList(
            STUDENT,
            LECTURER
    );

    @JsonCreator
    public HumanType(@JsonProperty("name") String name) {
        this.validate(name);

        this.name = name;
    }

    private void validate(String humanType) throws IllegalArgumentException {
        if (humanTypes.stream().noneMatch(s -> s.equals(humanType))) {
            throw new IllegalArgumentException(
                    "Human Type: " + humanType + " is not valid Human Type"
            );
        }
    }
}
