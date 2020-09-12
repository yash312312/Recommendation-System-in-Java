import java.util.ArrayList;

public class PlainRater implements Rater {
    private String myID;
    private ArrayList<Rating> myRatings=new ArrayList<>();

    public PlainRater(String myID) {
        this.myID = myID;
    }

    public void addRating(String item, double rating) {
        Rating ob = new Rating(item, rating);
        myRatings.add(ob);
    }

    public String getMyID() {
        return myID;
    }

    public boolean hasRating(String item){
        for(Rating rating: myRatings){
            if(rating.getItem().equals(item))
                return true;
        }
        return false;
    }

    public double getRating(String item){
        for(Rating rating: myRatings){
            if(rating.getItem().equals(item))
                return rating.getValue();
        }
        return -1;
    }

    public int numRatings(){
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated(){
        ArrayList<String> itemList = new ArrayList<>();
        for(Rating rating: myRatings){
            itemList.add(rating.getItem());
        }
        return itemList;
    }

}
