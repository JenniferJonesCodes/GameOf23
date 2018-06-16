import java.util.Scanner;

public class gameOf23 {

	public static void main(String[] args) {
		
		int H=0, C=0, turn = 0, toothpicks = 23;
		Scanner user_input = new Scanner(System.in);
		
		while (toothpicks >= 1) {
			System.out.println("Number of toothpicks available: " + toothpicks);
			//switch between human and computer based on %
			switch (turn) {
			//human's turn
			case 0:
				System.out.println("Player 1, its your turn. Pick 1, 2 or 3 toothpics: ");
				H = user_input.nextInt();
				//invalid number of toothpicks
				if (H <= 0 || H > 3) {
					System.out.println("Invalid amount entered. Please pick 1, 2 oe 3 toothpicks.");
					H = user_input.nextInt();
					toothpicks = toothpicks - H;
					turn = (turn +1) % 2;
				}
				//1-3 but more toothpicks than present in game
				else if (H > toothpicks) {
					System.out.println("This exceeds the numer of toothpicks. Please enter less toothpics: ");
					H = user_input.nextInt();
				}
				//if there is 1 left human loses, break to end
				else if (toothpicks == 1) {
					toothpicks = toothpicks -H;
					System.out.println("Computer Wins!");
					break;
				}
				//game is still going
				else {
					toothpicks = toothpicks - H;
					turn = (turn + 1) % 2;
				}
			//computers turn
			case 1:
				if (toothpicks > 4)
					C = (4 - H);
				else if (toothpicks == 4)
					C = 3;
				else if (toothpicks == 3)
					C = 2;
				else if (toothpicks ==2)
					C = 1;
				else {
					toothpicks = toothpicks - C;
					System.out.println("Computer loses!");
					break;
				}
				toothpicks = toothpicks - C;
				turn = (turn +1) % 2;
				System.out.println("*****Computer picks " + C + "*****");
			}
		}
		System.out.println("Game Over");
		user_input.close();

	}

}
