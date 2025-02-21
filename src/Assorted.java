import java.util.*;
import java.util.stream.Collectors;

public class Assorted {

    public static int findSum(List<?> list) {
        int sum = 0;
        for (Object obj : list) {
            if (obj instanceof Integer) {
                sum += (Integer) obj;
            } else if (obj instanceof String) {
                sum += Integer.parseInt((String) obj);
            }
        }
        return sum;
    }

    public static List<Integer> filterStrings(List list) {
        List<Integer> result = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            }
        }
        return result;
    }

    public static List<String> lineNumbering(List<String> list) {
        List<String> result = new ArrayList<>();
        int line = 1;
        for (String s : list) {
            result.add(line + ": " + s);
            line++;
        }
        return result;
    }

    public static int busStop(List<Integer[]> list) {
        int total = 0;
        for (Integer[] pair : list) {
            total += pair[0] - pair[1];
        }
        return total;
    }

    public static int toBinary(List<Integer> list) {
        int sum = 0;
        int length = list.size();
        for (int i = 0; i < length; i++) {
            sum += list.get(i) * (1 << (length - 1 - i));
        }
        return sum;
    }

    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {
        Set<Integer> setB = new HashSet<>(listB);
        return listA.stream()
                .filter(num -> !setB.contains(num))
                .collect(Collectors.toList());
    }

    public static List<Integer> sortOdd(List<Integer> list) {
        List<Integer> odds = new ArrayList<>();
        for (int num : list) {
            if (num % 2 != 0) {
                odds.add(num);
            }
        }
        Collections.sort(odds);
        int index = 0;
        List<Integer> result = new ArrayList<>();
        for (int num : list) {
            if (num % 2 != 0) {
                result.add(odds.get(index++));
            } else {
                result.add(num);
            }
        }
        return result;
    }

    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        List<Integer> result = new ArrayList<>();
        for (int n = lowerBound; n <= upperBound; n++) {
            String s = Integer.toString(n);
            long sum = 0;
            for (int i = 0; i < s.length(); i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                sum += Math.pow(digit, i + 1);
            }
            if (sum == n) {
                result.add(n);
            }
        }
        return result;
    }

    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int num : list) {
            int count = countMap.getOrDefault(num, 0);
            if (count < n) {
                result.add(num);
                countMap.put(num, count + 1);
            }
        }
        return result;
    }

    public static List<String> wildWest(List<String> directions) {
        Deque<String> stack = new ArrayDeque<>();
        Map<String, String> opposites = new HashMap<>();
        opposites.put("NORTH", "SOUTH");
        opposites.put("SOUTH", "NORTH");
        opposites.put("EAST", "WEST");
        opposites.put("WEST", "EAST");

        for (String dir : directions) {
            if (!stack.isEmpty() && stack.peekLast().equals(opposites.get(dir))) {
                stack.pollLast();
            } else {
                stack.addLast(dir);
            }
        }
        return new ArrayList<>(stack);
    }

    public static int queueTime(List<Integer> queue, int tillsOpen) {
        if (tillsOpen <= 0) return 0;
        int[] tills = new int[tillsOpen];
        for (int time : queue) {
            int minIndex = 0;
            for (int i = 1; i < tills.length; i++) {
                if (tills[i] < tills[minIndex]) {
                    minIndex = i;
                }
            }
            tills[minIndex] += time;
        }
        int max = 0;
        for (int time : tills) {
            if (time > max) max = time;
        }
        return max;
    }
}