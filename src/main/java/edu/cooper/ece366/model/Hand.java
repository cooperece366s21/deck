package edu.cooper.ece366.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Hand {

  private final User user;
  private final Deque<Card> cards;

  public Hand(final User user) {
    this.user = user;
    this.cards = new ArrayDeque<>();
  }

  public Hand(final User user, final Deque<Card> cards) {
    this.user = user;
    this.cards = cards;
  }

  public User getUser() {
    return user;
  }

  public Deque<Card> getCards() {
    return cards;
  }
}
