import java.util.*;
public class MovieRunnerSimilarRatings {
    void printAverageRatings(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=fourthRatings.getAverageRatings(35);
        System.out.println("found "+rateList.size()+" movies");
        
        rateList.sort(new Comparator<Rating>(){
            @Override
            public int compare(Rating a,Rating b){
                if(a.getValue()<b.getValue())
                    return -1;
                return 1;
            }
        });
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        
        AllFilters filter=new AllFilters();
        filter.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        filter.addFilter(new MinutesFilter(90,180));
        
        ArrayList<Rating> rateList=fourthRatings.getAverageRatingsByFilter(3,filter);
        System.out.println("found "+rateList.size()+" movies");
        
        rateList.sort(new Comparator<Rating>(){
            @Override
            public int compare(Rating a,Rating b){
                if(a.getValue()<b.getValue())
                    return -1;
                return 1;
            }
        });
        for(Rating r:rateList){
            //System.out.println(r.getValue()+" Time:"+MovieDatabase.getMinutes(r.getItem())+" "+
            //MovieDatabase.getTitle(r.getItem())+"\n\t"+MovieDatabase.getDirector(r.getItem()));
        }
    }
    
    void printSimilarRatings(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=fourthRatings.getSimilarRatings("71",20,5);
        System.out.println("found "+rateList.size()+" movies");
        
        
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    void printSimilarRatingsByGenre(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=fourthRatings.getSimilarRatingsByFilter("964",20,5,new GenreFilter("Mystery"));
        System.out.println("found "+rateList.size()+" movies");
        
        
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    void printSimilarRatingsByDirector(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=fourthRatings.getSimilarRatingsByFilter("120",10,2,new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        System.out.println("found "+rateList.size()+" movies");
        
        
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    void printSimilarRatingsByGenreAndMinutes(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        AllFilters f=new AllFilters();
        f.addFilter(new GenreFilter("Drama"));
        f.addFilter(new MinutesFilter(80,160));
        
        ArrayList<Rating> rateList=fourthRatings.getSimilarRatingsByFilter("168",10,3,f);
        System.out.println("found "+rateList.size()+" movies");
        
        
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    void printSimilarRatingsByYearAfterAndMinutes(){
        FourthRatings fourthRatings=new FourthRatings();
        RaterDatabase.initialize("ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+RaterDatabase.size()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        AllFilters f=new AllFilters();
        f.addFilter(new YearAfterFilter(1975));
        f.addFilter(new MinutesFilter(70,200));
        
        ArrayList<Rating> rateList=fourthRatings.getSimilarRatingsByFilter("314",10,5,f);
        System.out.println("found "+rateList.size()+" movies");
        
        
        for(Rating r:rateList){
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
}
