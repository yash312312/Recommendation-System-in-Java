import java.util.*;
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecommendationRunner implements Recommender  {
    
    public ArrayList<String> getItemsToRate (){
        ArrayList<String> movies=new ArrayList<>();
        int i=0;
        for(String s:MovieDatabase.filterBy(new TrueFilter())){
            if(i==15)
            break;
            movies.add(s);
            i++;
        }
        return movies;
    }
    
    public void printRecommendationsFor (String webRaterID){
        FourthRatings fourthRatings=new FourthRatings();
        ArrayList<Rating> rateList=fourthRatings.getSimilarRatings(webRaterID,14,1);
        System.out.println("<TABLE BORDER><TR><TH>Year<TH>Movie<TH>Length<TH>Directed By</TR>");
        
        int i=0;
        for(Rating r:rateList){
           
            System.out.print("<TR ALIGN=CENTER><TD>"+MovieDatabase.getYear(r.getItem())+"<TD>"+ MovieDatabase.getTitle(r.getItem())+"<TD>"+MovieDatabase.getMinutes(r.getItem())+"<TD>"+MovieDatabase.getDirector(r.getItem())+"\n");
            if(i==20)
                break;
            i++;
        }
        System.out.println("</TABLE>");
    }
}
