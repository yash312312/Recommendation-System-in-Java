
public class MinutesFilter implements Filter{
    int minutesMax,minutesMin;
    public MinutesFilter(int minutesMin,int minutesMax){
        this.minutesMax=minutesMax;
        this.minutesMin=minutesMin;
    }
    @Override
    public boolean satisfies(String id){
        int temp=MovieDatabase.getMinutes(id);
        return (temp<=minutesMax&&temp>=minutesMin)?true:false;
    }
}
