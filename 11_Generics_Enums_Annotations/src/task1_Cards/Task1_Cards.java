package task1_Cards;

public class Task1_Cards {

	public enum CardSuit {
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}
	
	public enum CardRank {
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	}
	
	public static void main(String[] args) {
		for (CardSuit cs: CardSuit.values()) {
			System.out.print(cs + " ");
		}
		System.out.println();
		for (CardRank cr: CardRank.values()) {
			System.out.print(cr + " ");
		}
	}
}
