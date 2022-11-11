
import java.util.Random;
import java.util.Scanner;// библ для ввода с клавиатуры

public class Main {

    public static void Print(int[][] A) {
        int m = A[0].length;//длина
        int n = A.length;// высота

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }

            System.out.println(" ");
        }
    }

    public static int[][] Gen(int n, int m) {
        Random random = new Random();


        int[][] A = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //A[i][j] =10+ random.nextInt(90);
                A[i][j] = i * 10 + j;

            }
        }
        return A;

    }

    public static int[][] Rot(int[][] a) {
        int n = a.length - 1;
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int x4 = 0;
        int d = 0;

        for (int h = 0; h <= n / 2; h++) {
            if (h % 4 == 0) {
                d = n - h;

                for (int k = 0; k < n - 2 * h; k++) {
                    // h- лев конец d прав верх
                    x1 = a[h][h + k];
                    x2 = a[d - k][h];
                    x3 = a[d][d - k];
                    x4 = a[h + k][d];

                    a[h][h + k] = x4;
                    a[d - k][h] = x1;
                    a[d][d - k] = x2;
                    a[h + k][d] = x3;

                }

            }
            if (h % 4 == 1) {
                d = n - h;

                for (int k = 0; k < n - 2 * h; k++)//2*(d-h)-1
                {
                    x1 = a[h][h + k];

                    x3 = a[d][d - k];

                    a[h][h + k] = x3;
                    a[d][d - k] = x1;


                }
                for (int k = 0; k < n - 2 * h; k++)//2*(d-h)-1
                {
                    x1 = a[h + k][d];

                    x3 = a[d - k][h];

                    a[h + k][d] = x3;
                    a[d - k][h] = x1;


                }

            }
            if (h % 4 == 2) {
                d = n - h;

                for (int k = 0; k < n - 2 * h; k++) {
                    // h- лев конец d прав верх
                    x1 = a[h][h + k];
                    x2 = a[d - k][h];
                    x3 = a[d][d - k];
                    x4 = a[h + k][d];

                    a[h][h + k] = x2;
                    a[d - k][h] = x3;
                    a[d][d - k] = x4;
                    a[h + k][d] = x1;

                }

            }

        }
        return a;


    }

    private static Scanner inn = new Scanner(System.in);// метод для ввода с клавиатуры

    public static <string> void main(String[] args) {

        int[][] A = Gen(10, 10);
        Print(A);
        System.out.println();
        Print(Rot(A));
    }
}
