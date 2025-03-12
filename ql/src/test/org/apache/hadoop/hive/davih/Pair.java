package org.apache.hadoop.hive.davih;

/**
 * A simple utility class to represent a pair of objects.
 *
 * @param <A> the type of the first object
 * @param <B> the type of the second object
 */
public class Pair<A, B> {
    public final A fst;  // first object
    public final B snd;  // second object

    /**
     * Constructs a new pair with the given objects.
     *
     * @param fst the first object
     * @param snd the second object
     */
    public Pair(A fst, B snd) {
        this.fst = fst;
        this.snd = snd;
    }

    /**
     * Returns a string representation of this pair.
     *
     * @return a string representation of this pair
     */
    @Override
    public String toString() {
        return "(" + fst + ", " + snd + ")";
    }

    /**
     * Compares this pair with another pair for equality.
     *
     * @param obj the object to compare with
     * @return true if this pair is equal to the given object
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return (fst != null ? fst.equals(pair.fst) : pair.fst == null) &&
                (snd != null ? snd.equals(pair.snd) : pair.snd == null);
    }

    /**
     * Returns the hash code for this pair.
     *
     * @return the hash code for this pair
     */
    @Override
    public int hashCode() {
        int result = fst != null ? fst.hashCode() : 0;
        result = 31 * result + (snd != null ? snd.hashCode() : 0);
        return result;
    }
}