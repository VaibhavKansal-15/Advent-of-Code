import java.util.*;
public class HistorianHysteria1{
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
        Collections.sort(leftSide);
        Collections.sort(rightSide);
        int count=0;
        for(int i=0;i<leftSide.size();i++){
            count+=Math.abs(leftSide.get(i)-rightSide.get(i));
        }
        System.out.println(count);
        sc.close();
    }
}
