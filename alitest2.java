import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        int n = 0;
        String raw = (in.nextLine().trim());
        String raw1 = raw.split("(")[1];
        String raw2 = raw.split(")")[0];
        String[] arr = raw2.split(",");
        int len = arr.length;
        int[] nums = new int[len];
        for(int i = 0; i<len ;i++){
            nums[i] = Integer.getInteger(arr[i]);
        }
        int a = nums[0]^nums[1]^nums[2];
        System.out.println(String.valueOf(a));
    }
}