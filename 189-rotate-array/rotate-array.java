class Solution {
     public static void reverse(int[]arr , int str , int end){
                if ( arr.length == 1  ) {
            return;
        }

        int i = str;
        int j = end;
        while( i<j ){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k%=n;

        reverse(nums , 0 , n-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , n-1);
       
       
    }
}