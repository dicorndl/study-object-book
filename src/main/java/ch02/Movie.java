package ch02;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import ch02.condition.DiscountCondition;
import ch02.policy.DiscountPolicy;

public class Movie {

  private final String title;
  private final Duration runningTime;
  private final int price;
  private final DiscountPolicy discountPolicy;
  private final List<DiscountCondition> discountConditions;

  public Movie(String title, Duration runningTime, int price,
               DiscountPolicy discountPolicy,
               List<DiscountCondition> discountConditions) {
    this.title = title;
    this.runningTime = runningTime;
    this.price = price;
    this.discountPolicy = discountPolicy;
    this.discountConditions = discountConditions;
  }

  public int calculateDiscountedPrice(final Screening screening, final int numOfPerson) {
    int calculatedPrice = price;
    if (checkDiscountCondition(screening)) {
      calculatedPrice = price - discountPolicy.getDiscountAmount(price);
    }

    return calculatedPrice * numOfPerson;
  }

  private boolean checkDiscountCondition(final Screening screening) {
    return discountConditions.stream()
        .anyMatch(condition -> condition.canDiscount(screening));
  }

  public String getTitle() {
    return title;
  }

  public LocalDateTime getEndTime(final LocalDateTime startAt) {
    return startAt.plus(runningTime);
  }

  public int calculateFullMoney(final int numOfPerson) {
    return price * numOfPerson;
  }
}
