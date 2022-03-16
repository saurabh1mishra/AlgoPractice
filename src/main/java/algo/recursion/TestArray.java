package algo.recursion;

import java.util.Objects;

public class TestArray {
    int i;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestArray testArray = (TestArray) o;
        return i == testArray.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
