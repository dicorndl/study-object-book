package ch02;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Screening {

  private final int seq;
  private final LocalDateTime startAt;
  private final Movie movie;

  public Screening(int seq, LocalDateTime startAt, Movie movie) {
    this.seq = seq;
    this.startAt = startAt;
    this.movie = movie;
  }

  public Reservation reserve(final int numOfPerson) {
    return new Reservation(
        this,
        numOfPerson,
        movie.calculateFullMoney(numOfPerson),
        movie.calculateDiscountedPrice(this, numOfPerson)
    );
  }

  public boolean isSameSeq(final int seq) {
    return this.seq == seq;
  }

  public boolean isSameDayOfWeek(final DayOfWeek dayOfWeek) {
    return startAt.getDayOfWeek().equals(dayOfWeek);
  }

  public boolean isBetween(final LocalTime start, final LocalTime end) {
    final LocalTime startTime = startAt.toLocalTime();
    return (startTime.equals(start) || startTime.isAfter(start))
        && (startTime.equals(end) || startTime.isBefore(end));
  }

  public String info() {
    return "제목 : " + movie.getTitle() + "\n"
        + "상영정보 : " + startAt.toLocalDate() + " "
        + seq + "회 " + startAt.toLocalTime() + " ~ " + movie.endAt(startAt).toLocalTime() + "\n";
  }
}
