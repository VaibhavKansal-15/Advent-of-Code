import java.util.*;
import java.util.regex.*;

public class MultiOver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        // Read input until an empty line
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) { // Stop if an empty line is encountered
                break;
            }
            input.append(line);
        }
        sc.close();

        // Process the input and calculate the sum
        String inputString = input.toString();

        // Regular expressions for instructions
        Pattern mulPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        Pattern doPattern = Pattern.compile("do\\(\\)");
        Pattern dontPattern = Pattern.compile("don't\\(\\)");

        boolean isEnabled = true;
        int sum = 0;

        // Parse the input
        Matcher mulMatcher = mulPattern.matcher(inputString);
        Matcher doMatcher = doPattern.matcher(inputString);
        Matcher dontMatcher = dontPattern.matcher(inputString);

        int currentIndex = 0;

        while (true) {
            int nextDo = doMatcher.find(currentIndex) ? doMatcher.start() : Integer.MAX_VALUE;
            int nextDont = dontMatcher.find(currentIndex) ? dontMatcher.start() : Integer.MAX_VALUE;
            int nextMul = mulMatcher.find(currentIndex) ? mulMatcher.start() : Integer.MAX_VALUE;

            if (nextDo == Integer.MAX_VALUE && nextDont == Integer.MAX_VALUE && nextMul == Integer.MAX_VALUE) {
                break; // No more instructions
            }

            if (nextDo < nextDont && nextDo < nextMul) {
                isEnabled = true;
                currentIndex = doMatcher.end();
            } else if (nextDont < nextDo && nextDont < nextMul) {
                isEnabled = false;
                currentIndex = dontMatcher.end();
            } else {
                if (isEnabled) {
                    int x = Integer.parseInt(mulMatcher.group(1));
                    int y = Integer.parseInt(mulMatcher.group(2));
                    sum += x * y;
                }
                currentIndex = mulMatcher.end();
            }
        }

        System.out.println(sum);
    }
}
