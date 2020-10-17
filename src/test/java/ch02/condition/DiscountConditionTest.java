package ch02.condition;

import static org.assertj.core.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import ch02.Screening;

class DiscountConditionTest {

  @Test
  void test_duration_condition() {
    DiscountCondition cond = new DurationDiscountCondition(
        DayOfWeek.SATURDAY,
        LocalTime.of(21, 0),
        LocalTime.of(22, 0));
    assertThat(cond.canDiscount(createScreening())).isTrue();
  }

  @Test
  void test_sequential_condition() {
    DiscountCondition cond = new SequentialDiscountCondition(1);
    assertThat(cond.canDiscount(createScreening())).isTrue();
  }

  private Screening createScreening() {
    return new Screening(
        1,
        LocalDateTime.of(2020, 10, 17, 21, 5),
        null);
  }
}