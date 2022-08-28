import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        int[] array;
        String line;
        int length  = 0;
        int n = 0;

        System.out.println("Введите длинну массивов:");
        try {
            line = reader.readLine();
            length = Integer.parseInt(line);
            array = new int[length];
        }catch (Exception e) {
            System.out.println("Вы не ввели длину массива, массив будет заполнен по умолчанию");
            array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};

        }
        try{
            System.out.println("Введите данные в массив с новой строки:");
            for(int i =0; i < length; i++){
                line = reader.readLine();
                array[i] = Integer.parseInt(line);
            }

        }catch (Exception e){
            System.out.println("Вы не ввели данные для массива, массив будет заполнен по умолчанию");
            array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        }
        System.out.println("Массив в начале");
        System.out.println(Arrays.toString(array));

        quickSort(array,0, array.length-1 );
        System.out.println("Отсортированный массив");
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}