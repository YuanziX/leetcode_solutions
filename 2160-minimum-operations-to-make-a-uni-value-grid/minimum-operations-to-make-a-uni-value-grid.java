class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> aux = new ArrayList<>();

        for (int[] i: grid) {
            for (int j: i) {
                aux.add(j);
            }
        }

        Collections.sort(aux);

        for (int v : aux) {
            if (Math.abs(v - aux.get(0)) % x != 0) {
                return -1;
            }
        }

        int median = aux.get(aux.size() / 2);
        int op = 0;

        for (int v : aux) {
            op += Math.abs(v - median) / x;
        }

        return op;
    }
}