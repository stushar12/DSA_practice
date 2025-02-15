package BinarySearch;


import java.util.PriorityQueue;

public class FuelStations {

    static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int fuelStations = 4;
        System.out.println("Minimum value : " + MinimiseMaxDistance(arr, fuelStations));
    }

    public static double MinimiseMaxDistance(int[] arr, int fuelStations) {
        int n = arr.length; // size of array.
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            Pair pair = new Pair(diff, i);
            priorityQueue.offer(pair);
        }
        for (int i = 1; i <= fuelStations; i++) {
            Pair pair = priorityQueue.poll();
            int position = pair.second;
            double spaceAvailable = arr[position + 1] - arr[position];

            howMany[position]++;

            double diffLeft = spaceAvailable / (howMany[position] + 1);

            priorityQueue.offer(new Pair(diffLeft, position));

        }
        return priorityQueue.peek().first;
    }

    public static double OptimalApproachUsingBinarySearch(int[] arr, int fuelStations) {
        int n = arr.length; // size of array.
        double low = 0;
        double high = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            high = Math.max(high, diff);
        }
        double diffRange = 1e-6;
        while (high - low > diffRange) {
            double mid = (low + high) / 2.0;
            int count = numberOfGasStationsRequired(mid, arr);
            if (count > fuelStations) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }

    public static int numberOfGasStationsRequired(double mid, int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int diff = (int) ((arr[i] - arr[i - 1]) / mid);
            if ((arr[i] - arr[i - 1]) == (mid * diff)) {
                diff--;
            }
            count += diff;
        }
        return count;
    }

}


