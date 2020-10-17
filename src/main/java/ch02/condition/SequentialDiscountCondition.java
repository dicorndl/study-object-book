package ch02.condition;

import ch02.Screening;

public class SequentialDiscountCondition implements DiscountCondition {

  private final int seq;

  public SequentialDiscountCondition(int seq) {
    if (seq < 1) {
      throw new IllegalArgumentException(seq + " is not allowed for seq");
    }
    this.seq = seq;
  }

  @Override
  public boolean canDiscount(Screening screening) {
    return screening.isSameSeq(seq);
  }
}
