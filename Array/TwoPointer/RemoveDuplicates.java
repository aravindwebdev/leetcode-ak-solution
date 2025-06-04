public class RemoveDuplicates{
    public static void main(String[] args){
        int arr[] = { 0,0,1,1,1,2,2,3,3,4};

        int result = 0;
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        result = removeDuplicates.bruteforce(arr);
        //result = removeDuplicates.optimized(arr);
        System.err.println(result);

    }
    public int optimized(int arr[]){
        int count = 1; //why? arr[0] always unique
        int n = arr.length;
        for(int i=1; i<n; i++){
            if(arr[i] != arr[count-1]){
                arr[count] = arr[i];
                count++;
            }
        }

        return count;
    }

    public int bruteforce(int arr[]){
        int n = arr.length;
        int temp[] = new int[n];
        temp[0] = arr[0];
        for(int i=1; i<n; i++){
            for(int j=i; j<n; j++){
                if(arr[i] != arr[j]){
                    temp[i] = arr[j];
                    break;
                }
            }
        }

        // for(int i: temp){
        //     arr[i] = temp[i];
        // }

        return temp.length;
    }
}
