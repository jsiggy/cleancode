package com.siggy.training.code.smells.loan;

import java.util.Date;

public class Loan {
    private final CapitalStrategy capitalStrategy;
    private final double commitment;
    private final double outstanding;
    private final int customerRating;
    private final Date maturity;
    private final Date expiry;

    public Loan(double commitment, int riskRating, Date maturity, Date expiry) {
        this(commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(double commitment, double outstanding, int customerRating, Date maturity, Date expiry) {
        this(null, commitment, outstanding, customerRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, int riskRating, Date maturity, Date expiry) {
        this(capitalStrategy, commitment, 0.00, riskRating, maturity, expiry);
    }

    public Loan(CapitalStrategy capitalStrategy, double commitment, double outstanding, int customerRating, Date maturity, Date expiry) {
        this.capitalStrategy = capitalStrategy;
        this.commitment = commitment;
        this.outstanding = outstanding;
        this.customerRating = customerRating;
        this.maturity = maturity;
        this.expiry = expiry;
    }

    public double capital() {
        if (expiry == null && maturity != null)
            return commitment * duration() * riskFactor();
        if (expiry != null && maturity == null) {
            if (getUnusedPercentage() != 1.0)
                return commitment * getUnusedPercentage() * duration() * riskFactor();
            else
                return (outstandingRiskAmount() * duration() * riskFactor())
                        + (unusedRiskAmount() * duration() * unusedRiskFactor());
        }

        return 0.0;
    }

    // ignore below here
    private double unusedRiskFactor() {
        return 3.45;
    }

    private double unusedRiskAmount() {
        return 2.15;
    }
    private double outstandingRiskAmount() {
        return 6.55;
    }

    private double getUnusedPercentage() {
        return 0.18;
    }

    private double duration() {
        return 10.0;
    }

    private double riskFactor() {
        return 0.54;
    }

    public static void main(String[] args) {
        System.out.println("Loan capital: " + new Loan(new CapitalStrategy(), 0.5, 1, new Date(), new Date()).capital());
    }
}
