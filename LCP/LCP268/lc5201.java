package LCP.LCP268;

public class lc5201 {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0, i = 0, temp = 0, len = plants.length;
        while (i < plants.length) {
            while (i < len && temp + plants[i] <= capacity) {
                steps++;
                temp += plants[i];
                i++;
            }
            if (i >= len) break;
            steps--;
            temp = 0;
            steps += (2*i + 1);
        }
        return steps;
    }
}

class Solution2 {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0, i = -1, temp = 0, len = plants.length;
        while (i < len) {
            while (i+1 < len && temp + plants[i+1] <= capacity) {
                temp += plants[i+1];
                steps++;
                i++;
            }
            if (i == len-1) return steps;
            temp = 0;
            steps += (2*i + 2);
        }
        return steps;
    }
}
