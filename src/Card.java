import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private final Rank rank;
    private final Suit suit;

    private final static Map<String, Card> map = cardMap();


    private static Map<String,Card> cardMap() {
        final Map<String,Card> map = new HashMap<>();
        for(final Suit suit : Suit.values()){
            for(final Rank rank : Rank.values()){
                map.put(keysOfCard(rank,suit) , new Card(rank,suit));

            }
        }
        return Collections.unmodifiableMap(map);
    }

    private static String keysOfCard(Rank rank, Suit suit) {
        return rank + " of " + suit;
    }

    public static Card getCard(Rank rank, Suit suit) {
        final Card c = map.get(keysOfCard(rank,suit));

        if(c != null){
            return c;
        }
        throw new RuntimeException("Not valid suit");

       // return map.get(keysOfCard(rank,suit));
    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    private Card(final Rank rank, final Suit suit){
        this.rank = rank;
        this.suit = suit;

    }
    enum Suit{
        DIAMONDS,
        CLUBS,
        HEARTS,
        SPADES
    }

    enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final int rank;
        Rank(final int rank){
            this.rank = rank;
        }
    }
}
