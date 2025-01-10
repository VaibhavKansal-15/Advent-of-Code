import java.util.*;
import java.util.regex.*;
public class MullitOver1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()) {
            input.append(sc.nextLine());
        }
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input.toString());

        int count=0;
        while(matcher.find()){
            int x=Integer.parseInt(matcher.group(1));
            int y=Integer.parseInt(matcher.group(2));
            count+=x*y;
        }
        System.out.println(count);
        sc.close();
    }
}
