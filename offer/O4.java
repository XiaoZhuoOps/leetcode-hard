package offer;

/**
 * while(first > last)
     * binSearch matrix[r][yi] <= target vertically in [0,r],
     * then binSearch matrix[xi+1][yi+1] >= target horizontally in [c,m]
 */
public class O4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int n = matrix.length-1, m = matrix[0].length-1;
        //(r,c) 是当前节点坐标
        int r = n, c = 0;

        while(0<=r && c<=m){
            r = binSearchVertically(matrix, target, 0,r,c);
            if(r<0) return false;
            if(matrix[r][c] == target) return true;

            c = binSearchHorizontally(matrix, target, c,m,r);
            if(c>m) return false;
            if(matrix[r][c] == target) return true;
        }
        return false;
    }

    int binSearchVertically(int[][] matrix, int target, int left, int right, int col){
        //在[l,r]上搜索 matrix[r][c] <= target
        while(left<=right){
            //if left == right && matrxi[left] < target
            int mid = (left+right)/2;
            if(matrix[mid][col] == target) return mid;
            else if (matrix[mid][col] < target) left = mid+1;
            else if(matrix[mid][col] > target) right = mid-1;
        }
        //left = right+1, matrxi[right]<target<matrix[left]
        return right;
    }
    int binSearchHorizontally(int[][] matrix, int target, int left, int right, int row){
        //在[l,r]上搜索 matrix[r][c] >= target
        while(left<=right){
            //if left == right && matrxi[left] < target
            int mid = (left+right)/2;
            if(matrix[row][mid] == target) return mid;
            else if (matrix[row][mid] < target) left = mid+1;
            else if(matrix[row][mid] > target) right = mid-1;
        }
        //left = right+1, matrxi[right]<target<matrix[left]
        return left;

    }
}
