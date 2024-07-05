class Rational {
    private int numerator;
    private int denominator;

    Rational(final int numerator, final int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }

    Rational add(Rational that) {
        int newNumerator = this.numerator * that.denominator + that.numerator * this.denominator;
        int newDenominator = this.denominator * that.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    Rational subtract(Rational that) {
        int newNumerator = this.numerator * that.denominator - that.numerator * this.denominator;
        int newDenominator = this.denominator * that.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    Rational multiply(Rational that) {
        int newNumerator = this.numerator * that.numerator;
        int newDenominator = this.denominator * that.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    Rational divide(Rational that) {
        if (that.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        int newNumerator = this.numerator * that.denominator;
        int newDenominator = this.denominator * that.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    Rational abs() {
        return new Rational(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    Rational pow(int n) {
        if (n >= 0) {
            return new Rational((int) Math.pow(this.numerator, n), (int) Math.pow(this.denominator, n));
        } else {
            int absN = Math.abs(n);
            return new Rational((int) Math.pow(this.denominator, absN), (int) Math.pow(this.numerator, absN));
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
                && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();
        return result;
    }
}
