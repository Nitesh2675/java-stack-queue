import java.util.*;

class FindZeroSumSubarrays {
    static List<List<Integer>> findSubarrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1)));
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(Arrays.asList(Arrays.copyOfRange(arr, start + 1, i + 1)));
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }
}

// Input: [3, 4, -7, 1, 3, 3, 1, -4]
// Output: [[3, 4, -7], [4, -7, 1, 3, 3, 1, -4], [1, 3, 3, 1, -4]]