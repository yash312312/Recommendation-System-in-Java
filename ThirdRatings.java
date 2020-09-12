import java.util.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile) {
        FirstRatings firstRatings = new FirstRatings();
        
        myRaters=firstRatings.loadRaters(ratingsfile);
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
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String m:movies){
            double rateTemp=getAverageByID(m,minimalRaters);
            if(rateTemp>0.99){
                rateList.add(new Rating(m,rateTemp));
            }
        }
        return rateList;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria){
        ArrayList<String> movieID=new ArrayList<>();
        movieID=MovieDatabase.filterBy(filterCriteria);
        
        ArrayList<Rating> rateList=new ArrayList<>();
        
        for(String m:movieID){
            double rateTemp=getAverageByID(m,minimalRaters);
            if(rateTemp>0.99){
                rateList.add(new Rating(m,rateTemp));
            }
        }
        return rateList;
    }
    
}