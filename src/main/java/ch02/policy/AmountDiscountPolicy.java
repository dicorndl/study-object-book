package ch02.policy;

public class AmountDiscountPolicy implements DiscountPolicy {

  private final int discountAmount;

  public AmountDiscountPolicy(int discountAmount) {
    this.discountAmount = discountAmount;
  }

  @Override
  public int getDiscountAmount(int price) {
    return discountAmount;
  }
}
