package edu.cooper.ece366.model;

public class GameCard {

  private final Card card;
  private boolean isFaceUp;

  public GameCard(final Card card) {
    this.card = card;
    this.isFaceUp = false;
  }

  public GameCard(final Card card, final boolean isFaceUp) {
    this.card = card;
    this.isFaceUp = isFaceUp;
  }

  public Card getCard() {
    return card;
  }

  public boolean isFaceUp() {
    return isFaceUp;
  }

  public void setFaceUp(boolean isFaceUp) {
    this.isFaceUp = isFaceUp;
  }
}
