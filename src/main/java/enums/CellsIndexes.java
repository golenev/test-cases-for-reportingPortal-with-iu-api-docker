package enums;

public enum CellsIndexes {
    INITIAL_TEST_VALUE(10),
    ZERO(0),
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5);

    int index;

    CellsIndexes(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
