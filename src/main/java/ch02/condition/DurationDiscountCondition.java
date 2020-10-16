package ch02.condition;

import java.time.DayOfWeek;
import java.time.LocalTime;

import ch02.Screening;

public class DurationDiscountCondition implements DiscountCondition {

  private final DayOfWeek dayOfWeek;
  private final LocalTime start;
  private final LocalTime end;

  public DurationDiscountCondition(DayOfWeek dayOfWeek, LocalTime start, LocalTime end) {
    this.dayOfWeek = dayOfWeek;
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean canDiscount(Screening screening) {
    return screening.isSameDayOfWeek(dayOfWeek) && screening.isBetween(start, end);
  }
}
