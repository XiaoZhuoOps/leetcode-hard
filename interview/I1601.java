package interview;
/*
    a = a^b
    b = b^a = a
    a = a^b = a^b^a = b
 */
public class I1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0]^numbers[1];
        numbers[1] = numbers[1]^numbers[0];
        numbers[0] = numbers[0]^numbers[1];
        return numbers;
    }
}
