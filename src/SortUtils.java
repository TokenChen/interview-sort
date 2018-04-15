public class SortUtils {
    public static int swapSteps = 0;
    public static void selectSort(int[] data){
        if (data == null || data.length == 0){
            System.out.println("data is empty");
            return;
        }
        int length = data.length;
        int minDataIndex = 0;
        for (int i = 0; i < length; i++ ){
            minDataIndex = i;
            for (int j = i; j < length; j++ ){
                if( data[minDataIndex] > data[j]){
                    minDataIndex = j;
                }
            }
            int temp = data[i];
            data[i] = data[minDataIndex];
            data[minDataIndex] = temp;
        }
        printSortedArray(data);
    }

    public static void insertSort(int[] data, int stepLenth){
        swapSteps = 0;
        if(data == null || data.length == 0){
            System.out.println("raw data is empty");
            return;
        }
        if(data.length == 1){
            System.out.println("raw data is sorted");
            return;
        }
        for(int i = 0; i < data.length - stepLenth; i+=stepLenth ){
            for (int j = i+stepLenth ; j > 0; j-=stepLenth){
                if( data[j] > data[j - stepLenth]){
                    swapData(data, j, j-stepLenth);
                }
            }
        }

        printSortedArray(data);

    }

    public static void shellSort(int[] data){
        swapSteps = 0;
        if(data == null || data.length == 0){
            System.out.println("raw data is empty");
            return;
        }
        int stepLength = data.length / 2;
        while (stepLength > 0){
            System.out.println(stepLength);
            insertSort(data, stepLength);
            stepLength /= 2;
        }

        printSortedArray(data);
        System.out.println("swap steps is:" + swapSteps);
    }

    public static void quickSort(int[] data, int start, int end){
        if(data == null || data.length == 0){
            System.out.println("raw data is empty");
            return;
        }
        if(start < 0 || end > data.length || end < 0 || start > data.length || start > end){
            System.out.println("index is invalid");
            return;
        }
        if(start == end ) return;
        int i = start, j = end;
        for( ; i < j;){
            while ( data[j] > data[i]){
                j--;
            }
            if (i == j) break;
            swapData(data, i, j);
            i++;
            while ( data[i] < data[j]){
                i++;
            }
            if (i == j) break;
            swapData(data, i,j);
            j--;
        }
        System.out.println("i is:" + i + " j is:" + j + " start is:" + start + " end is:" + end);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        quickSort(data, start, i -1);
        quickSort(data, i + 1, end);
    }

    private static void swapData(int[] data, int i, int j){
        if(data == null || data.length < i || data.length < j){
            System.out.println("data is invalid");
            return;
        }
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        swapSteps ++;
        return;
    }

    public static void printSortedArray(int[] data){
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + ", ");
        }
        System.out.println();
        System.out.println("swap setps is:" + swapSteps);
    }
}
