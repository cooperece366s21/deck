package edu.cooper.ece366;

import edu.cooper.ece366.model.Card;
import edu.cooper.ece366.model.Deck;
import edu.cooper.ece366.model.Hand;
import edu.cooper.ece366.model.User;
import java.util.List;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    // create two users
    User player1 = new User("ethan");
    User player2 = new User("yeet");
    Hand hand1 = new Hand(player1);
    Hand hand2 = new Hand(player2);
    // start game, deal cards
    Deck deck = Deck.newDeck();
    List<Hand> hands = List.of(hand1, hand2);
    int i = 0;
    while (!deck.isEmpty()) {
      hands.get(i++ % 2).getCards().addLast(deck.drawCard());
    }

    // game play
    while (!hand1.getCards().isEmpty() && !hand2.getCards().isEmpty()) {
      Card card1 = hand1.getCards().pop();
      Card card2 = hand2.getCards().pop();
      System.out.println(card1);
      System.out.println(card2);
      if (card1.getDenomination().getValue() > card2.getDenomination().getValue()) {
        hand1.getCards().addLast(card1);
        hand1.getCards().addLast(card2);
      } else if (card1.getDenomination().getValue() < card2.getDenomination().getValue()) {
        hand2.getCards().addLast(card1);
        hand2.getCards().addLast(card2);
      } else {
        // todo: 3 card draw
        // for now, return each card to bottom
        List<Card> pile = List
            .of(hand1.getCards().pop(), hand1.getCards().pop(), hand1.getCards().pop(),
                hand2.getCards().pop(), hand2.getCards().pop(), hand2.getCards().pop());
        // flip card

        hand1.getCards().addLast(card1);
        hand2.getCards().addLast(card2);
      }
//      System.out.println(
//          "hand 1: " + hand1.getCards().size() + " : hand 2: " + hand2.getCards().size());
    }

    // winner
    if (hand1.getCards().isEmpty()) {
      System.out.println(player2 + " wins");
    } else {
      System.out.println(player1 + " wins");
    }
  }
}
