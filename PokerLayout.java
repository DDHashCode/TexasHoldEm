import java.util.ArrayList;

public enum PokerLayout {
    HIGH_CARD(1),
    PAIR(2),
    TWO_PAIRS(3),
    THREE(4),
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    QUADS(8),
    STRAIGHT_FLUSH(8),
    ROYAL_FLUSH(10);

    int number;


    private PokerLayout(int numer) {
        this.number = numer;
    }

    public PokerLayout Figure(ArrayList<Card> cardsInHand, ArrayList<Card> CardsOnTable){

    }

    public boolean isBiggerThan(PokerLayout check){
        return (this.number > check.number);
    }
}
