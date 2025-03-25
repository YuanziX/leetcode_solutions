class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> mergedX = new ArrayList<>();
        Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);

        mergedX.add(new int[] { rectangles[0][0], rectangles[0][2] });

        int ptrX = 0;
        for (int i = 1; i < rectangles.length; i++) {
            int[] intX = mergedX.get(ptrX);

            if (rectangles[i][0] < intX[1]) {
                intX[1] = Math.max(rectangles[i][2], intX[1]);
            } else {
                ptrX++;
                mergedX.add(new int[] { rectangles[i][0], rectangles[i][2] });
            }

        }

        int ptrY = 0;
        List<int[]> mergedY = new ArrayList<>();
        Arrays.sort(rectangles, (a, b) -> a[1] - b[1]);
        mergedY.add(new int[] { rectangles[0][1], rectangles[0][3] });

        for (int i = 1; i < rectangles.length; i++) {
            int[] intY = mergedY.get(ptrY);
            if (rectangles[i][1] < intY[1]) {
                intY[1] = Math.max(rectangles[i][3], intY[1]);
            } else {
                ptrY++;
                mergedY.add(new int[] { rectangles[i][1], rectangles[i][3] });
            }
        }

        return mergedX.size() > 2 || mergedY.size() > 2;
    }
}