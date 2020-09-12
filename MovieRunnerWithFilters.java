import java.util.*;
public class MovieRunnerWithFilters {
    void printAverageRatings(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatings(35);
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
    
    public void printAverageRatingsByYearAfter(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatingsByFilter(20,new YearAfterFilter(2000));
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
            System.out.println(r.getValue()+" "+MovieDatabase.getYear(r.getItem())+" "+MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    public void printAverageRatingsByGenre(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatingsByFilter(20,new GenreFilter("Comedy"));
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
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+"\n\t "+
            MovieDatabase.getGenres(r.getItem()));
        }
    }
    
    public void printAverageRatingsByMinutes(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatingsByFilter(5,new MinutesFilter(105,135));
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
            //MovieDatabase.getTitle(r.getItem()));
        }
    }
    
    public void printAverageRatingsByDirectors(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatingsByFilter(4,new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
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
            System.out.println(r.getValue()+" "+MovieDatabase.getTitle(r.getItem())+"\n\t"+
            MovieDatabase.getDirector(r.getItem()));
        }
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        AllFilters filter=new AllFilters();
        filter.addFilter(new YearAfterFilter(1990));
        filter.addFilter(new GenreFilter("Drama"));
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatingsByFilter(8,filter);
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
            //System.out.println(r.getValue()+" "+MovieDatabase.getYear(r.getItem())+" "+
            //MovieDatabase.getTitle(r.getItem())+"\n\t"+MovieDatabase.getGenres(r.getItem()));
        }
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings thirdRatings=new ThirdRatings("ratings.csv");
        
        MovieDatabase.initialize("ratedmoviesfull.csv");

        System.out.println("read data for "+thirdRatings.getRaterSize()+" raters");
        System.out.println("read data for "+MovieDatabase.size()+" movies");
        
        AllFilters filter=new AllFilters();
        filter.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        filter.addFilter(new MinutesFilter(90,180));
        
        ArrayList<Rating> rateList=thirdRatings.getAverageRatingsByFilter(3,filter);
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
}
