import java.security.SecureRandom;
import java.util.Scanner;

public class quizGen1 {
	int product;
	int range;
	private int num1;
	private int num2;
	public quizGen1() {
		range = 10;
	}
	public void setNumber1(int number1) {
		SecureRandom rand = new SecureRandom();
		number1 = rand.nextInt(range);
		this.num1 = number1;
		//System.out.printf("a = %s\n", number1);
	}
	public void setNumber2(int number2) {
		SecureRandom rand = new SecureRandom();
		number2 = rand.nextInt(range);
		this.num2 = number2;
		//System.out.printf("a = %s\n", number2);
	}
	public int getNumber1() {
		return num1;
	}
	public int getNumber2() {
		return num2;
	}
	
	public int readResponse() {
		int userAnswer;
		Scanner sc = new Scanner(System.in);
		userAnswer = sc.nextInt();
		return userAnswer;
	}
	
	public void displayIncorrectResponse() {
		System.out.printf("No. Please try again.\n");
	}
	
	public void displayCorrectResponse() {
		System.out.printf("Very good!\n");
	}
	
	public void isAnswerCorrect() {
		while(readResponse() != product) {
			displayIncorrectResponse();
		}
		displayCorrectResponse();
		}
	
	public void quiz() {
		setNumber1(num1);
		setNumber2(num2);
		product = getNumber1() * getNumber2();
		askQuestion();
		isAnswerCorrect();
	}
	
	public void askQuestion() {
		System.out.printf("What is %d times %d\n", getNumber1(), getNumber2());
	}
	}

