// CYE-SimpEnum/Main.java
 
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Suits:");
        for (Suit s : Suit.values())
            System.out.print(" " + s );
        System.out.print("\nRanks:");
        for (Rank r : Rank.values())
            System.out.print(" " + r);
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("1. rank -> ");
        String r1 = scan.next().toUpperCase();
        System.out.print("1. suit -> ");
        String s1 = scan.next().toUpperCase();
        System.out.print("2. rank -> ");
        String r2 = scan.next().toUpperCase();
        System.out.print("2. suit -> ");
        String s2 = scan.next().toUpperCase();

        Rank rank1 = Rank.valueOf(r1);
        Suit suit1 = Suit.valueOf(s1);
        Rank rank2 = Rank.valueOf(r2);
        Suit suit2 = Suit.valueOf(s2);

        Card card1 = new Card(rank1,suit1);
        Card card2 = new Card(rank2,suit2);

        Card higher = Card.getHigher(card1,card2);
        System.out.println("Card1 = " + card1 +
                         ", Card2 = " + card2 +
                      "\nHigher card: " + higher);
    }
}
