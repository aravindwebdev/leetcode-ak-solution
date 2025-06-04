
import java.util.ArrayList;
import java.util.List;

//find the longest subarray length of the given array where k <= 14;
//arr = [2,5,1,7,10] op=3 [5,1,7]
class Longestsubarray{
    public static void main(String args[]){
        int arr[] = {2,5,1,7,10};
        int k = 14;

        Longestsubarray lsubarray = new Longestsubarray();
        //Brute force
        
        int res = lsubarray.bruteforce(arr, k);
        System.err.println("Brute Force: "+ res);
    }

    public int bruteforce(int arr[], int k){
        int maxLength = 0;
        int n = arr.length;
        List<Integer> maxSubArray = new ArrayList<>();
        for(int i=0; i<n; i++){
            int sum = 0;
            List<Integer> currentSubArray = new ArrayList<>();
            for(int j=i; j<n; j++){
                sum = sum + arr[j];
                if(sum <= k){
                    currentSubArray.add(arr[j]);
                    if(j-i+1 > maxLength){
                        maxLength = j-i+1;
                        maxSubArray = new ArrayList<>(currentSubArray);

                    }
                    maxLength = Math.max(maxLength, j-i+1);
                }else{
                    break;
                }
            }
        }
        
        System.out.println("Max Length: " + maxLength);
        for(int i : maxSubArray){
            
            System.out.println("Subarray with max length and sum <= " + k + ": " + i);
        }

        return maxLength;

    }
}
