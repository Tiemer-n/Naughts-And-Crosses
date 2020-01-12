package tictactoe;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {

    public static int run = 0;
    public static Scanner input = new Scanner(System.in);
    public static String[][] board = new String[3][3];
    public static boolean isVisualised = false;

            //--------------------------------------------------
            //the easy algorithm is on lines 267 - 281
            //the impossible algorithm is on lines 283 - 377
            //--------------------------------------------------
    
    public static void main(String[] args) throws InterruptedException, IOException {
        intro();
    }
    
    public static void intro() throws InterruptedException, IOException{
        TimeUnit unit = TimeUnit.MILLISECONDS;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "{ }";
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }

        System.out.println("Welcome to Naughts and Crosses ");
        unit.sleep(2000);
        System.out.println("This is against the computer ");
        unit.sleep(2000);
        System.out.println("Pick your diffuculty: Easy(e) or Impossible(i)");

        OUTER:
        while (true) {
            System.out.print("Input:");
            String difficulty = input.next();
            System.out.println("");
            if (null == difficulty) {
                System.out.println("Incorrect input...");
            } else {
                switch (difficulty) {
                    case "e":
                        run=1;
                        break OUTER;
                    case "i":
                        run=0;
                        System.out.println("Would you like to visualise it? (it will take a lot longer) (y/n): ");
                        while (true){
                            System.out.print("Input: ");
                            String visualise = input.next();
                            System.out.println("");
                            if("y".equals(visualise)){
                                isVisualised = true;
                                break;
                            }else if ("n".equals(visualise)){
                                isVisualised = false;
                                break;
                            }else{
                                System.out.println("Incorrect input...");
                            }
                        }
                        break OUTER;
                    default:
                        System.out.println("Incorrect input...");
                        break;
                }
            }
        }
        ClearBox();
        unit.sleep(500);
        PrintInstructions();
        //uncomment this to allow the computer to go first (though it does ruin the user end experience)
//         if (run > 0) {
//            Easy();
//        } else if (run == 0) {
//            Hard();
//        }
//        
//         
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(board[i][j]);
//            }
//            System.out.println("");
//        }
        InputPlace();
    }
    
    
    public static void GameOver() throws InterruptedException, IOException{
        
        System.out.println("");
        System.out.println("Would you like to play again? (y/n)");
        
        String answer;
        while (true){
            System.out.print("Input: ");
            answer = input.next();
            System.out.println("");
            if(null == answer){
                System.out.println("Incorrect input...");
            }else switch (answer) {
                case "y":
                    
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            board[i][j] = "{ }";
                        }
                    }
                    ClearBox();
                    TimeUnit.MILLISECONDS.sleep(300);
                    System.out.println("Pick your diffuculty: Easy(e) or Impossible(i)");

                    OUTER:
                    while (true) {
                        System.out.print("Input:");
                        String difficulty = input.next();
                        System.out.println("");
                        if (null == difficulty) {
                            System.out.println("Incorrect input...");
                        } else {
                            switch (difficulty) {
                                case "e":
                                    run=1;
                                    break OUTER;
                                case "i":
                                    run=0;
                                    System.out.println("Would you like to visualise it? (it will take a lot longer) (y/n): ");
                                    while (true){
                                        System.out.print("Input: ");
                                        String visualise = input.next();
                                        System.out.println("");
                                        if("y".equals(visualise)){
                                            isVisualised = true;
                                            break;
                                        }else if ("n".equals(visualise)){
                                            isVisualised = false;
                                            break;
                                        }else{
                                            System.out.println("Incorrect input...");
                                        }
                                    }
                                    break OUTER;
                                default:
                                    System.out.println("Incorrect input...");
                                    break;
                            }
                        }
                    }
                    ClearBox();
                    TimeUnit.MILLISECONDS.sleep(500);
                    PrintInstructions();
                    
                    InputPlace();
                    break;
                    
                case "n":
                    System.out.println("Ok goodbye!...");
                    TimeUnit.MILLISECONDS.sleep(2000);
                    System.exit(0);
                default:
                    System.out.println("Incorrect input...");
                    break;
            }       
        }   
    }

    public static void PrintInstructions() {
        System.out.println("Inputs: ");
        System.out.println("{ tl} { mt} { tr}");
        System.out.println("{ ml} { m } { mr}");
        System.out.println("{ bl} { mb} { br}");
        for (int i = 0; i < 7; i++) {
            System.out.println("");
        }
    }

    public static void InputPlace() throws InterruptedException, IOException {
        TimeUnit unit = TimeUnit.MILLISECONDS;

        OUTER:
        while (true) {
            System.out.print("Input go: ");
            String place = input.next();
            int i;
            int j;

            if (null == place) {
                System.out.println("Incorrect input...");
                continue;
            } else {
                switch (place) {
                    case "tl":
                        i = 0;
                        j = 0;
                        break;
                    case "mt":
                        i = 0;
                        j = 1;
                        break;
                    case "tr":
                        i = 0;
                        j = 2;
                        break;
                    case "ml":
                        i = 1;
                        j = 0;
                        break;
                    case "m":
                        i = 1;
                        j = 1;
                        break;
                    case "mr":
                        i = 1;
                        j = 2;
                        break;
                    case "bl":
                        i = 2;
                        j = 0;
                        break;
                    case "mb":
                        i = 2;
                        j = 1;
                        break;
                    case "br":
                        i = 2;
                        j = 2;
                        break;
                    default:
                        System.out.println("Incorrect input...");
                        continue;
                }
            }

            if (!"{ }".equals(board[i][j])) {
                System.out.println("Place is already taken");
            } else {
                board[i][j] = "{X}";
                break;
            }

        }

        ClearBox();
        unit.sleep(200);
        PrintInstructions();

        System.out.println("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }

        CheckSystem(0);

        System.out.println("Computer is calcualting a place...");
        unit.sleep(2000);
        ClearBox();
        unit.sleep(100);

        if (run > 0) {
            Easy();
        } else if (run == 0) {
            Hard();
        }

        PrintInstructions();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        CheckSystem(0);

        InputPlace();

    }

    public static void Easy() {
        // just picks a random avaliable spot and places its go there
        // if you lose to this you might just have gotten unlucky or you're just really bad
        Random rand = new Random();
        while (true) {
            int i = rand.nextInt(3);
            int j = rand.nextInt(3);

            if (!"{ }".equals(board[i][j])) {
            } else {
                board[i][j] = "{O}";
                break;
            }
        }
    }

    public static void Hard() throws InterruptedException, IOException {

        //this algorithm is the 'minimax algorithm' used in finding the most optimal place in tic tac toe
        // it places a theoretical place in the next avaliable spot
        // and then sees if that spot will either allow the coputer to win or you to win
        
        // if there are still avaliable spots in the next iteration and no one has won it will recall the method 
        // it will run it again until somone wins or if its a tie
        // each iteration will return a positive score depending if the computer won this iteration
        
        // if you won in that specific iteration it will return a negative score
        // the iteration with the largest returned score will be the place of which the computer will place its next go :) 
        int bestScore = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ("{ }".equals(board[i][j])) {

                    board[i][j] = "{O}";
                    if(isVisualised){
                        PrintBoard();
                    }
                    int score = minimax(0, false);
                    board[i][j] = "{ }";
                    if (score > bestScore) {
                        bestScore = score;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        board[x][y] = "{O}";
        if(isVisualised){
            PrintBoard();
            System.out.println("^ This is the optimal move");
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println("Press l + enter to continue...");
            String Buffer = input.next();
            ClearBox();
            TimeUnit.MILLISECONDS.sleep(300);
        }
        
    }
    
    public static void PrintBoard(){
//        for (int i = 0; i < 3; i++) {
//            System.out.println("");
//        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        
    }
    

    public static int minimax(int depth, boolean isMaximising) throws InterruptedException, IOException {
        String result = CheckSystem(1);
        if (!"-1".equals(result)) {
            if (null != result) {
                switch (result) {
                    case "{X}":
                        if(isVisualised){
                            System.out.println("{X} is the winner");
                            for (int i = 0; i < 3; i++) {
                                System.out.println("");
                            }
                        }
                        return -10;
                    case "{O}":
                        if(isVisualised){
                            System.out.println("{O} is the winner"); 
                            for (int i = 0; i < 3; i++) {
                                System.out.println("");
                            }
                        }
                        return 10;
                    case "tie":
                        if(isVisualised){
                            System.out.println("Tie!");   
                            for (int i = 0; i < 3; i++) {
                                System.out.println("");
                            }
                        }
                        return 0;
                    default:
                        break;
                }
            }

        }
        if (isMaximising) {
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //is the spot avaliable?
                    if ("{ }".equals(board[i][j])) {
                        board[i][j] = "{O}";
                        if(isVisualised){
                            PrintBoard();
                        }
                        int score = minimax(depth++, false);
                        board[i][j] = "{ }";

                        if (score > bestScore) {
                            bestScore = score;

                        }
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    //is the spot avaliable?
                    if ("{ }".equals(board[i][j])) {
                        board[i][j] = "{X}";
                        if(isVisualised){
                            PrintBoard();
                        }
                        int score = minimax(depth++, true);
                        board[i][j] = "{ }";

                        if (score < bestScore) {
                            bestScore = score;

                        }
                    }
                }
            }
            return bestScore;
        }

    }

    public static String CheckSystem(int function) throws InterruptedException, IOException {

        //the difference between the two function numbers is 0 means its checking who won and exits the system if that happends
        //and function 1 means that is returns the outcome of the board "tie" "X" or "O" (only used in hard mode)
        String winner = null;

        //horizontal
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && board[i][0].equals(board[i][2]) && !"{ }".equals(board[i][0])) {
                winner = board[i][0];
            }
        }

        //veritcal
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && board[0][i].equals(board[2][i]) && !"{ }".equals(board[0][i])) {
                winner = board[0][i];
            }
        }

        //diagonal
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[0][0].equals(board[2][2]) && !"{ }".equals(board[0][0])) {
            winner = board[0][0];
        }

        if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && board[2][0].equals(board[0][2]) && !"{ }".equals(board[2][0])) {
            winner = board[2][0];
        }

        if (function == 0) {
            if (winner != null) {
                System.out.println("");
                System.out.println(winner + " is the winner!");
                GameOver();
            }
        } else if (function == 1) {
            if (winner != null) {
                return winner;
            }

        }

        int check = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ("{ }".equals(board[i][j])) {
                    check++;
                }
            }
        }

        if (function == 0) {
            if (check == 0) {
                System.out.println("");
                System.out.println("Tie");
                GameOver();
            }
        } else if (function == 1) {
            if (check == 0) {
                return "tie";
            }
        }

        return "-1";

    }

    public static void ClearBox() {
        try {
            Robot robot = new Robot();
            //press
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            //release
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);

        } catch (AWTException e) {
        }
    }

}
