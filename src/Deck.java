import java.util.Collections;
import java.util.Stack;
import java.util.stream.IntStream;

public class Deck {
    private final Stack<Card> deck;


    private Deck(){
        this.deck = initDeck();
    }
    private Stack<Card> initDeck(){
        final Stack<Card> deckCards = new Stack<>();
        for(final Card.Suit suit : Card.Suit.values()){
            for(final Card.Rank rank : Card.Rank.values()){
                deckCards.push(Card.getCard(rank,suit));

            }
        }
        Collections.shuffle(deckCards);
        return deckCards;
    }

    public Card dealCards(){
        return this.deck.pop();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        final int numCards = 52;
//        for(int i = 0; i<20; i++){
//            deck.dealCards();
//        }
       IntStream.range(0,numCards).forEach(value -> System.out.println(deck.dealCards()));
    }
}
