package CPS209;
public class P2J1 {

    public static long fallingPower(int n, int k) {
        if (k == 0) {
            return 1; // n^0 = 1 for any nonzero integer n
        }
    
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= n; // Multiply the terms one by one to calculate the falling power
            n--; // Decrease the base for the next term
        }
    
        return result;
    }
    
    
    public static int[] everyOther(int[] arr) {
        int n = (arr.length + 1) / 2; // Calculate the length of the result array
        int[] result = new int[n];    // Create the result array
    
        for (int i = 0; i < n; i++) {
            result[i] = arr[i * 2];   // Store elements from even-numbered positions into the result array
        }
    
        return result;
    }
    
    
    public static int[][] createZigZag(int rows, int cols, int start) {
        int[][] result = new int[rows][cols];
        boolean descending = false;
        int currentNum = start;
    
        for (int i = 0; i < rows; i++) {
            if (descending) {
                for (int j = cols - 1; j >= 0; j--) {
                    result[i][j] = currentNum++;
                }
            } else {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = currentNum++;
                }
            }
            descending = !descending;
        }
    
        return result;
    }
    
    
    public static int countInversions(int[] arr) {
        int invCount = 0;
        int n = arr.length;
    
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    invCount++;
                }
            }
        }
    
        return invCount;
    }
    
}
