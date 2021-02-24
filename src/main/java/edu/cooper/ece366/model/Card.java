package edu.cooper.ece366.model;

public class Card {

  private final Denomination denomination;
  private final Suit suit;

  public Card(Denomination denomination, Suit suit) {
    this.denomination = denomination;
    this.suit = suit;
  }

  public Denomination getDenomination() {
    return denomination;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return String.format("%s of %s", denomination, suit);
  }
}
