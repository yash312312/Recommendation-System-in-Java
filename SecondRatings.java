import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String moviefile,String ratingsfile) {
        FirstRatings firstRatings = new FirstRatings();
        myMovies=firstRatings.loadMovies(moviefile);
        myRaters=firstRatings.loadRaters(ratingsfile);
    }
    public int getMovieSize(){
        return myMovies.size();
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    private double getAverageByID(String id,int minimalRaters){
        int count=0;
        double sum=0;
        for(Rater rate:myRaters){
            if(rate.hasRating(id)){
                sum=sum+rate.getRating(id);
                count++;
            }
        }
        if(count>=minimalRaters){
            return sum/count;
        }
        return 0.0;
    }
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> rateList=new ArrayList<>();
        for(Movie m:myMovies){
            double rateTemp=getAverageByID(m.getId(),minimalRaters);
            if(rateTemp>0.99){
                rateList.add(new Rating(m.getId(),rateTemp));
            }
        }
        return rateList;
    }
    public String getTitle(String id){
        for(Movie m:myMovies){
            if(m.getId().equals(id))
                return m.getTitle();
        }
        return "ID not found";
    }
    public String getID(String title){
        for(Movie m:myMovies){
            if(m.getTitle().equals(title))
                return m.getId();
        }
        return "NO SUCH TITLE.";
    }
}