package ca.qc.vc.week2.lesson4;

class Rational extends Number implements Comparable<Rational> {

    private final long numerator;
    private final long denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(long numerator) {
        this(numerator, 1);
    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        // Keep denominator positive
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        long gcd = gcd(numerator, denominator);

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a == 0 ? 1 : a;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational other) {
        long newNumerator =
                numerator * other.denominator
                        + denominator * other.numerator;

        long newDenominator = denominator * other.denominator;

        return new Rational(newNumerator, newDenominator);
    }

    public Rational subtract(Rational other) {
        long newNumerator =
                numerator * other.denominator
                        - denominator * other.numerator;

        long newDenominator = denominator * other.denominator;

        return new Rational(newNumerator, newDenominator);
    }

    public Rational multiply(Rational other) {
        return new Rational(
                numerator * other.numerator,
                denominator * other.denominator
        );
    }

    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        return new Rational(
                numerator * other.denominator,
                denominator * other.numerator
        );
    }

    @Override
    public int compareTo(Rational other) {
        long left = numerator * other.denominator;
        long right = denominator * other.numerator;

        return Long.compare(left, right);
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        return numerator + "/" + denominator;
    }
}

class RationalMatrix extends GenericMatrix<Rational> {
    @Override /** Add two rational numbers */
    protected Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }

    @Override /** Multiply two rational numbers */
    protected Rational multiply(Rational r1, Rational r2) {
        return r1.multiply(r2);
    }

    @Override /** Specify zero for a Rational number */
    protected Rational zero() {
        return new Rational(0, 1);
    }
}

public class TestRationalMatrix {
    public static void main(String[] args) {
        // Create two Rational arrays m1 and m2
        Rational[][] m1 = new Rational[3][3];
        Rational[][] m2 = new Rational[3][3];
        for (int i = 0; i < m1.length; i++)
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] = new Rational(i + 1, j + 5);
                m2[i][j] = new Rational(i + 1, j + 6);
            }

        // Create an instance of RationalMatrix
        RationalMatrix rationalMatrix = new RationalMatrix();

        System.out.println("\nm1 + m2 is ");
        GenericMatrix.printResult(
                m1, m2, rationalMatrix.addMatrix(m1, m2), '+');

        System.out.println("\nm1 * m2 is ");
        GenericMatrix.printResult(
                m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
    }
}