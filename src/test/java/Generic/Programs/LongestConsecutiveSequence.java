package Generic.Programs;

public class LongestConsecutiveSequence
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5};
        int maxCount = 1, currentCount = 1;
        int maxElement = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1])
            {
                currentCount++;
            }
            else
            {
                currentCount = 1;
            }
            if (currentCount > maxCount)
            {
                maxCount = currentCount;
                maxElement = arr[i];
            }
        }

        System.out.println("Longest consecutive occurrence: " + maxElement + " (occurs " + maxCount + " times)");
    }
}
