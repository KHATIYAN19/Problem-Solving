public class findmininrotatedandsortedarray{
    public static int min(int arr[]){
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
           
            if(arr[low]<=arr[high]){
                ans=Math.min(arr[low],ans);
            }
            if(arr[low]<arr[high]){
                ans=Math.min(ans,arr[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2,3};
        System.out.println("Minimum element is: "+min(arr));
    }
}
