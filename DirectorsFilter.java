
public class DirectorsFilter implements Filter{
    String[] directorsList;
    public DirectorsFilter(String directorsList){
        this.directorsList=directorsList.split(",");
    }
    @Override
    public boolean satisfies(String id){
        String temp=MovieDatabase.getDirector(id);
        for(String d:directorsList){
            if(temp.contains(d))
                return true;
        }
        return false;
    }
}
