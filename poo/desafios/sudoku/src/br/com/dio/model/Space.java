package br.com.dio.model;

public class Space {
    private final boolean fixed;
    private final int expected;
    private Integer actual;

    public Space(final boolean fixed, final int expected) {
        this.expected = expected;
        this.fixed = fixed;
        if (fixed) {
            actual = expected;
        }
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(Integer actual) {
        if (fixed) return;
        this.actual = actual;
    }

    public void clearSpace() {
        setActual(null);
    }

    public boolean isFixed() {
        return fixed;
    }

    public int getExpected() {
        return expected;
    }
}
