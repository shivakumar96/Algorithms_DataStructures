import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class Temp {

    public static int[] findMeanMode(int n, int[] arr) {
        int[] result = new int[2];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], count + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        result[0] = (int) Math.floor(sum / n);

        int mode = arr[0];
        int maxCount = 1;
        for (int key : map.keySet()) {
            if (map.get(key) > maxCount) {
                mode = key;
                maxCount = map.get(key);
            }
        }
        result[1] = mode;

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = findMeanMode(n, arr);
        System.out.println(result[0] + " " + result[1]);
    }
}
