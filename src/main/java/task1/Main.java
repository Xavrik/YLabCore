package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main (String[] args){
        int n = 0;
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        System.out.println("Введите длинну массивов:");
        
        try {
             n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        int[][] array = new int[n][n];
        int num = 0;
        int high = 100000000;
        int low = 100;
        int medium =0;
       
        //Двойной массив
        for (int i=0;i < array.length;i++) {
            for (int j=0;j < array[i].length;j++) {
                //генератор чисел 1
                int time = (int)(System.currentTimeMillis()%high)%low;
                //Проверка на одинковые элементы\
                for (int a=0;a < array.length;a++) {
                    for (int b = 0; b < array[i].length; b++) {
                        if (array[a][b] != time) {
                            int time2 = (int) (System.currentTimeMillis() / high) / low;
                            low++;
                            high = high + low;
                            array[i][j] = time2 ;

                        }
                    }
                }
                //Второе рандомное число\
                array[i][j] = time;
                low++;
                high=high-low;

            }
        }

        System.out.println("Массив наполнен сгенерированными числами:");
        for (int i=0;i < array.length;i++,System.out.println()) {
            for (int j=0;j < array[i].length;j++) {
                System.out.print(array[i][j]+" ");
            }
        }
        System.out.println("...........");

        System.out.println("Массив отсортрован:");
        for ( int r = 0; r < array.length; ++r ) {
            for ( int c = 0; c < array[r].length; ++c ) {
                int lastC = c + 1;
                for ( int lastR = r; lastR < array.length; ++lastR ) {
                    while ( lastC < array[lastR].length) {
                        if ( array[lastR][lastC] < array[r][c] ) {
                            int tmp = array[r][c];
                            array[r][c] = array[lastR][lastC];
                            array[lastR][lastC] = tmp;
                        }
                        ++lastC;
                    }
                    lastC = 0;
               }
            }
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            medium++;
        }

        System.out.println("...........");
        System.out.println("Максимальное число в массиве:");
        System.out.println(Arrays.toString(new int[]{array[array.length - 1][array.length - 1]}) );
        System.out.println("Среднее число в массиве:");
        System.out.println(Arrays.toString(new int[]{array[medium/2][medium/2]}));
        System.out.println("Минимальное  число в массиве:");
        System.out.println(Arrays.toString(new int[]{array[0][0]}));


    }

}

