package WebProjectStudy.typeClass;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Boards {
    private String title;
    private String[] descriptions;

    @Override
    public String toString() {
        return "Todos{" +
                "title='" + title + '\'' +
                ", descriptions=" + Arrays.toString(descriptions) +
                '}';
    }

}
