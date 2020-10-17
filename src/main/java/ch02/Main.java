package ch02;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import ch02.condition.DiscountCondition;
import ch02.condition.SequentialDiscountCondition;
import ch02.policy.DiscountPolicy;
import ch02.policy.PercentDiscountPolicy;

public class Main {

  public static void main(String[] args) {
    DiscountCondition discountCond = new SequentialDiscountCondition(1);
    DiscountPolicy discountPolicy = new PercentDiscountPolicy(99);

    Movie movie = new Movie(
        "매우 재미있는 영화",
        Duration.ofMinutes(120),
        12_000,
        discountPolicy,
        Collections.singletonList(discountCond));
    Screening screening = new Screening(1, LocalDateTime.now(), movie);
    Reservation reservation = screening.reserve(10);

    System.out.println(reservation.info());
  }
}
