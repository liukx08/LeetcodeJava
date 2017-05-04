/**
 * Created by liukx08 on 5/4/2017.
 */
public class MatrixBinarySearch {
    // binary search
    public boolean search2DMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = 0, y = matrix[0].length - 1;
        while(x < matrix.length && y >= 0) {
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    // block search
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return helper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public boolean helper(int[][] matrix, int target, int startX, int startY, int endX, int endY) {
        if(startX > endX || startY > endY) {
            return false;
        }
        int midX = (startX + endX) >>> 1;
        int midY = (startY + endY) >>> 1;
        if(matrix[midX][midY] == target) {
            return true;
        }
        if(matrix[midX][midY] > target) {
            return helper(matrix, target, startX, startY, endX, midY - 1) || helper(matrix, target, startX, midY, midX - 1, endY);
        }
        return helper(matrix, target, midX + 1, startY, endX, midY) || helper(matrix, target, startX, midY + 1, endX, endY);
    }
}
