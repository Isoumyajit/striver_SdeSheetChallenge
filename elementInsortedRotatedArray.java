public class elementInsortedRotatedArray {
    public static int search(int arr[], int key) {
        // Write your code here.
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // System.out.println(arr[mid] + " "+arr[mid]);
            if (arr[mid] == key)
                return mid;
            if (arr[mid] >= arr[low]) {
                if (arr[low] <= key && arr[mid] >= key) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            } else {
                if (arr[high] >= key && arr[mid] <= key)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}