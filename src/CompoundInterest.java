/**
 * A realisation of the InterestDelegate interface for constant compound
 * interest rates.
 *
 * @author Tobias Edwards
 */
public class CompoundInterest implements InterestDelegate {
  /** The effective rate of interest per annum */
  private double effective;

  // -- Object Creation

  /**
   * Creates an instance of CompoundInterest with a given effective rate of
   * interest.
   *
   * @param effective The effective rate of interest per annum (eg. 0.05 is 5%)
   */
  public CompoundInterest(double effective) {
    this.effective = effective;
  }

  /**
   * Creates and returns an instance of CompoundInterest with
   * a given nominal rate of interest, compounding
   * period times a year.
   *
   * @param rate The interest rate per annum as a fraction
   *   of 1
   * @param period The number of compounding time periods
   *   in a year
   * @return A new instance of CompoundInterest with
   *   appropriate rates
   */
  public static CompoundInterest fromNominal(double rate, int period) {
    // TODO Deal with negative period/rate's (i.e. throw exceptions)
    double effective = Math.pow(1 + rate / period, period) - 1;
    return new CompoundInterest(effective);
  }

  /**
   * Creates and returns an instance of CompoundInterest from a given
   * force of interest.
   *
   * @param force The force of interest as a fraction of 1
   * @return A new instance of CompoundInterest with appropriate rates
   */
  public static CompoundInterest fromForceOfInterest(double force) {
    double effective = Math.exp(force) - 1;
    return new CompoundInterest(effective);
  }

  // -- Accessors

  /**
   * Returns the effective rate of interest per annum.
   *
   * @return Effective rate of interest p.a. as a fraction of 1
   */
  public double getEffectiveRate() {
    return effective;
  }

  /**
   * Returns the nominal rate of interest, compoundning period times
   * a year.
   *
   * @return Nominal rate of interest compounding period times per year
   */
  public double getNominalRate(int period) {
    // TODO Validate period is > 0
    return period * (Math.pow(1 + effective, 1 / (double) period) - 1);
  }

  /**
   * Returns the force of interest per annum.
   *
   * @return The force of interest per annum as a fraction of 1.
   */
  public double getForceOfInterest() {
    return Math.log(1 + effective);
  }

  // -- InterestDelegate

  /**
   * Returns the discount factor over a period of one year.
   *
   * @return Discount factor for one year
   */
  public double discountFactor() {
    return 1.0 / (1 + effective);
  }

  /**
   * Returns the discount factor over a specified time period.
   *
   * @param time Number of years to be discounted over
   * @return Discount factor for given time period
   */
  public double discountFactor(int time) {
    return Math.pow(1 + effective, -time);
  }
}
