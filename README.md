# Actuarial
A small java program for calculating life annuities and life insurance benefits.

## Example
To calculate the estimated present value of an annuity of $1 in advance for a life now aged 30 while they are alive, with a force of interest of 6% per annum, assuming constant force of mortality of 0.005 per annum.

```java
public class AnnuityExample {

  public static void main(String[] args) {
    CompoundInterest interest = CompoundInterest.fromForceOfInterest(0.06);
    ConstantForceOfMortality mortality = new ConstantForceOfMortality(0.005);

    Annuity annuity = new Annuitiy(interest, mortality);
    double presentValue = annuity.wholeLifeInsurance(30);

    System.out.println("The estimated present value is " + presentValue);
  }

}
```

(_Question from Unimelb ACTL10001 Introduction to Actuarial Studies Tutorial Problems 2015_)

## Class Structure
### `Annuity`
Used to calculate life annuities in (advance/arrear) with given term, interest rates and survival probabilities.

A life annuity is the present value of a recurring payment either at the start (advance) or end (arrear) of the year while a person is alive. The payment value is taken to be 1 and then multiplied by the actual payment amount.

This class supplies the following methods:

Constructors:
- `Annuity(InterestDelegate i, MortalityDelegate mu)`

Instance Methods:
- `Benefit correspondingBenefit()`
- `double wholeLifeInsurance(int age)`
- `double endowmentInsurance(int age, int term)`

### `Benefit`
Used to calculate life insurance benefits given term, interest rates and survival probabilities.

A life insurance benefit is the payment at the death of a policy holder or after the given term is up. For this program the payment will be at _the end of the year of death_. Payment amount is taken as 1 and then multiplied by the actual payment amount.

This class supplies the following methods:

Constructors:
- `Benefit(InterestDelegate i, MortalityDelegate mu)`

Instance Methods:
- `Annuity correspondingAnnuity()`
- `double wholeLifeInsurance(int age)`
- `double endowmentInsurance(int age, int term)`

### `InterestDelegate` << *Interface* >>
A class that will give information on interest rates, discount factors etc.

Must implement the following methods:
- `double discountFactor()`
- `double discountFactor(int time)`

#### `CompoundInterest`
A realisation of the `InterestDelegate` interface for constant compound interest rates.

This class supplies the following methods:

Constructors:
- `CompoundInterest(double effective)`

Static Methods:
- `CompoundInterest fromNominal(double rate, int period)`
- `CompoundInterest fromForceOfInterest(double force)`

Instance Methods:
- `double getEffectiveRate()`
- `double getNominalRate(int period)`
- `double getForceOfInterest()`
- `double discountFactor()`
- `double discountFactor(int time)`

### `MortalityDelegate` << *Interface* >>
A class that will give information on mortality and survival probabilities.

Must implement the following methods:
- `double survivalProbability(int x)`
- `double survivalProbability(int x, int t)`
- `double deathProbability(int x)`
- `double deathProbability(int x, int t)`

#### `ConstantForceOfMortality`
A realisation of the `MortalityDelegate` interface for a constant force of mortality.

The class supplies the following methods:

Constructors
- `ConstantForceOfMortality(double force)`

Instance Methods:
- `double survivalProbability(int x)`
- `double survivalProbability(int x, int t)`
- `double deathProbability(int x)`
- `double deathProbability(int x, int t)`
