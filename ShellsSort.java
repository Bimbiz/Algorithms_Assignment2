import java.util.Arrays;

public class ShellsSort {
    // Main ShellSort method 
    public static void shellSort(int[] arr, String gapType) {
        int n = arr.Length;
        int[] gaps;
        // Choosing gap sequense
        switch (gapType.toLowerCase()) {
            case "knuth" :
            gaps = knuthGaps(n);
            break;
            case "sedgewick" :
            gaps = sedgewickGaps(n);
            break;
            default:
            gaps = shellGaps(n);
        }
        System.out.println("Using " + gapType + " gaps: " + Arrays.toString(arr));
        // ShellSort
        for(int gap : gaps) {
            if(gap <= 0) continue; // Protection from 0 and negative values
            for(int i = gap; i < n, i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }
} 