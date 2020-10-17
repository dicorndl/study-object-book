package ch02;

public class Reservation {

  private final Screening screening;
  private final int numOfPerson;
  private final int fullMoney;
  private final int purchasedMoney;

  public Reservation(Screening screening, int numOfPerson, int fullMoney, int purchasedMoney) {
    this.screening = screening;
    this.numOfPerson = numOfPerson;
    this.fullMoney = fullMoney;
    this.purchasedMoney = purchasedMoney;
  }

  public String info() {
    return screening.info()
        + "인원 : " + numOfPerson + "\n"
        + "정가 : " + fullMoney + "\n"
        + "결재 금액 : " + purchasedMoney + "\n";
  }
}
