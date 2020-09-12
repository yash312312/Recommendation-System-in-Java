import java.util.*;
public class FourthRatings {
        private boolean countRaters(String id,int minimalRaters,List<Rating> raterList){
        int count=0;
        
        for(Rating rate:raterList){
            Rater r=RaterDatabase.getRater(rate.getItem());
            
            if(r.hasRating(id)){
                count++;
            }
        }
        
        return count>=minimalRaters;
    }
    private double getAverageByID(String id,int minimalRaters){
        int count=0;
        double sum=0;
        for(Rater rate:RaterDatabase.getRaters()){
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
    
    private double dotProduct(Rater me,Rater r){
        ArrayList<Rating> byMe=new ArrayList<>();
        ArrayList<Rating> byR=new ArrayList<>();
        ArrayList<Double> dotpro=new ArrayList<>();
        double sum=0;
        for(String i:me.getItemsRated()){
            
            if(r.hasRating(i)){
                double x=(me.getRating(i)-5)*(r.getRating(i)-5);
                sum=sum+x;
            }
            
        }
        return sum;
    }
    
    private List<Rating> getSimilarities(String id){
        ArrayList<Rating> rating=new ArrayList<>();
        Rater r=RaterDatabase.getRater(id);
        for(Rater i:RaterDatabase.getRaters()){
            if(!i.getID().equals(id)){
                double val=dotProduct(r,i);
                rating.add(new Rating(i.getID(),val));
            }
        }
        rating.sort(new Comparator<Rating>(){
            public int compare(Rating a,Rating b){
                if(a.getValue()<b.getValue())
                return 1;
                else if(a.getValue()==b.getValue())
                return 0;
                else
                return -1;
            }
        });
        return rating;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id,int numSimilarRaters,int minimalRaters){
        List<Rating> rating=getSimilarities(id).subList(0,numSimilarRaters);
        Set<String> movies=new HashSet<>();
        ArrayList<Rating> movWtAvg=new ArrayList<>();
        for(Rating rate:rating){
            Rater r=RaterDatabase.getRater(rate.getItem());
            movies.addAll(r.getItemsRated());
        }
        
        for(String j:movies){
            double sum=0;
            int count=0;
            if(countRaters(j,minimalRaters,rating)){
            
                for(Rating rate:rating){
                    Rater rat=RaterDatabase.getRater(rate.getItem());
                    if(rat.hasRating(j)){
                        sum=sum+rat.getRating(j)*rate.getValue();
                        count++;
                        
                    }
                }
                movWtAvg.add(new Rating(j,sum/count));
            }
            

        }
        movWtAvg.sort(new Comparator<Rating>(){
            public int compare(Rating a,Rating b){
                if(a.getValue()<b.getValue())
                return 1;
                else if(a.getValue()==b.getValue())
                return 0;
                else
                return -1;
            }
        });
        return movWtAvg;
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id,int numSimilarRaters,int minimalRaters,Filter f){
        List<Rating> rating=getSimilarities(id).subList(0,numSimilarRaters);
        Set<String> movies=new HashSet<>();
        ArrayList<Rating> movWtAvg=new ArrayList<>();
        for(Rating rate:rating){
            Rater r=RaterDatabase.getRater(rate.getItem());
            movies.addAll(r.getItemsRated());
        }
        
        for(String j:movies){
            double sum=0;
            int count=0;
            if(countRaters(j,minimalRaters,rating)&&f.satisfies(j)){
            
                for(Rating rate:rating){
                    Rater rat=RaterDatabase.getRater(rate.getItem());
                    if(rat.hasRating(j)){
                        sum=sum+rat.getRating(j)*rate.getValue();
                        count++;
                        
                    }
                }
                movWtAvg.add(new Rating(j,sum/count));
            }
            

        }
        movWtAvg.sort(new Comparator<Rating>(){
            public int compare(Rating a,Rating b){
                if(a.getValue()<b.getValue())
                return 1;
                return -1;
            }
        });
        return movWtAvg;
    }
}

