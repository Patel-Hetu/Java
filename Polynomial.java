import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial> {

    private final int[] coeff;

    public Polynomial(int[] coefficients) {
        int degree = coefficients.length - 1;
        while (degree >= 0 && coefficients[degree] == 0) {
            degree--; // Ignore leading zeros
        }
        if (degree < 0) {
            degree = 0; // At least degree 0
        }
        coeff = new int[degree + 1];
        System.arraycopy(coefficients, 0, coeff, 0, degree + 1);
    }

    public int getDegree() {
        return coeff.length - 1;
    }

    public int getCoefficient(int k) {
        if (k < 0 || k >= coeff.length) {
            return 0;
        }
        return coeff[k];
    }

    public long evaluate(int x) {
        long result = 0;
        long powerX = 1;
        for (int i = 0; i < coeff.length; i++) {
            result += (coeff[i] * powerX);
            powerX *= x;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeff.length - 1; i >= 0; i--) {
            if (coeff[i] != 0) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (i > 0) {
                    sb.append(coeff[i]).append("x^").append(i);
                } else {
                    sb.append(coeff[i]);
                }
            }
        }
        return sb.toString();
    }

    public Polynomial add(Polynomial other) {
        int maxLength = Math.max(coeff.length, other.coeff.length);
        int[] resultCoeff = new int[maxLength];
        for (int i = 0; i < coeff.length; i++) {
            resultCoeff[i] += coeff[i];
        }
        for (int i = 0; i < other.coeff.length; i++) {
            resultCoeff[i] += other.coeff[i];
        }
        return new Polynomial(resultCoeff);
    }

    public Polynomial multiply(Polynomial other) {
        int resultDegree = this.getDegree() + other.getDegree();
        int[] resultCoeff = new int[resultDegree + 1];
        for (int i = 0; i < coeff.length; i++) {
            for (int j = 0; j < other.coeff.length; j++) {
                resultCoeff[i + j] += coeff[i] * other.coeff[j];
            }
        }
        return new Polynomial(resultCoeff);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Polynomial)) {
            return false;
        }
        Polynomial otherPoly = (Polynomial) other;
        if (this.getDegree() != otherPoly.getDegree()) {
            return false;
        }
        for (int i = 0; i < coeff.length; i++) {
            if (coeff[i] != otherPoly.coeff[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Polynomial other) {
        int thisDegree = this.getDegree();
        int otherDegree = other.getDegree();
        if (thisDegree < otherDegree) {
            return -1;
        } else if (thisDegree > otherDegree) {
            return 1;
        } else {
            // Loop through coefficients starting from the highest degree
            for (int i = thisDegree; i >= 0; i--) {
                if (this.coeff[i] < other.coeff[i]) {
                    return -1;
                } else if (this.coeff[i] > other.coeff[i]) {
                    return 1;
                }
            }
            return 0; // The polynomials are equal
        }
    }

    // You may leave this hashCode method as-is
    @Override
    public int hashCode() {
        return Arrays.hashCode(coeff);
    }
}
