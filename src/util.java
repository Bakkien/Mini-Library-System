import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Hazem
 * helper functions
 */
public class util{
    public static void printLine(){
            System.out.println("--------------------------------------");
    }
    public static long subtractDates(LocalDate d1, LocalDate d2){
            long difference = ChronoUnit.DAYS.between(d1, d2);
            System.out.println(d1);
            System.out.println(d2);
            System.out.println(difference);
            printLine();
            return difference;
    }
    
    public static LocalDate StringTODate(String s){
        String[] arr = s.split("-");
        int[] date = new int[3];
        for (int i =0; i <3 ; i++){
            date[i] = Integer.parseInt(arr[i]);
        }
        return LocalDate.of(date[0],date[1],date[2]);
    }
}
