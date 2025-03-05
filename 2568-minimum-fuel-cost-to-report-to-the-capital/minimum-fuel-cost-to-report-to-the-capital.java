class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;

        List<List<Integer>> cities = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cities.add(new ArrayList<>());
        }

        for (int[] r: roads) {
            cities.get(r[0]).add(r[1]);
            cities.get(r[1]).add(r[0]);
        }

        return helper(0, -1, cities, seats)[1];
    }

    public long[] helper(int curr, int parent, List<List<Integer>> cities, int seats) {
        long numPeople = curr == 0 ? 0 : 1;
        long fuel = 0;

        for (int c: cities.get(curr)) {
            if (c != parent) {
                long[] sub = helper(c, curr, cities, seats);
                numPeople += sub[0];
                fuel += sub[1];
            }
        }

        int cars = (int) Math.ceil(numPeople / (double) seats);
        if (curr != 0) fuel += cars;
        return new long[] {numPeople, fuel};
    }
}