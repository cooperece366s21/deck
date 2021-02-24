package edu.cooper.ece366.model;

import static edu.cooper.ece366.model.Suit.Color.BLACK;
import static edu.cooper.ece366.model.Suit.Color.RED;

public enum Suit {
  SPADES(BLACK),
  HEARTS(RED),
  CLUBS(BLACK),
  DIAMONDS(RED);

  private final Color color;

  Suit(final Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  enum Color {
    BLACK,
    RED
  }
}
