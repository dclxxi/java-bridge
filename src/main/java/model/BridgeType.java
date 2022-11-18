package model;

import java.util.Arrays;
import java.util.Optional;

public enum BridgeType {
    UP(1, "U"),
    DOWN(0, "D");

    private final int number;
    private final String mark;

    BridgeType(int number, String mark) {
        this.number = number;
        this.mark = mark;
    }

    public int getNumber() {
        return number;
    }

    public String getMark() {
        return mark;
    }

    public static Optional<String> getMarkByNumber(int number) {
        return Arrays.stream(values())
                .filter(type -> type.number == number)
                .findAny()
                .map(BridgeType::getMark);
    }

    public boolean isEquals(BridgeType type) {
        return this.equals(type);
    }

    public boolean isEqualsMark(String mark) {
        return this.mark.equals(mark);
    }

    public static BridgeType getByMark(String mark) {
        return Arrays.stream(values())
                .filter(type -> type.isEqualsMark(mark))
                .findAny()
                .orElse(null);
    }
}
