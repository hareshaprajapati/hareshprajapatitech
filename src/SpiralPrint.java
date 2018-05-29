import java.util.Dictionary;

/*
1 2 3 4 5 6
7 8 9 10 11 12
13 14 15 16 17 18
19 20 21 22 23 24
solution
1 2 3 4 5 6
12 18 24
23 22 21 20 19
13 7
8 9 10 11
17
16 15 14

 */
enum DIRECTION{
    RIGHT,DOWN,LEFT,TOP
}
public class SpiralPrint
{

    // Function print matrix in spiral form
    static void spiralPrint(int matrix[][])
    {
    	if(matrix.length == 0)
            return;
        // Initialize our four indexes
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
    
        while(true)
        {
            // Print top row
            for(int j = left; j <= right; j++) System.out.print(matrix[top][j] + " ");
            System.out.println();
            top++;
            if(top > down || left > right) break;
            //Print the rightmost column
            for(int i = top; i <= down; i++) System.out.print(matrix[i][right] + " ");
            System.out.println();
            right--;
            if(top > down || left > right) break;
            //Print the bottom row
            for(int j = right; j >= left; j--) System.out.print(matrix[down][j] + " ");
            System.out.println();
            down--;
            if(top > down || left > right) break;
            //Print the leftmost column
            for(int i = down; i >= top; i--) System.out.print(matrix[i][left] + " ");
            System.out.println();
            left++;
            if(top > down || left > right) break;
        }

    }

    static void spiralPrint2(int matrix[][])
    {
        if(matrix.length == 0)
            return;
        // Initialize our four indexes
        int top = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        DIRECTION   direction = DIRECTION.RIGHT;
        int row=0,col=0;
        int elementToPrint = matrix.length * matrix[0].length;
        System.out.println("elementToPrint " + elementToPrint);
        while (elementToPrint != 0){
            System.out.print(matrix[row][col] + " ");
            elementToPrint--;
            if(direction == DIRECTION.RIGHT){
                if(++col > right){
                    --col;
                    direction = DIRECTION.DOWN;
                    row++;
                    top++;
                }
            }else if(direction == DIRECTION.DOWN){
                if(++row > down){
                    --row;
                    direction = DIRECTION.LEFT;
                    col--;
                    right--;
                }
            }else if(direction == DIRECTION.LEFT){
                if(--col < left){
                    col++;
                    direction = DIRECTION.TOP;
                    row--;
                    down--;
                }
            }else if(direction == DIRECTION.TOP){
                if(--row < top){
                    row++;
                    direction = DIRECTION.RIGHT;
                    col++;
                    left++;

                }
            }
        }

    }

     
    // driver program
    public static void main (String[] args) 
    {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18},
                      {19, 20, 21, 22, 23, 24}
                    };
        for(int i =0;i<a.length;i++){
        	for(int j=0;j<a[0].length;j++){
        		System.out.print(a[i][j] + " ");
        	}
        	System.out.println(" ");
        }
        System.out.println("solution ");
        spiralPrint(a);
    }
}