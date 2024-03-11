public class firstandlastindexinsortedarray {
    public static void firstandlastidx(int arr[],int key){
        int l=0;
        int h=arr.length-1;
        int min=-1;
        int max=-2;
        while(l<=h){
            int mid=l+(h-l)/2;    
            if(arr[mid]==key){
                min=mid;      
            }
            if(arr[mid]>=key){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
         l=0;
         h=arr.length-1;
         while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==key){
                max=mid;
                 l=mid+1;
            }
            if(arr[mid]>key){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        System.out.println("min "+min);
        System.out.println("max "+max);
    }
    public static void main(String args[]){
        int arr[]= {4,7,7,8,8,8,10};
         firstandlastidx(arr, 8); 
    }
}
