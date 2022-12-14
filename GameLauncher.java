import java.util.Scanner;

class GameLauncher{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("==============================KEVIN'S GUESSING GAME==============================");
		System.out.print("How many digits will the number to guess be?(1 - 10): ");

		boolean isValidDigits = false;
		String selection = "";
		while(!isValidDigits){
			selection = scan.nextLine();

			switch(selection){
			case "1":
				isValidDigits = true;
				break;
			case "2":
				isValidDigits = true;
				break;
			case "3":
				isValidDigits = true;
				break;
			case "4":
				isValidDigits = true;
				break;
			case "5":
				isValidDigits = true;
				break;
			case "6":
				isValidDigits = true;
				break;
			case "7":
				isValidDigits = true;
				break;
			case "8":
				isValidDigits = true;
				break;
			case "9":
				isValidDigits = true;
				break;
			case "10":
				isValidDigits = true;
				break;
			default:
				System.out.println("Not a valid selection of digits.");
				System.out.print("How many digits?: ");
			}
		}

		int numDigits = Integer.parseInt(selection);
		Computer c = new Computer(numDigits);

		System.out.println("(Guess \"q\" to quit)");
		
		String goalString =  c.calculateGoalString();
		selection = "";
		while(!selection.equals("q")){
			System.out.print("Enter your guess: ");
			selection = scan.nextLine();

			String result = "";
			
			if(!selection.equals("q")){
				result = c.guess(selection);
				System.out.println(result);
			}

			if(result.equals(goalString)){
				System.out.println("\nYOU WIN!!!\nKevin is proud of you.\n");
				break;
			}
		}

		System.out.println(c.toString());
	}
}