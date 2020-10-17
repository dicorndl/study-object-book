package ch02.policy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

  @Test
  void test_amount_policy() {
    DiscountPolicy policy = new AmountDiscountPolicy(1_000);
    assertThat(policy.getDiscountAmount(10_000)).isEqualTo(1_000);
  }

  @Test
  void test_percent_policy() {
    DiscountPolicy policy = new PercentDiscountPolicy(10);
    assertThat(policy.getDiscountAmount(9_000)).isEqualTo(900);
  }
}