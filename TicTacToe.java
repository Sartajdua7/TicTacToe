package homework4;

import java.util.Scanner;

public class TicTacToe implements Player{
	
	static int[][] board = new int[3][3];
	static Scanner scan = new Scanner(System.in);
	static int numOfTurns;
	static TicTacToe obj = new TicTacToe();
	
	public static void main(String[] args) {
		while(!isFinished()) {
			printBoard();
			String input = scan.nextLine();
			String comp = obj.move(input);
			int firstComp = Character.getNumericValue(comp.charAt(0));
			int secondComp = Character.getNumericValue(comp.charAt(1));
			board[firstComp][secondComp] = 2;
		}
		printBoard();
	}
	public static void printBoard() {
		String status = "";
		for(int i = 0; i < board.length; i++) {
			for(int r = 0; r < board[i].length; r++) {
				switch(board[i][r]){
					case 0:
						status = " ";
						break;
					case 1:
						status = "O";
						break;
					case 2:
						status = "X";
						break;
				}
				if(r == 0 || r == 1) {
					System.out.print(status + "|");
				}
				else {
					System.out.println(status);
				}
			}
		}
	}
	@Override
	public String move(String move) {
		
		if(move == null) {
			numOfTurns++;
			return "11";
		}
		else {
			//System.out.println(Character.valueOf(move.charAt(0)));
			//System.out.println(Character.valueOf(move.charAt(1)));
			int firstNumber = Character.getNumericValue(move.charAt(0));
			int secondNumber = Character.getNumericValue(move.charAt(1));
			board[firstNumber][secondNumber] = 1;
			numOfTurns++;
		
			if(numOfTurns == 1) {
				if(board[0][0] == 1) {
					return "22";
				}
				else if(board[2][0] == 1) {
					return "02";
				}
				else if(board[0][2] == 1) {
					return "20";
				}
				else if(board[2][2] == 1) {
					return "00";
				}
				else if(board[1][1] == 0) {
					return "11";
				}
				else {
					return "00";
				}
			}
			if(numOfTurns >= 2) {
				for(int i = 0; i < board.length; i++) {
					if(board[i][0] == 2 && board[i][2] == 2 && board[i][1] == 0) {
						return i + "1";
					}
					if(board[0][i] == 2 && board[2][i] == 2 && board[1][i] == 0) {
						return "1" + i;
					}
				}
				for(int i = 0; i < board.length-1; i++) {
					for(int r = 0; r < board.length; r++) {
						if(board[r][i] == 2 && board[r][i+1] == 2) {
							if(i == 1 && board[r][0] == 0) {
								return r + "0";
							}
							else if(i+2 <= 2) {
								if(board[r][i+2] == 0){
								return Integer.toString(r) + (i+2);
								}
						}
						}
						if(board[i][r] == 2 && board[i+1][r] == 2) {
							if(i == 1 && board[0][r] == 0) {
								return "0" + r;
							}
							else if(i+2 <= 2) {
								if(board[i+2][r] == 0){
								String temp = Integer.toString(i+2);
								String temp2 = Integer.toString(r);
								return temp + temp2;
								}
						}
						}
					}}
				for(int i = 0; i < board.length-1; i++) {
					for(int r = 0; r < board.length; r++) {
						
						if(board[r][i] == 1 && board[r][i+1] == 1) {
							if(i == 1 && board[r][0] == 0) {
								return r + "0";
							}
							else if(i+2 <= 2) {
								if(board[r][i+2] == 0){
									return Integer.toString(r) + (i+2);
								}
							}
						}
						if(board[i][r] == 1 && board[i+1][r] == 1) {
							if(i == 1 && board[0][r] == 0) {
								return "0" + r;
							}
							else if(i+2 <= 2) {
								if(board[i+2][r] == 0){
									return Integer.toString(i+2) + r;
								}
						}
						}
					}
				}

				for(int i = 0; i < board.length; i++) {
					if(board[i][0] == 1 && board[i][2] == 1 && board[i][1] == 0) {
						return i + "1";
					}
					if(board[0][i] == 1 && board[2][i] == 1 && board[1][i] == 0) {
						return "1" + i;
					}
				}
				
				
				if(board[0][0] == 2 && board[2][2] == 2 && board[1][1] == 0) {
					return "11";
				}
				else if(board[2][0] == 2 && board[0][2] == 2 && board[1][1] == 0) {
					return "11";
				}
				else if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 0) {
					return "22";
				}
				else if(board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 0) {
					return "02";
				}
				else if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 0) {
					return "20";
				}
				else if(board[2][2] == 2 && board[1][1] == 2 && board[0][0] == 0) {
					return "00";
				}
				
				
				
				if(board[0][0] == 1 && board[2][2] == 1 && board[1][1] == 0) {
					return "11";
				}
				else if(board[2][0] == 1 && board[0][2] == 1 && board[1][1] == 0) {
					return "11";
				}
				else if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 0) {
					return "22";
				}
				else if(board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 0) {
					return "02";
				}
				else if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 0) {
					return "20";
				}
				else if(board[2][2] == 1 && board[1][1] == 1 && board[0][0] == 0) {
					return "00";
				}
				

				}
			if(board[0][1] == 1 && board[1][0] == 1) {
				return "00";
			}
			if(board[1][0] == 1 && board[2][1] == 1) {
				return "20";
			}
			if(board[2][1] == 1 && board[1][2] == 1) {
				return "22";
			}
			if(board[1][2] == 1 && board[0][1] == 1) {
				return "02";
			}
			if(board[0][0] == 0) {
				return "00";
			}
			if(board[0][2] == 0) {
				return "02";
			}
			if(board[2][0] == 0) {
				return "20";
			}
			if(board[2][2] == 0) {
				return "22";
			}
			for(int i = 0; i < board.length; i++ ) {
				for(int r = 0; r < board.length; r++) {
					if(board[i][r] == 0) {
						return Integer.toString(i) + r;
					}
				}
			}
			return "00";
		}
	}

	@Override
	public void reset() {
		numOfTurns = 0;
		for(int i = 0; i < board.length; i++) {
			for(int r = 0; r < board[i].length; r++) {
				board[i][r] = 0;
			}
		}
	}

	@Override
	public String getName() {
		return "SARTAJ DUA";
	}
	
	public static boolean isFinished() {
		boolean boardFull = true;
		for(int i = 0; i < board.length; i++) {
			if(board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				if(board[0][i] == 1) {
					System.out.println("You Won!!");
					return true;
				}
				if(board[0][i] == 2) {
					System.out.println("You lost");
					return true;
				}
			}
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				if(board[i][0] == 1) {
					System.out.println("You Won!!");
					return true;
				}
				if(board[i][0] == 2) {
					System.out.println("You lost");
					return true;
				}
			}
		}
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if(board[0][0] == 1) {
				System.out.println("You Won!!");
				return true;
			}
			if(board[0][0] == 2) {
				System.out.println("You lost");
				return true;
			}
		}
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if(board[0][2] == 1) {
				System.out.println("You Won!!");
				return true;
			}
			if(board[0][2] == 2) {
				System.out.println("You lost");
				return true;
			}
		}
		for(int i = 0; i < board.length; i++) {
			for(int r = 0; r < board[i].length; r++) {
				if(board[i][r] == 0) {
					boardFull = false;
				}
			}
		}
		if(boardFull) {
			System.out.println("It's a tie");
			return true;
		}
		return false;
	}
	
}
