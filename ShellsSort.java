import java.util.Arrays;

public class ShellsSort {
    // Main ShellSort method 
    public static void shellSort(int[] arr, String gapType) {
        int n = arr.length;
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
            for(int i = gap; i < n; i++) {
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

    //Shell's gaps
    private static int[] shellGaps(int n) {
        int gap = n/2;
        int[] temp = new int[32];
        int k = 0;
        while(gap > 0) {
            temp[k++] = gap;
            gap /= 2;
        }
        return Arrays.copyOf(temp, k);
    }

    //Kuth's gaps
    private static int[] knuthGaps(int n) {
        int h = 1;
        while ( h < n/3 ) {
            h = 3 * h + 1;
        }
        int temp[] = new int[40];
        int k = 0;
        while ( h > 0 ){
            temp[k++] = h;
            h = (h - 1) / 3;
        }
        return Arrays.copyOf(temp, k);
    }

    //Sedgewick's gaps
    private static int[] sedgewickGaps(int n){
        int[] temp = new int[40];
        int k = 0;
        int gap;
        for (int i = 0; ; i++) {
            gap = (int) (9 * (Math.pow(4, i)) - 9 * Math.pow(2, i) + 1);
            if (gap >=n ) break;
            temp[k++] += gap;
            gap = (int) ((Math.pow(4, i + 1)) - 3 * Math.pow(2, i + 1) + 1);
            if (gap >=n ) break;
            temp[k++] += gap;
        }
        int[] gaps = new int[k];
        for (int i = 0; i < k; i++) gaps[i] = temp[k - 1 - i];
        return gaps;
    }
} 