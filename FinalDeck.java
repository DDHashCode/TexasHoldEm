import java.util.ArrayList;
import java.util.Comparator;

public class FinalDeck {
    private ArrayList<Card> cards;
    private Player player;


    public FinalDeck(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
        this.cards.addAll(player.getPlayerCards());
        sortRanks();
        System.out.println(this.cards.toString());
        System.out.println("Has nothing: " + hasNothing());
        System.out.println("pair: " + hasPair());
        System.out.println("three: " + hasThree());
        System.out.println("Full: " + hasFull());

    }

    private void sortColors(){
        this.cards.sort(Comparator.comparing(Card::getColour));
        }

    private void sortRanks() {
        this.cards.sort(Comparator.comparing(Card::getRank));
    }

    public boolean hasPair() {
        ArrayList<Card> temp = new ArrayList<>(this.cards);
        Card tempCard = temp.get(0);
        int counter = 1;
        for(int i = 1 ; i < temp.size() ; i++){
            if (counter == 2) break;
            //System.out.println(temp.get(i).getRank());
            if(tempCard.getRank().equals(temp.get(i).getRank())) counter++;
            if(!tempCard.getRank().equals(temp.get(i).getRank())) {
                tempCard = temp.get(i);
                counter = 1;
            }
        }
        return counter >=2;
        }
    public boolean hasThree() {
        ArrayList<Card> temp = new ArrayList<>(this.cards);
        Card tempCard = temp.get(0);
        int counter = 1;
        for(int i = 1 ; i < temp.size() ; i++){
            if (counter == 3) break;
            if(tempCard.getRank().equals(temp.get(i).getRank())) counter++;
            if(!tempCard.getRank().equals(temp.get(i).getRank())) {
                tempCard = temp.get(i);
                counter = 1;
            }
        }
        return counter == 3;
    }

    public boolean hasFull() {
        return hasPair() && hasThree();
    }

    public boolean hasNothing() {
        return !hasPair();
    }


    }

