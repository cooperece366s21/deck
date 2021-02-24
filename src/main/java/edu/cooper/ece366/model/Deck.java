package edu.cooper.ece366.model;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Deck {

  private final Deque<Card> cards;

  private Deck() {
    this.cards = initCards();
  }

  public static Deck newDeck() {
    return new Deck();
  }

  public Card drawCard() {
    if (cards.size() > 0) {
      return cards.pop();
    } else {
      return null;
    }
  }

  public void placeCard(Card card) {
    cards.addLast(card);
  }

  public boolean isEmpty() {
    return cards.isEmpty();
  }

  private static Deque<Card> initCards() {
    List<Card> cards = Arrays.asList(Denomination.values()).stream()
        .flatMap(
            denomination ->
                Arrays.asList(Suit.values()).stream().map(suit -> new Card(denomination, suit)))
        .collect(Collectors.toList());
    Random rnd = ThreadLocalRandom.current();
    for (int i = cards.size() - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      Card a = cards.get(index);
      cards.set(index, cards.get(i));
      cards.set(i, a);
    }
    return new ArrayDeque<>(cards);
  }
}
