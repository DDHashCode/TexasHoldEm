import java.util.ArrayList;

public class Gameplay extends Deck{
        private ArrayList<Player> players = new ArrayList<>();
        private int amountOfPlayers;
        private Deck deck = new Deck();
        private PlayerPosition defaultPos = PlayerPosition.BUTTON;
        private ArrayList<Card> flopCards = new ArrayList<>();
        private ArrayList<Card> turnCards = new ArrayList<>();
        private ArrayList<Card> riverCards = new ArrayList<>();
        private ArrayList<Card> CardsOnTable = new ArrayList<>();


    public Gameplay() {
            this.amountOfPlayers = 0;
        }

        public void AddPlayer() {
            players.add(new Player(defaultPos));
            defaultPos.next();
            this.amountOfPlayers = players.size();
        }


        public void StartGame() {
        //adding 2 players to the game, creating a deck, distributing cards to players
            AddPlayer();
            AddPlayer();

            deck.printCardStack();
            firstDistribution();
        //printing out to check if works
            System.out.println(this.amountOfPlayers + "===============");
            for ( int i = 0 ; i < players.size() ; i++){
                System.out.println(players.get(i).getPlayerCards().toString());
            }
            //setting cards to flop - first three cards
            setFlop();
            CardsOnTable.addAll(flopCards);
            System.out.println(flopCards.toString());
            //setting turn - another cards
            setTurn();
            CardsOnTable.addAll(turnCards);
            System.out.println(turnCards.toString());
            //river
            setRiver();
            CardsOnTable.addAll(riverCards);
            System.out.println(riverCards.toString());
            System.out.println("************");
            System.out.println(CardsOnTable.toString());

            System.out.println("************");

            FinalDeck tempDeck = new FinalDeck(CardsOnTable, players.get(0));
        }

        private void firstDistribution() {
            for ( int i = 0 ; i < players.size() ; i++ ){
                players.get(i).AddCardToHand(deck.deckStack.pop());
            }

            for ( int i = 0 ; i < players.size() ; i++ ){
                players.get(i).AddCardToHand(deck.deckStack.pop());
            }

        }

        private void setFlop() {
            deck.deckStack.pop();
            this.flopCards.add(deck.deckStack.pop());
            this.flopCards.add(deck.deckStack.pop());
            this.flopCards.add(deck.deckStack.pop());
        }

        private void setTurn() {
            deck.deckStack.pop();
            this.turnCards.add(deck.deckStack.pop());
        }

        private void setRiver(){
            deck.deckStack.pop();
            this.riverCards.add(this.deckStack.pop());
        }


}
