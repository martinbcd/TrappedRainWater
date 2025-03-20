public class Main {

    public static int calculateTrappedWater(int[] heights) {
        int n = heights.length;
        //if array is empty
        if (n == 0) return 0;
        //used to sum the amount of trapped water
        int waterTrapped = 0;

        //Used to store maximum values left and right of the current index
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(heights[i], leftMax[i - 1]);
        }

        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
        }

        //The two tallest "mountains" creates a "valley" between them I.E the maximum heights
        /*the amount of water that can be trapped is the lowest peak of these two mountains
         minus the height of the valley*/
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]) - heights[i];
            waterTrapped += waterLevel;
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped Water: " + calculateTrappedWater(heights));
    }
}