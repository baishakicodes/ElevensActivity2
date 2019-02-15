/**
 * Created by Teacher on 1/7/2019.
 */
public class Card {
    private String rank;
    private String suit;
    private int pointValue;
    public Card(String rank, String suit, int pointValue){
        this.rank = rank;
        this.suit = suit;
        this.pointValue = pointValue;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPointValue() {
        return pointValue;
    }
    public boolean cardEquality(Card other){
        if(this.rank==other.getRank() && this.suit==other.getRank() && this.suit==other.getSuit()){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
       String str = rank + " of "+ suit+"(point value = "+pointValue + ")";
       return str;
    }
}