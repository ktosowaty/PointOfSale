package pointofsale;

import java.util.Objects;

public class Money {
    private long value;

    public Money(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    private long getTotalPart() {
        return value/100;
    }

    private long getFractionalPart() {
        return value%100;
    }

    public void add(Money money) {
        value += money.getValue();
    }

    public String toString() {
        if(getFractionalPart()<10) return getTotalPart() + ".0" + getFractionalPart();
        else return getTotalPart() + "." + getFractionalPart();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
