/**
 * Created by EZDI\haresh.p on 14/8/17.
 */
public class CountRegionOf1 {

    public static void main(String[] args) {
        int a[][] = {
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int cp[][] = {
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1}
        };
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(cp[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1 && cp[i][j] != 0) {
                    count++;
                    cp[i][j] = 0;
                    getNearCount(a, i, j , cp);
                    for (int k = 0; k < a.length; k++) {
                        for (int l = 0; l < a.length; l++) {
                            System.out.print(cp[k][l] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int getNearCount(int[][] a, int i, int j, int[][] cp) {
        int result = 0;
        for (int k = j; k < a.length; k++) {
            if (a[i][k] == 1 ) {
                if (cp[i][k] != 0) {
                    result = 1;
                    cp[i][k] = 0;
                }

            } else {
                break;
            }
        }

        for (int k = i; k < a.length; k++) {
            if (a[k][j] == 1 ) {
                if (cp[k][j] != 0) {
                    result = 1;
                    cp[k][j] = 0;
                }

            } else {
                break;
            }
        }
        for (int k = i + 1, p = j-1; k < a.length && p > 0; k++,p--) {
            if (p>0 && a[k][p] == 1 ) {
                if(cp[k][p] != 0){
                    result = 1;
                    cp[k][p] = 0;
                }

            } else {
                break;
            }
        }
        return result;
    }
}
