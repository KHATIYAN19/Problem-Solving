class Solution {
    public static int helper(int amount,int coins[],int idx,int dp[][]){
        if(amount==0){
            return 1;
        }
        if(amount<0||idx>=coins.length){
            return 0;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int pick=helper(amount-coins[idx],coins,idx,dp);
        int notpick=helper(amount,coins,idx+1,dp);
        return dp[idx][amount]=pick+notpick;
    }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int amount=sc.nextInt();
    int  arr[]=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    int dp[][]=new int[coins.length+1][amount+1];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
    }
    System.out.println(change(int amount, int[] arr));
  }
