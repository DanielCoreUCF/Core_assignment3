import java.security.SecureRandom;
import java.util.Scanner;

public class quizGen2 {
	int product;
	int rangeQuiz;
	int rangeFeedback;
	private int num1;
	private int num2;
	
	public quizGen2() {
		rangeQuiz = 10;
		rangeFeedback = 4;
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
	
	public void isAnswerCorrect() {
		while(readResponse() != product) {
			displayIncorrectResponse();
		}
		displayCorrectResponse();
	}
	
	public void quiz() {
		num1 = secureRandom(rangeQuiz);
		num2 = secureRandom(rangeQuiz);
		product = num1 * num2;
		askQuestion();
		isAnswerCorrect();
	}
	
	public void askQuestion() {
		System.out.printf("What is %d times %d\n", num1, num2);
	}
}