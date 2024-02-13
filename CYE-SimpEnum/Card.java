// CYE-SimpEnum/Card.java
 
public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }

    public static Card getHigher(Card c1, Card c2) {
        if      (c1.rank.ordinal() > c2.rank.ordinal())
            return c1;
        else if (c1.rank.ordinal() < c2.rank.ordinal())
            return c2;
        else if (c1.suit.ordinal() > c2.suit.ordinal())
            return c1;
        else
            return c2;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
