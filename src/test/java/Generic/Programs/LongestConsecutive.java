package Generic.Programs;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5};

        int maxCount = 1, count = 1;
        int maxElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
            {
                count++;
            } else
            {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                maxElement = arr[i];
            }
        }

        System.out.println("Number: " + maxElement + ", Count: " + maxCount);
    }
}
