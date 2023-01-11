package chapter_01;

import java.util.Objects;

/**
 * 有理数
 */
public class E_1_2_16_Rational {
    public static void main(String[] args) {
        Rational a = new Rational(15, 30);
        Rational b = new Rational(40, 60);
        Rational c = a.plus(b);
        System.out.println(c);
        c = a.minus(b);
        System.out.println(c);
        c = a.times(b);
        System.out.println(c);
        c = a.divides(b);
        System.out.println(c);

        Rational d = new Rational(60, 80);
        System.out.println(c.equals(d));
    }

    private static class Rational {
        private final long numerator;
        private final long denominator;

        public Rational(long numerator, long denominator) {
            long g = gcd(numerator, denominator);
            this.numerator = numerator / g;
            this.denominator = denominator / g;
        }


        public Rational plus(Rational b) {
            long numerator = this.numerator * b.denominator + b.numerator * this.denominator;
            long denominator = this.denominator * b.denominator;
            return new Rational(numerator, denominator);
        }

        public Rational minus(Rational b) {
            long numerator = this.numerator * b.denominator - b.numerator * this.denominator;
            long denominator = this.denominator * b.denominator;
            return new Rational(numerator, denominator);
        }

        public Rational times(Rational b) {
            long numerator = this.numerator * b.numerator;
            long denominator = this.denominator * b.denominator;
            return new Rational(numerator, denominator);
        }

        public Rational divides(Rational b) {
            long numerator = this.numerator * b.denominator;
            long denominator = this.denominator * b.numerator;
            return new Rational(numerator, denominator);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Rational)) return false;
            Rational r = (Rational) o;
            return numerator == r.numerator && denominator == r.denominator;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }

        private long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}