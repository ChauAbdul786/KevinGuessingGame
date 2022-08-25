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

	public String guess(int num){
		//Verify Length
		boolean validityOfLength = verifyLength(num);
		if(!validityOfLength){
			return "INVALID LENGTH: " + String.valueOf(num);
		}

		//Split num into digits
		int[] numberAsArray = splitIntoArray(num);

		//Verify Uniqueness 
		boolean isUnique = verifyUniqueness(numberAsArray);
		if(isUnique){
			return "PASSED ALL TESTS: " + String.valueOf(num);
		}else{
			return "NOT UNIQUE DIGITS: " + String.valueOf(num);
		}

	}

	private boolean checkUniqueness(int num, int[] arr, int len){
		for(int i = 0; i < len; i++){
			if(num == arr[i]){
				return false;
			}
		}

		return true;
	}

	private boolean verifyLength(int num){
		int count = 0;
		while(num > 0){
			count++;
			num /= 10;
		}

		if(count == numToGuess.length){
			return true;
		}

		return false;
	}

	private int[] splitIntoArray(int num){
		int len = numToGuess.length;
		int[] toRet = new int[len];

		for(int i = len - 1; i >= 0; i--){
			toRet[i] = num % 10;
			num /= 10;
		}

		return toRet;
	}

	private boolean verifyUniqueness(int[] arr){
		boolean isUniqueDigit = true;
		for(int i = arr.length - 1; i > 0; i--){
			isUniqueDigit = checkUniqueness(arr[i], arr, i - 1);
			if(!isUniqueDigit){
				return false;
			}
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
}