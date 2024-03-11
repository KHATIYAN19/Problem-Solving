class Solution {
    public boolean search(int[] arr, int target) {
          int low=0;
          int high=arr.length-1;
          while(low<=high){
              int mid=low+(high-low)/2;
              if(arr[mid]==target){
                  return true;
              }   
              if(arr[low]<=arr[mid]){
                  if(low!=mid&&arr[low]==arr[mid]){
                      low++;
                  }
                  else  if(arr[low]<=target&&target<arr[mid]){
                    high=mid-1;
                  }else{
                    low=mid+1;
                  }
              }else if(arr[mid]<=target&&target<=arr[high]){
                     low=mid+1;
             }else{
                     high=mid-1;
             }
              
          }
          return false;
    }
}
