import java.util.*;

public class MovieRunnerAverage {
    void printAverageRatings(){
        SecondRatings secondRatings=new SecondRatings();
        //System.out.println(secondRatings.getMovieSize()+" "+secondRatings.getRaterSize());
        ArrayList<Rating> rateList=secondRatings.getAverageRatings(12);
        rateList.sort(new Comparator<Rating>(){
            @Override
            public int compare(Rating a,Rating b){
                if(a.getValue()<b.getValue())
                    return -1;
                return 1;
            }
        });
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+secondRatings.getTitle(r.getItem()));
        }
    }
    
    void getAverageRatingOneMovie(){
        SecondRatings secondRatings=new SecondRatings();
        ArrayList<Rating> rateList=secondRatings.getAverageRatings(50);
        String s="Vacation";
        System.out.println(rateList.size());
        for(Rating r:rateList){
            if(secondRatings.getTitle(r.getItem()).equals(s)){
                //System.out.println(r.getValue());
            }
        }
    }
    
}
