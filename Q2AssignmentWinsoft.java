import java.util.Scanner;
public class Q2AssignmentWinsoft {
    public static int maxSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;

        int i = 0, j = 0;
        int sumX = 0, sumY = 0, result = 0;

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else {
                result += Math.max(sumX, sumY) + X[i];
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        while (i < m)
            sumX += X[i++];

        while (j < n)
            sumY += Y[j++];

        result += Math.max(sumX, sumY);

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of array X: ");
        int m = scanner.nextInt();
        int[] X = new int[m];
        System.out.println("Enter the elements of array X:");
        for (int i = 0; i < m; i++) {
            X[i] = scanner.nextInt();
        }

        System.out.print("Enter the length of array Y: ");
        int n = scanner.nextInt();
        int[] Y = new int[n];
        System.out.println("Enter the elements of array Y:");
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }

        int maxSum = maxSumPath(X, Y);

        System.out.println("The maximum sum path is: " + maxSum);

        scanner.close();
    }
}
