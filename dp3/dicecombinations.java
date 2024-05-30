import java.util.*;
public class test {
    public static int solve(int n,int dp[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=0;
        for(int i=1;i<=6;i++){
              ans+=solve(n-i,dp)%1000000007;
              ans=ans%1000000007;
        }
        return dp[n]= ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       int dp[]=new int[n+1];
       Arrays.fill(dp, -1);
        System.out.println(solve(n,dp));
    }
}
