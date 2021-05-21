import java.io.*;
import java.util.*;
//taken from https://www.geeksforgeeks.org/validity-of-a-given-tic-tac-toe-board-configuration/
class TicTacToe {
    static int cntOfWins;
    static int win[][] = {{0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}};

    static boolean isCWin(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (board[win[i][0]] == c
                    && board[win[i][1]] == c
                    && board[win[i][2]] == c) {
                cntOfWins++;
                return true;
            }
        }
        return false;
    }

    static boolean isValid(char[] board) {
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == 'X') {
                xCount++;
            }
            if (board[i] == 'O') {
                oCount++;
            }
        }
        if (xCount == oCount || xCount == oCount + 1) {
            if (isCWin(board, 'O')) {
                if (isCWin(board, 'X')) {
                    return false;
                }
                return (xCount == oCount);
            }
            return !isCWin(board, 'X') || xCount == oCount + 1;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            cntOfWins = 0;
            char [] matrix = new char[9];
            int o = 0, x = 0;
            int pos = 0;
            for (int i = 0; i < 3; i++) {
                char [] inp = buffer.readLine().toCharArray();
                for (int j = 0; j < 3; j++,pos++) {
                    matrix[pos] = inp[j];
                    if (matrix[pos] == 'X')
                        x++;
                    else if (matrix[pos] == 'O')
                        o++;
                }
            }
            if (!isValid(matrix))
                sb.append(3+"\n");
            else {
                if (o+x < 9 && cntOfWins == 0)
                    sb.append(2+"\n");
                else
                    sb.append(1+"\n");
            }
        }
        System.out.println(sb);
    }
}
