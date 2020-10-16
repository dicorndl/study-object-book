package ch02.policy;

public class PercentDiscountPolicy implements DiscountPolicy {

  private final int percent;

  public PercentDiscountPolicy(int percent) {
    this.percent = percent;
  }

  @Override
  public int getDiscountAmount(int price) {
    return price * (percent / 100);
  }
}
