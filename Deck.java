import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private int maxCardsInDeck;
    private int cardsInDeck;
    private ArrayList<Card> cardDeck;
    private Stack<Card> deckStack = new Stack<>();


    public Deck() {
        this.maxCardsInDeck = 52;
        this.cardsInDeck = 0;
        for (int rank = 0 ; rank < CardRank.values().length ; rank++){
            for(int color = 0 ; color < Colour.values().length; color++){
                cardDeck.add(new Card(CardRank.values()[rank], Colour.values()[color]));
                cardsInDeck++;
            }
        }
        this.cardDeck = tossCardDeck();
        this.deckStack.addAll(cardDeck);
    }

    public ArrayList<Card> getCardDeck() {
        return cardDeck;
    }

    public void printCardDeck(){
        for( int i = 0 ; i < cardDeck.size() ; i++){
            System.out.println(cardDeck.get(i));
        }

    }

    private ArrayList<Card> tossCardDeck() {
        ArrayList<Card> tempDeck = new ArrayList<>(cardDeck);
        Collections.shuffle(tempDeck);
        return tempDeck;
    }

    public void printCardStack() {
        for (int i = 1 ; i < deckStack.size() + 1; i++){
            System.out.println(deckStack.elementAt(i));
        }
    }


}
