import java.util.*;
public class HistorianHysteria2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> leftSide=new ArrayList<>();
        List<Integer> rightSide=new ArrayList<>();
        System.out.println("type 'done' to finish : ");
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int leftNum = sc.nextInt();
                int rightNum = sc.nextInt();
                leftSide.add(leftNum);
                rightSide.add(rightNum);
            } else if (sc.hasNext("done")) {
                break;
            }else {
                sc.next();
            }
        }
        int count=0;
        Map<Integer,Integer> rightfreq=new HashMap<>();
        for(int num:rightSide){
            rightfreq.put(num,rightfreq.getOrDefault(num, 0)+1);
        }

        for(int num:leftSide){
            if(rightfreq.containsKey(num)){
                count+=num*rightfreq.get(num);
            }
        }
        System.out.println(count);
        sc.close();
    }
}