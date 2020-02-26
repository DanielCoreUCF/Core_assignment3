import java.security.SecureRandom;
import java.util.Scanner;

public class quizGen4 {
	int product;
	int lvl1Range;
	int lvl2Range;
	int lvl3Range;
	int lvl4Range;
	int feedbackLvl;
	private int num1;
	private int num2;
	int quizLength;
	int passThreshold;
	int feedbackRange;
	
	public quizGen4() {
		quizLength = 9;
		lvl1Range = 10;
		lvl2Range = 100;
		lvl3Range = 1000;
		lvl4Range = 10000;		
		feedbackLvl = 5;
		feedbackRange = 4;
		passThreshold = 75;
	}
	
	public void quiz() {
		int score = 0;
		int difficultyLvl = readDifficulty();
		for (int i = 0; i < (quizLength + 1); i++) {
			num1 = secureRandom(difficultyLvl);
			num2 = secureRandom(difficultyLvl);
			product = num1 * num2;
			askQuestion();
			score = score + isAnswerCorrect();
		}
		score = score * 10;
		displayCompletionMessage(score);
		score = 0;
		restartQuiz();
	}
	
	public int readDifficulty() {
		int difficulty;
		System.out.printf("Please select a difficulty 1-4.\n");
		difficulty = readResponse();
		return difficulty;
	}
	
	public void displayCompletionMessage(int userScore) {
		System.out.printf("You scored a(n) %d%%\n", userScore);
		if(userScore > passThreshold) {
			System.out.printf("Congratulations, you are ready to go onto"
							+ " the next level!\n");
			} else {
			System.out.printf("Please ask your teacher for extra help.\n");
			}
		System.out.printf("Would you like to try again? (y/n)\n");
	}
	
	
	public void restartQuiz() {
		char userResponse;
		char accept = 'y';
		Scanner sc = new Scanner(System.in);
		userResponse = sc.next().charAt(0);
		if(userResponse == accept) {
			quiz();
		}
	System.exit(0);}
	
	
	public int secureRandom(int inputLvl) {
		int lvl = 0;
		int randomNum;
			switch (inputLvl) {
				case 1: lvl = lvl1Range;
				break;
			
				case 2: lvl = lvl2Range;
				break;
			
				case 3: lvl = lvl3Range;
				break;
			
				case 4: lvl = lvl4Range;
				break;
			
				case 5: lvl = feedbackRange;
				break;
			}
		SecureRandom rand = new SecureRandom();
		randomNum = rand.nextInt(lvl);
		return randomNum;
	}
	
	public int readResponse() {
		int userAnswer;
		Scanner sc = new Scanner(System.in);
		userAnswer = sc.nextInt();
		return userAnswer;
	}
	
	public void displayIncorrectResponse() {
		int responseVal = secureRandom(feedbackLvl);
		switch (responseVal) {
		case 0: System.out.printf("No. Please try again.\n");
				break;
		
		case 1: System.out.printf("Wrong. Try once more.\n");
				break;
		
		case 2: System.out.printf("Don't give up!\n");
				break;
				
		case 3: System.out.printf("No. Keep trying.\n");
				break;
		}
	}
	
	public void displayCorrectResponse() {
		int responseVal = secureRandom(feedbackLvl);
		switch (responseVal) {
		case 0: System.out.printf("Very Good!\n");
				break;
		
		case 1: System.out.printf("Excellent!\n");
				break;
		
		case 2: System.out.printf("Nice work!\n");
				break;
				
		case 3: System.out.printf("Keep up the good work!\n");
				break;
		}
	}
	
	public int isAnswerCorrect() {
			if(readResponse() != product) {
				displayIncorrectResponse();
				return 0;
			} else {
				displayCorrectResponse();
				return 1;
			}
	}
	
	public void askQuestion() {
		System.out.printf("What is %d times %d\n", num1, num2);
	}
}