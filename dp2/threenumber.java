import java.util.*; 
class GFG { 
    public static int maximizeExpr(int a[], int n, int x,int y, int z) { 
        int L[] = new int[n]; 
        L[0] = x * a[0]; 
        for (int i = 1; i < n; i++)  
            L[i] = Math.max(L[i - 1], x * a[i]); 
        int R[] = new int[n]; 
        R[n - 1] = z * a[n - 1]; 
        for (int i = n - 2; i >= 0; i--) 
            R[i] = Math.max(R[i + 1], z * a[i]);  
        int ans = Integer.MIN_VALUE;  
        for (int i = 0; i < n; i++)  
            ans = Math.max(ans, L[i] + y * a[i] +  R[i]);  
        return ans; 
    } 
    public static void main(String[] args)  { 
    int a[] = {-1, -2, -3, -4, -5}; 
    int n = a.length; 
    int x = 1, y = 2 , z = -3; 
    System.out.println(maximizeExpr(a, n, x, y, z)); 
    } 
} 
