package Generic.Programs;

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {10, 25, 78, 99, 45, 67};

        int max = arr[0]; // Assume first element is the largest

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if a larger number is found
            }
        }

        System.out.println("Largest number: " + max);
    }
}
