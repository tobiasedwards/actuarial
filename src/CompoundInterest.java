/**
 * A realisation of the InterestDelegate interface for constant compound
 * interest rates.
 *
 * @author Tobias Edwards
 */
public class CompoundInterest implements InterestDelegate {
  /** The effective rate of interest per annum */
  private double effective;

  /**
   * Creates an instance of CompoundInterest with a given effective rate of
   * interest.
   *
   * @param effective The effective rate of interest per annum (eg. 0.05 is 5%)
   */
  public CompoundInterest(double effective) {
    this.effective = effective;
  }
}
