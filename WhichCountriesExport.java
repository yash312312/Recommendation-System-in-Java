import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExport{
    public void tester(){
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();
        System.out.println(countryInfo(parser,"Nauru"));
        parser=fr.getCSVParser();
       // listExportersTwoProducts(parser,"gold","diamonds");
        //parser=fr.getCSVParser();
        find(parser);
    }
    String countryInfo(CSVParser parser,String country){
        for(CSVRecord record:parser){
            String c=record.get("Country");
            if(c.equals(country)){
                return c+": "+record.get("Exports")+": "+record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }
    void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        
        for(CSVRecord record:parser){
            String items=record.get("Exports");
            if(items.contains(exportItem1)&&items.contains(exportItem2))
                System.out.println(record.get("Country"));
        }
    
    }
    void find(CSVParser parser){
        int count=0;
        String t="$999,999,999,999";
        for(CSVRecord record:parser){
            String money=record.get("Value (dollars)");
            if(money.length()>t.length())
                System.out.println(record.get("Country"));
        }
        //System.out.println(count);
    }
}