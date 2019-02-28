package by.spurky.progression;

import java.util.Objects;

public class ArithmeticalProgression {

    private Integer firstMember;
    private Integer secondMember;

    public Integer getFirstMember() {
        return firstMember;
    }

    public Integer getSecondMember() {
        return secondMember;
    }

    private Integer delta;

    ArithmeticalProgression(Integer firstMember, Integer secondMember) {
        this.delta = secondMember - firstMember;
        this.firstMember = firstMember;
        this.secondMember = secondMember;
    }

    public Integer memberBy(Integer serialNumber) {
        return firstMember + delta * (serialNumber - 1);
    }

    public Integer getDelta() {
        return delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArithmeticalProgression that = (ArithmeticalProgression) o;
        return firstMember.equals(that.firstMember) &&
                secondMember.equals(that.secondMember);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstMember, secondMember);
    }
}
