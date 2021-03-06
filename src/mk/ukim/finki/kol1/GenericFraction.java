package mk.ukim.finki.kol1;

class GenericFraction<T extends Number, U extends Number> {
    private T numerator;
    private U denominator;

    public GenericFraction(T numerator, U denominator) throws ZeroDenominatorException {
        this.numerator = numerator;
        if (denominator.equals(0))
            throw new ZeroDenominatorException("Denominator cannot be zero");
        this.denominator = denominator;
    }

    private static int GCD(Number n1, Number n2) {
        if (n2.intValue() == 0)
            return n1.intValue();
        return GCD(n2.intValue(), n1.intValue() % n2.intValue());
    }

    public GenericFraction<Double, Double> add(GenericFraction<? extends Number, ? extends Number> gf) throws ZeroDenominatorException {
        int LCM = (this.denominator.intValue() * gf.denominator.intValue()) / GCD(this.denominator, gf.denominator);
        return new GenericFraction<>(this.numerator.doubleValue() * (LCM / this.denominator.intValue()) +
                gf.numerator.doubleValue() * (LCM / gf.denominator.intValue()), this.denominator.doubleValue() *
                (LCM / this.denominator.intValue()));
    }

    public double toDouble() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    private GenericFraction<Double, Double> simplify() throws ZeroDenominatorException {
        int GCD = GCD(this.numerator, this.denominator);
        if (this.numerator.intValue() == GCD && this.denominator.intValue() == GCD)
            return new GenericFraction<>(this.numerator.doubleValue(), this.denominator.doubleValue());
        else if (this.numerator.intValue() == GCD)
            return new GenericFraction<>(this.numerator.doubleValue(), this.denominator.doubleValue() / GCD);
        else if (this.denominator.intValue() == GCD)
            return new GenericFraction<>(this.numerator.doubleValue() / GCD, this.denominator.doubleValue());
        else
            return new GenericFraction<>(this.numerator.doubleValue() / GCD, this.denominator.doubleValue() / GCD);
    }

    @Override
    public String toString() {
        GenericFraction<Double, Double> simplified = null;
        try {
            simplified = simplify();
            return String.format("%.2f / %.2f", simplified.numerator, simplified.denominator);
        } catch (ZeroDenominatorException e) {
            return e.getMessage();
        }
    }
}
