package basic.bit;

public class lc318 {
    public int maxProduct(String[] words) {
        int [] wordNum = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordNum[i] |= (words[i].charAt(j) - 'a');
            }
        }
        int max = -1;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((wordNum[i] & wordNum[j]) != 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
