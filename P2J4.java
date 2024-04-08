import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P2J4 {

    public static int firstMissingPositive(List<Integer> a) {
        Set<Integer> seen = new HashSet<>();
        for (Integer item : a) {
            seen.add(item);
        }

        int n = a.size();
        for (int i = 1; i <= n + 1; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }

        // This should never be reached as per the pigeonhole principle
        return -1;
    }

    public static List<Integer> runningMedianOfThree(List<Integer> a) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(2, a.size()); i++) {
            result.add(a.get(i));
        }
        for (int i = 2; i < a.size(); i++) {
            int median = getMedian(a.get(i - 2), a.get(i - 1), a.get(i));
            result.add(median);
        }
        return result;
    }

    private static int getMedian(int a, int b, int c) {
        return a + b + c - Math.min(Math.min(a, b), c) - Math.max(Math.max(a, b), c);
    }

    public static void sortByElementFrequency(List<Integer> a) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int item : a) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }

        Comparator<Integer> frequencyComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int freqCompare = countMap.get(b).compareTo(countMap.get(a));
                return freqCompare != 0 ? freqCompare : a.compareTo(b);
            }
        };

        Collections.sort(a, frequencyComparator);
    }
}
