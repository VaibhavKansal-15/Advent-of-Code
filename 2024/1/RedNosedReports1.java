import java.util.*;

public class RedNosedReports1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        System.out.println("enter stop to end this : ");
        while (sc.hasNextLine()) {
            String Line = sc.nextLine().trim();
            if (Line.equalsIgnoreCase("stop")) {
                break;
            }
            String[] numbers = Line.split("\\s+");
            List<Integer> list2 = new ArrayList<>();
            for (String num : numbers) {
                list2.add(Integer.parseInt(num));
            }
            list.add(list2);
        }
        int safeCount = 0;
        for (List<Integer> list2 : list) {
            if (isSafe(list2)) {
                safeCount++;
            }
        }
        System.out.println("Number of safe reports: " + safeCount);
        sc.close();
    }
    private static boolean isSafe(List<Integer> report) {
        if (report.size() < 2) {
            return false;
        }
        boolean isIncreasing = report.get(1) > report.get(0);
        for (int i = 1; i < report.size(); i++) {
            int diff = report.get(i) - report.get(i - 1);
            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false; 
            }
            if ((isIncreasing && diff < 0) || (!isIncreasing && diff > 0)) {
                return false;
            }
        }
        return true;
    }
}
