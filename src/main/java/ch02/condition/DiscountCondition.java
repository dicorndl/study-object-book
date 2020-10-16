package ch02.condition;

import ch02.Screening;

public interface DiscountCondition {

  boolean canDiscount(Screening screening);
}
