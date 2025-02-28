package Generic.Programs;

public class SmallestNumber {
    public static void main(String[] args) {
        int[] arr = {10, 25, 3, 99, 45, 67};

        int min = arr[0]; // Assume first element is the smallest

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i]; // Update min if a smaller number is found
            }
        }

        System.out.println("Smallest number: " + min);
    }
}
