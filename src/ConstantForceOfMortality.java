/**
 * A realisation of the MortalityDelegate interface for a constant
 * force of mortality.
 *
 * @author Tobias Edwards
 */
public class ConstantForceOfMortality implements MortalityDelegate {
  /** The force of mortality */
  private double force;

  // -- Constructor

  /**
   * Creates a new instance of the class with a given force of MortalityDelegate
   *
   * @param force The constant force of mortality
   */
  public ConstantForceOfMortality(double force) {
    this.force = force;
  }

  // -- MortalityDelegate

  /**
   * Returns the probability that a life aged x will survive for one year.
   *
   * @param x The age of the life in question
   * @return The probability the life survives at least one year
   */
  public double survivalProbability(int x) {
    return Math.exp((-1) * force);
  }

  /**
   * Returns the probability that a life aged x will survive t years.
   *
   * @param x The age of the life in question
   * @param t The number of years for (x) to survive
   * @return The probability the life survives at least t years
   */
  public double survivalProbability(int x, int t) {
    return Math.exp((-1) * force * t);
  }

  /**
   * Returns the probability that a life aged x will die before one year.
   *
   * @param x The age of the life in question
   * @return The probability the life dies before one year
   */
  public double deathProbability(int x) {
    return 1 - survivalProbability(x);
  }

  /**
   * Returns the probability that a life aged x will die before t years.
   *
   * @param x The age of the life in question
   * @param t The number of years for (x) to die before
   * @return The probability the life dies before t years
   */
  public double deathProbability(int x, int t) {
    return 1 - survivalProbability(x, t);
  }
}
