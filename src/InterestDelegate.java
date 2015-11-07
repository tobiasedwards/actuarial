/**
 * Gives information on interest rates, discount factors etc.
 *
 * @author Tobias Edwards
 */
public interface InterestDelegate {
  /**
   * Returns the discount factor over a period of one year.
   *
   * @return Discount factor for one year
   */
  public double discountFactor();

  /**
   * Returns the discount factor over a specified time period.
   *
   * @param time Number of years to be discounted over
   * @return Discount factor for given time period
   */
  public double discountFactor(int time);
}
