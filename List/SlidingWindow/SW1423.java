package List.SlidingWindow;

public class SW1423{
    //error1 16
    //思维不严密 逻辑不够底层
    public int maxScore(int[] cardPoints, int k) {
        int curSum = 0, left = 0, right = cardPoints.length;
        int maxSum = 0;

        if(cardPoints[0] < cardPoints[right-1]) {
            curSum+=cardPoints[right-1];
            right--;
        }
        else  {
            curSum+=cardPoints[left];
            left++;
        }

        int wl = left, wr = wl + k-2;
        for(int i = wl; i <= wr; i++) curSum+=cardPoints[i];
        maxSum = curSum;

        while(wr+1 < right){
            wl++;
            wr++;  // right-1
            curSum += (cardPoints[wr] - cardPoints[wl-1]);
            if(curSum > maxSum) maxSum = curSum;
        }
        return maxSum;
    }
}