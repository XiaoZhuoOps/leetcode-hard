package algo.bin;

import java.util.Enumeration;

public class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, i = 0, j = n-1;
        while (i < m) {
            int left = 0, right = j;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (target <= matrix[i][mid]) right = mid;
                else left = mid + 1;
            }
            if (matrix[i][left] == target) return true;
            else {
                i++;
                j = left;
            }
        }
        return false;
    }
}
