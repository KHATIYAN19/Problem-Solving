import java.util.*;
class Main{
   public static int ceil(int[] a,int q){
    int l=0;
    int h=a.length-1;
    int ans=a.length;
    while(l<=h){
      int m=(l+h)/2;
      if(a[m]>=q) {
          ans=m;
          h=m-1;
      } else{
           l=m+1;
      } 
    }
    return ans;
  }
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int q=sc.nextInt();
    int[] a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    Arrays.sort(a);
    int[] Q=new int[q];
    for(int i=0;i<q;i++)
     Q[i]=sc.nextInt();
    for(int i=0;i<q;i++)
    {
      System.out.println(n-ceil(a,Q[i]));
    }
  }
 
}
