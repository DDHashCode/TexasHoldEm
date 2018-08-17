import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FinalDeck {
    private ArrayList<Card> cards;
    private Player player;


    public FinalDeck(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
        this.cards.addAll(player.getPlayerCards());
        sortRanks();
        System.out.println(this.cards.toString());
        //System.out.println("Has HIGH: " + hasHigh());
        System.out.println("pair: " + hasPair(this.cards));
        System.out.println("three: " + hasThree(this.cards));
        System.out.println("Full: " + hasFull(this.cards));
        System.out.println("two pairs: " + hastwoPairs(this.cards));
        //System.out.println("Has Streigh: " + hasStreigh(this.cards));
        //System.out.println("Has Color: " + hasColour(this.cards));
        System.out.println("Has Quads: " + hasQuads(this.cards));
        //System.out.println("Has Poker: " + hasPoker(this.cards));
        System.out.println(showPair(this.cards));
        System.out.println(showThree(this.cards));
        System.out.println(showTwoPairs(this.cards));
        System.out.println(showFull(this.cards));
        System.out.println(showQuads(this.cards));
        showStreigh(this.cards);


    }

    private void sortColors(){
        this.cards.sort(Comparator.comparing(Card::getColour));
        }

    private void sortRanks() {
        this.cards.sort(Comparator.comparing(Card::getRank));
    }

    public boolean hasPair(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
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
        return counter ==2;
        }
    public boolean hasThree(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
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

    public boolean hasFull(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        Card tempCard = temp.get(0);
        Card pairCard = tempCard;
        int counter = 1;
        for(int i = 1 ; i < temp.size() ; i++){
            if (counter == 2) break;
            //System.out.println(temp.get(i).getRank());
            if(tempCard.getRank().equals(temp.get(i).getRank())){
                counter++;
                pairCard = temp.get(i);
            }
            if(!tempCard.getRank().equals(temp.get(i).getRank())) {
                tempCard = temp.get(i);
                counter = 1;
            }
        }
        temp.remove(tempCard);
        try{
            temp.remove(pairCard);
        }   finally {       }


        return counter==2 && hasThree(temp);
    }

    public boolean hasHigh() {
        return !hasPair(this.cards);
    }

    public boolean hastwoPairs(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        Card tempCard = temp.get(0);
        Card pairCard = tempCard;
        int counter = 1;
        for(int i = 1 ; i < temp.size() ; i++){
            if (counter == 2) break;
            //System.out.println(temp.get(i).getRank());
            if(tempCard.getRank().equals(temp.get(i).getRank())){
                counter++;
                pairCard = temp.get(i);
            }
            if(!tempCard.getRank().equals(temp.get(i).getRank())) {
                tempCard = temp.get(i);
                counter = 1;
            }
        }
        temp.remove(tempCard);
        try{
            temp.remove(pairCard);
        }   finally {       }


            return counter==2 && hasPair(temp);
    }

    public boolean areNeighbours(int first, int second) {
        return first - second == 1 || first - second == -1;
    }

    public boolean hasStreigh(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        int check = 0;
        int checker = temp.get(0).getRank().number;
        for(int i = 0 ; i < temp.size() ; i++ ) {
            if(check == 4) break;
            if (areNeighbours(checker, temp.get(i).getRank().number)){
                check++;
                checker = temp.get(i).getRank().number;
            } else checker = temp.get(i).getRank().number;
        }
        return check == 4;
    }

    public boolean hasColour(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        temp.sort(Comparator.comparing(Card::getColour));
        int counter = 0;
        Colour tempColour = temp.get(0).getColour();
        for ( int i = 0 ; i < temp.size() ; i++ ){
            //System.out.println(temp.get(i).getColour());
            if( counter == 4) break;
            if(tempColour.equals(temp.get(i).getColour())){
                counter++;
                tempColour = temp.get(i).getColour();
            } else tempColour = temp.get(i).getColour();
        }

        return counter == 4;
    }

    public boolean hasQuads(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        int counter = 0;
        CardRank tempRank = temp.get(0).getRank();
        for ( int i = 0 ; i < temp.size() ; i++){
            if(counter == 4) break;
            if(tempRank.equals(temp.get(i).getRank())){
                counter++;
                tempRank = temp.get(i).getRank();
            } else if(!tempRank.equals(temp.get(i).getRank()) && counter > 1 && counter < 4) counter = 0;
            else tempRank = temp.get(i).getRank();
        }
        return counter == 4;
    }

    public boolean hasPoker(ArrayList<Card> cards) {
        ArrayList<Card> temp = new ArrayList<>(cards);
        temp.sort(Comparator.comparing(Card::getColour));
        int counter = 0;
        Colour tempColour = temp.get(0).getColour();
        for ( int i = 0 ; i < temp.size() ; i++ ){
            System.out.println(temp.get(i).getRank() + " " + temp.get(i).getColour() + "  " + counter);
            if(tempColour.equals(temp.get(i).getColour())){
                if( counter < 4) counter++;
                tempColour = temp.get(i).getColour();
            } else tempColour = temp.get(i).getColour();
        }

        return counter == 4 && hasStreigh(temp);

    }

    public ArrayList<Card> showPair(ArrayList<Card> cards){
        cards.sort(Comparator.comparing(Card::getRank));
        ArrayList<Card> outputDeck = new ArrayList<>();
        ArrayList<Card> tempDeck = new ArrayList<>(cards);
        for (int i = 0 ; i < tempDeck.size()-1; i++){
              if(tempDeck.get(i).getRank().equals(tempDeck.get(i+1).getRank())) {
                  outputDeck.add(tempDeck.get(i));
                  outputDeck.add(tempDeck.get(i+1));
                  break;
          }
        }
        return outputDeck;
    }

    public ArrayList<Card> showThree(ArrayList<Card> cards){
        cards.sort(Comparator.comparing(Card::getRank));
        ArrayList<Card> outputDeck = new ArrayList<>();
        ArrayList<Card> tempDeck = new ArrayList<>(cards);
        for (int i = 0 ; i < tempDeck.size()-2; i++){
            if(tempDeck.get(i).getRank().equals(tempDeck.get(i+1).getRank()) && tempDeck.get(i).getRank().equals(tempDeck.get(i+2).getRank())) {
                outputDeck.add(tempDeck.get(i));
                outputDeck.add(tempDeck.get(i+1));
                outputDeck.add(tempDeck.get(i+2));
                break;
            }
        }
        return  outputDeck;
    }

    public ArrayList<Card> showTwoPairs(ArrayList<Card> cards){
        cards.sort(Comparator.comparing(Card::getRank));
        ArrayList<Card> outputDeck = new ArrayList<>();
        ArrayList<Card> tempDeck = new ArrayList<>();
        for (int i = 0 ; i < cards.size()-1; i++){
            if(cards.get(i).getRank().equals(cards.get(i+1).getRank())) {
                outputDeck.add(cards.get(i));
                outputDeck.add(cards.get(i+1));
                break;
            }
        }
        tempDeck.addAll(cards);
        tempDeck.removeAll(outputDeck);
        outputDeck.addAll(showPair(tempDeck));
        return outputDeck;
    }

    public ArrayList<Card> showFull(ArrayList<Card> cards) {
        ArrayList<Card> outputDeck = new ArrayList<>(showPair(cards));
        ArrayList<Card> tempDeck = new ArrayList<>(cards);
        tempDeck.removeAll(outputDeck);
        outputDeck.addAll(showThree(tempDeck));
        return outputDeck;
    }

    public ArrayList<Card> showQuads(ArrayList<Card> cards) {
        cards.sort(Comparator.comparing(Card::getRank));
        ArrayList<Card> tempDeck = new ArrayList<>(cards);
        ArrayList<Card> outputDeck = new ArrayList<>();
        for (int i = 0 ; i < tempDeck.size()-3; i++){
            if (tempDeck.get(i).getRank().equals(tempDeck.get(i+3).getRank())){
                outputDeck.add(tempDeck.get(i));
                outputDeck.add(tempDeck.get(i+1));
                outputDeck.add(tempDeck.get(i+2));
                outputDeck.add(tempDeck.get(i+3));
                break;
            }
        }
        return outputDeck;
    }

    public ArrayList<Card> showStreigh(ArrayList<Card> cards) {
        var tempDeck = new ArrayList<Card>(cards);
        var outputDeck = new ArrayList<Card>();



        System.out.println("here");


        return outputDeck;
    }

}

