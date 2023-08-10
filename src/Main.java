import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> player1position = new ArrayList<>();
    static ArrayList<Integer> player2position = new ArrayList<>();

    public static void main(String[] args) {

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("Player1 choose a position from 1 to 9 :");
            int player1Position = scanner.nextInt();
            choosePosition(gameBoard, player1Position , "Player1");
            printGameBoard(gameBoard);
            System.out.println("Player2 choose a position from 1 to 9 :");
            int player2Position = scanner.nextInt();
            choosePosition(gameBoard , player2Position , "Player2");
            printGameBoard(gameBoard);
            String status = checkStatus();
            System.out.println(status);

        }

    }







    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char character : row) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    public static void choosePosition(char[][] gameBoard, int position, String player){
        char symbol = ' ';

        if(player.equals("Player1")) {
            symbol = 'X';
            player1position.add(position);
        }else if(player.equals("Player2")) {
            symbol = 'O';
            player2position.add(position);
        }

        switch (position) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
        }

    }


    public static String checkStatus(){
      List firstLine = Arrays.asList(1 , 2 , 3);
      List secondLine = Arrays.asList(4 , 5 , 6);
      List thirdLine = Arrays.asList(7 , 8 , 9);
      List firstColumn = Arrays.asList(1 , 4 , 7);
      List secondColumn = Arrays.asList(2 , 5 , 8);
      List thirdColumn= Arrays.asList(3 , 6 , 9);
      List firstDiagonal = Arrays.asList(1 , 5 , 9);
      List secondDiagonal = Arrays.asList(7 , 5 , 3);

      List<List> win = new ArrayList<List>();
      win.add(firstLine);
      win.add(secondLine);
      win.add(thirdLine);
      win.add(firstColumn);
      win.add(secondColumn);
      win.add(thirdColumn);
      win.add(firstDiagonal);
      win.add(secondDiagonal);

      for(List list: win) {
          if(player1position.containsAll(win)){
              return "Player1 won the game";
          }else if(player2position.containsAll(win)){
              return "Player2 won the game";
          }else if(player1position.size() + player2position.size() == 9  ){
              return "Draw";
          }
      }


        return" ";
    }




}