import java.util.*;

public class EfficientRater implements Rater {
    private String myID;
    private HashMap<String,Rating> myRatings=new HashMap<>();

    public EfficientRater(String myID) {
        this.myID = myID;
    }

    public void addRating(String item, double rating) {
        Rating ob = new Rating(item, rating);
        myRatings.put(item,ob);
    }

    public String getID() {
        return myID;
    }

    public boolean hasRating(String item){
        
        if(myRatings.containsKey(item))
            return true;
        return false;
    }

    public double getRating(String item){
        if(hasRating(item))
            return myRatings.get(item).getValue();
        return -1;
    }

    public int numRatings(){
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated(){
        ArrayList<String> itemList = new ArrayList<>();
        itemList.addAll(myRatings.keySet());
        return itemList;
    }

}
