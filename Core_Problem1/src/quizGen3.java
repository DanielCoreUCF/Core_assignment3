import java.security.SecureRandom;
import java.util.Scanner;

public class quizGen3 {
	int product;
	int rangeQuiz;
	int rangeFeedback;
	private int num1;
	private int num2;
	int quizLength;
	int passThreshold;
	
	public quizGen3() {
		quizLength = 9;
		rangeQuiz = 10;
		rangeFeedback = 4;
		passThreshold = 75;
	}
	
	public void quiz() {
		int score = 0;
		for (int i = 0; i < (quizLength + 1); i++) {
			num1 = secureRandom(rangeQuiz);
			num2 = secureRandom(rangeQuiz);
			product = num1 * num2;
			askQuestion();
			score = score + isAnswerCorrect();
		}
		score = score * 10;
		displayCompletionMessage(score);
	}
	
	public void displayCompletionMessage(int userScore) {
		System.out.printf("You scored a(n) %d%%\n", userScore);
		if(userScore > passThreshold) {
			System.out.printf("Congradulations, you are ready to go onto"
							+ " the next level!\n");
			} else {
			System.out.printf("Please ask your teacher for extra help.\n");
			}
	}
	
	public int secureRandom(int inputRange) {
		SecureRandom rand = new SecureRandom();
		int randomNum;
		randomNum = rand.nextInt(inputRange);
		return randomNum;
	}
	
	public int readResponse() {
		int userAnswer;
		Scanner sc = new Scanner(System.in);
		userAnswer = sc.nextInt();
		return userAnswer;
	}
	
	public void displayIncorrectResponse() {
		int responseVal = secureRandom(rangeFeedback);
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
		int responseVal = secureRandom(rangeFeedback);
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