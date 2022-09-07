class Computer{
	private int[] numToGuess;
	private int numGuesses;

	Computer(int num){
		numToGuess = new int[num];

		//Generate "num" random digits
		boolean isUniqueDigit = false;
		int digit = 0;
		for(int i = 0; i < num; i++, isUniqueDigit = false){
			//Keep generating digits until we find a unique digit
			while(!isUniqueDigit){
				digit = (int)(Math.random() * 10); //Generate digit
				isUniqueDigit = checkUniqueness(digit, this.numToGuess, i);
			}
			numToGuess[i] = digit;
		}
	}

	public String guess(String num){
		//Verify Length
		/*if(num.length() != numToGuess.length){
			return "INVALID LENGTH: " + String.valueOf(num);
		}*/

		//Validate input
		if(!validateInput(num)){
			return "Invalid guess, please enter a valid guess";
		}

		//Split num into digits
		int[] numberAsArray = splitIntoArray(num);
		return checkGuess(numberAsArray);

	/*	//Verify Uniqueness 
		boolean isUnique = verifyUniqueness(numberAsArray);
		if(isUnique){
			numGuesses++;
			return checkGuess(numberAsArray);
		}else{
			return "NOT UNIQUE DIGITS: " + num;
		}
*/
	}

	private String checkGuess(int[] num){
		int numA = 0;
		int numB = 0;

		for(int i = 0; i < num.length; i++){
			for(int j = 0; j < numToGuess.length; j++){
				if(num[i] == numToGuess[j]){
					if(i == j){
						numA++;
					}else{
						numB++;
					}
				}
			}
		}

		String stringA = String.valueOf(numA);
		String stringB = String.valueOf(numB);

		numGuesses++;

		return (stringA + "A" + stringB + "B");
	}

	private boolean checkUniqueness(int num, int[] arr, int len){
		for(int i = 0; i < len; i++){
			if(num == arr[i]){
				return false;
			}
		}

		return true;
	}

	/*private boolean verifyLength(int num){
		int count = 0;
		while(num > 0){
			count++;
			num /= 10;
		}

		if(count == numToGuess.length){
			return true;
		}

		return false;
	}*/

	private int[] splitIntoArray(String num){
		int[] arr = new int[num.length()];
		for(int i = 0; i < num.length(); i++){
			arr[i] = num.charAt(i) - 48;
		}

		return arr;
	}

	private boolean verifyUniqueness(int[] arr){
		//Wildly Inefficient
		int[] seenDigits = new int[numToGuess.length];
		for(int i = 0; i < numToGuess.length; i++){
			for(int j = 0; j < i; j++){
				if(seenDigits[j] == arr[i]){
					return false;
				}
			}
			seenDigits[i] = arr[i];
		}

		return true;
	}

	public String toString(){
		String s = "";
		s += "Number to guess: ";

		for(int i = 0; i < numToGuess.length; i++){
			s += numToGuess[i];
		}

		s += "\n";
		s += "Number of guesses attempted: " + numGuesses;
		
		return s;
	}

	private boolean validateInput(String s){
		if(s.matches("[0-9]+")){
			return true;
		}

		return false;
	}
}