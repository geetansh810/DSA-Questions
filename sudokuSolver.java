public class sudokuSolver {

    public static boolean isSafe(char[][] board, int row, int col, int number) {

        //horizontal vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }

        // box
        int strtRow = (row / 3) * 3;
        int strtCol = (col / 3) * 3;

        for (int i = strtRow; i < strtRow + 3; i++) {
            for (int j = strtRow; j < strtCol + 3; j++) {
                if (board[i][j] == (char) (number + '0')){
                    return false;
                }
            }
        }

        return true;

    }


    public static boolean helper(char[][] board, int row, int col) {

        if (row == board.length) {
            for(int i=0; i< board.length; i++){
                for(int j=0; j< board.length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }


        int nrow = 0;
        int ncol = 0;

        if (col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol)) {
                return true;
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {

                    board[row][col] = (char) (i + '0');

                    if (helper(board, nrow, ncol)) {
                        return true;
                    }
                    else {
                        board[row][col] = '.';
                    }

                }
            }

//            System.out.println(board[row][col]);


        }

        return false;


    }


    public static void solveSudoku(char[][] board) {

        helper(board, 0, 0);

    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);

    }


}
