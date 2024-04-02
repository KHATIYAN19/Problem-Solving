import java.util.*;
class BinaryTree {
    boolean issinglechild(int arr[]) {
      int n=arr.length;
        int next;
        int  last;
        for (int i = 0; i < n - 1; i++) {
            next = arr[i] - arr[i + 1];
            last = arr[i] - arr[n - 1];
            if (next * last < 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int arr[] = {8, 3, 5, 7, 6};
        if (issinglechild(arr) == true) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
