import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,6,5,4};
        int[] nums2 = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for(int i=0;i<nums2.length;i++){
            System.out.println(nums2[i]);
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
