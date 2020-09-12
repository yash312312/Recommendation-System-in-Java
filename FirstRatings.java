import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {
    
    public ArrayList<Movie> loadMovies(String filename){
         
        ArrayList<Movie> movies = new ArrayList<>();

        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        
        for(CSVRecord record: parser){
            
            movies.add(new Movie(record.get("id"),record.get("title"),record.get("genre"),record.get("director"),
            record.get("country"),record.get("poster"),Integer.parseInt(record.get("year")),Integer.parseInt(record.get("minutes"))));
            
        }
        
        return movies;
    }
    
    public void testLoadMovies(){
        
        ArrayList<Movie> movies=loadMovies("ratedmoviesfull.csv");
        
        //Number of Movies
        System.out.println(movies.size());
        
        //List of all movies
        for(Movie mov:movies){
            //System.out.println(mov);
        }
        
        //Comedy
        int c=0;
        for(Movie mov:movies){
            if(mov.getGenres().contains("Comedy"))
                c++;
        }
        System.out.println("Q2 "+c);
        
        //movies are greater than 150 minutes in length.
        c=0;
        for(Movie mov:movies){
            if(mov.getMinutes()>150)
                c++;
        }
        System.out.println("Q3 "+c);
        testLoadRaters();
        //the maximum number of movies by any director, and who
        //the directors are that directed that many movies
        
        
         
    }
    
    public ArrayList<Rater> loadRaters(String filename){
         
        ArrayList<Rater> rater = new ArrayList<>();

        FileResource fr=new FileResource(filename);
        CSVParser parser=fr.getCSVParser();
        
        for(CSVRecord record: parser){
            boolean flag=true;
            if(!rater.isEmpty()){
                
                for(int i=0;i<rater.size();i++){
                    if(rater.get(i).getMyID().equals(record.get("rater_id"))){
                        rater.get(i).addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                        flag=false;
                        break;
                    }
                }
                
            }
            if(flag){
                Rater rate=new PlainRater(record.get("rater_id"));
                rate.addRating(record.get("movie_id"),Double.parseDouble(record.get("rating")));
                rater.add(rate);
            }
        }
        
        return rater;
    }
    
    public void testLoadRaters(){
    
        ArrayList<Rater> rater=loadRaters("ratings.csv");
        for(Rater r:rater){
            //System.out.println(r.getMyID()+" "+r.numRatings());
            for(String rat:r.getItemsRated()){
                //System.out.println("   "+rat+" : "+ r.getRating(rat));
            }
        }
        String ratId="193";
        for(Rater r:rater){
            if(r.getMyID().equals(ratId)){
                System.out.println("Q6 "+r.numRatings());
            }
        }
        String ratMaxId="";
        int maxRat=0;
        for(Rater r:rater){
            if(r.numRatings()>maxRat){
                maxRat=r.numRatings();
                ratMaxId=r.getMyID();
            }
        }
        System.out.println("Q7 "+maxRat);
        System.out.println("Q8 "+ratMaxId);
        String movieId="1798709";
        int cnt=0;
        for(Rater r:rater){
            if(r.hasRating(movieId))
                cnt++;
        }
        
        System.out.println("Q9 "+cnt);
        
        HashSet<String> numMovie=new HashSet<>();
        for(Rater r:rater){
            for(String rat:r.getItemsRated()){
                numMovie.add(rat);
            }
        }
        System.out.println("Q10 "+numMovie.size());
        //  System.out.println(rater.size());
    }
    
}
