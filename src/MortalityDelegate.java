/**
 * Gives information of mortality and survival probabilities.
 *
 * @author Tobias Edwards
 */
public interface MortalityDelegate {
  /**
   * Returns the probability that a life aged x will survive for one year.
   *
   * @param x The age of the life in question
   * @return The probability the life survives at least one year
   */
  public double survivalProbability(int x);

  /**
   * Returns the probability that a life aged x will survive t years.
   *
   * @param x The age of the life in question
   * @param t The number of years for (x) to survive
   * @return The probability the life survives at least t years
   */
  public double survivalProbability(int x, int t);

  /**
   * Returns the probability that a life aged x will die before one year.
   *
   * @param x The age of the life in question
   * @return The probability the life dies before one year
   */
  public double deathProbability(int x);

  /**
   * Returns the probability that a life aged x will die before t years.
   *
   * @param x The age of the life in question
   * @param t The number of years for (x) to die before
   * @return The probability the life dies before t years
   */
  public double deathProbability(int x, int t);
}
