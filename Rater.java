import java.util.*;
public interface Rater {
    public void addRating(String item, double rating);

    public String getID();

    public boolean hasRating(String item);

    public double getRating(String item);

    public int numRatings();

    public ArrayList<String> getItemsRated();

}
