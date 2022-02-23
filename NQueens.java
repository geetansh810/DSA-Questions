import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static boolean isSafe(int row, int col, char[][] board){

        //horizontal check
        for(int i=0; i< board.length; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        //vertical check
        for(int i=0; i< board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //upper-left check
        for(int i = row, j = col; (i >= 0) && (j >= 0); i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //upper-right check
        for(int i = row, j = col; (i >= 0) && (j < board.length); i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //lower-left check
        for(int i = row, j = col; (i < board.length) && (j >= 0); i++, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //lower-right check
        for(int i = row, j = col; (i < board.length) && (j < board.length); i++, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;

    }

    public static void saveBoard(char[][] board, List<List<String>> allBoard){
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for(int i=0; i< board.length; i++){
            row = "";
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }
        allBoard.add(newBoard);
    }

    public static void helper(List<List<String>> allBoard, char[][] board, int col){

        if(col == board.length){
            saveBoard(board, allBoard);
            return;
        }

        for (int row=0; row<board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(allBoard, board, col+1);
                board[row][col] = '.';
            }
        }

    }

    public static void main(String[] args){
        List<List<String>> allBoard = new ArrayList<>();
        int n = 4;
        char[][] board = new char[n][n];

        helper(allBoard, board, 0);
        System.out.println("Total number of solutions = "+ allBoard.size());
        System.out.println(allBoard);

    }

}
