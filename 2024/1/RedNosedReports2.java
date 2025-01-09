import java.util.*;
import java.util.stream.*;

public class RedNosedReports2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> all = new ArrayList<>();

        System.out.println("Enter levels for each report (separated by spaces), one report per line. Enter 'stop' to finish:");

        // Collect input until "stop" is entered
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                List<Integer> levels = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                all.add(levels);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers separated by spaces.");
            }
        }

        // Calculate the number of safe reports
        long safeCount = all.stream()
                .filter(levels -> isSafe(levels) || damp(levels).stream().anyMatch(RedNosedReports2::isSafe))
                .count();

        System.out.println("Number of safe reports: " + safeCount);
        sc.close();
    }

    // Generate all dampened versions of the levels
    private static List<List<Integer>> damp(List<Integer> levels) {
        List<List<Integer>> dampened = new ArrayList<>();
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> temp = new ArrayList<>(levels);
            temp.remove(i);
            dampened.add(temp);
        }
        return dampened;
    }

    // Check if a report is safe
    private static boolean isSafe(List<Integer> levels) {
        Integer previous = null;
        String trend = null;

        for (int current : levels) {
            if (previous == null) {
                previous = current;
                continue;
            }

            int diff = Math.abs(current - previous);
            if (diff < 1 || diff > 3) {
                return false; // Invalid difference
            }

            if (current < previous) {
                if ("increase".equals(trend)) {
                    return false; // Trend mismatch
                }
                trend = "decrease";
            } else if (current > previous) {
                if ("decrease".equals(trend)) {
                    return false; // Trend mismatch
                }
                trend = "increase";
            }

            previous = current;
        }

        return true;
    }
}
