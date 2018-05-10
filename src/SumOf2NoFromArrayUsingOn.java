/*
Let Array be {1, 4, 45, 6, 10, -8} and sum of 2 digit from array to find be 16 (answer is 10 and 6, need to perform with only 1 loop)

 */

import java.util.HashMap;
import java.util.Map;

public class SumOf2NoFromArrayUsingOn {

    public static void main(String[] args) {

        int arr[] = {1, 4, 45, 6, 10, -8};

        int sum = 10;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i < arr.length; i++){
            if(map.containsKey(sum - arr[i])){
                System.out.println((sum - arr[i]) + " + " + arr[i] );
            }
            map.put(arr[i],sum - arr[i]);
        }

    }

}
