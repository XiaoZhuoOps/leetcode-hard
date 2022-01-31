package algo.sim;

public class lc2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        char[][] mat = new char[cols][rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                mat[i][j] = encodedText.charAt(index);
                index++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (i+j >= cols) break;
                sb.append(mat[i+j][j]);
            }
        }
        int size = sb.length() - 1;
        while (sb.charAt(size) == ' ') size--;
        return sb.toString().substring(0, size+1);
    }
}
