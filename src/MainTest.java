public class MainTest {
    public static void main(String[] args){
        int[] rawData = new int[]{4, 8, 2, 9, 5, 6, 3, 1, 10};
        SortUtils.quickSort(rawData, 0, rawData.length -1);
        SortUtils.printSortedArray(rawData);
    }
}
