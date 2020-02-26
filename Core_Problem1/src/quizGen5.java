import java.security.SecureRandom;
import java.util.Scanner;

public class quizGen5 {
	int lvl1Range;
	int lvl2Range;
	int lvl3Range;
	int lvl4Range;
	int feedbackLvl;
	int num1;
	int num2;
	int quizLength;
	int passThreshold;
	int feedbackRange;
	int score;
	int answer;
	int version;
	
	public quizGen5() {
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
		int difficultyLvl = readDifficulty();
		int quizVersion = readProblemType();
		
		for (int i = 0; i < (quizLength + 1); i++) {
			int[] argument = generateQuestionArgument(difficultyLvl, quizVersion);
			num1 = argument[0];
			num2 = argument[1];
			answer = argument[2];
			version = argument[3];
			askQuestion(version);
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
	
	public int readProblemType() {
		int problemType;
		System.out.printf("Please select a problem type\n0: addition\n1: multiplication\n2: subtraction\n3: division\n4: mixed\n");
		System.out.printf("For division problems always round down to nearest integer!\n");
		problemType = readResponse();
		return problemType;
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
	
	
	public int[] generateQuestionArgument(int inputLvl, int inputType) {
		int lvl = 0;
		int[] questionArgs = new int[4];
		int randomNum1;
		int randomNum2;
		int randomNum3;
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
			randomNum1 = rand.nextInt(lvl);
			randomNum2 = rand.nextInt(lvl);
			num1 = randomNum1;
			num2 = randomNum2;
			if(num1 < num2 || num2 == 0) {
				while(num1 < num2 || num2 ==0 ) {
					randomNum1 = rand.nextInt(lvl);
					randomNum2 = rand.nextInt(lvl);
					num1 = randomNum1;
					num2 = randomNum2;
				}
			}
			switch (inputType) {
				case 0: answer = num1 + num2;
						version = 0;
				break;
				
				case 1: answer = num1 * num2;
						version = 1;
				break;
				
				case 2: answer = num1 - num2;
						version = 2;
				break;
				
				case 3: answer = num1 / num2;
						version = 3;
				break;
				
				case 4: randomNum3 = rand.nextInt(4);
						version = randomNum3;
						switch (randomNum3) {
						case 0: answer = num1 + num2;
						break;
						
						case 1: answer = num1 * num2;
						break;
						
						case 2: answer = num1 - num2;
						break;
						
						case 3: answer = num1 / num2;
						break;
						
						}
				break;
		}
			
		questionArgs[0] = num1;
		questionArgs[1] = num2;
		questionArgs[2] = answer;
		questionArgs[3] = version;
		return questionArgs;
	}
	
	public int readResponse() {
		int userAnswer;
		Scanner sc = new Scanner(System.in);
		userAnswer = sc.nextInt();
		return userAnswer;
	}
	
	public void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int responseVal = rand.nextInt(4);
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
		SecureRandom rand = new SecureRandom();
		int responseVal = rand.nextInt(4);
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
			if(readResponse() != answer) {
				displayIncorrectResponse();
				return 0;
			} else {
				displayCorrectResponse();
				return 1;
			}
	}
	
	public void askQuestion(int askVersion) {
		String s = ("initial");
		switch (askVersion) {
			case 0: s = ("plus");
			break;
			
			case 1: s = ("times");
			break;
			
			case 2: s = ("minus");
			break;
			
			case 3: s = ("divided by");
			break;
		}
		System.out.printf("What is %d %s %d\n", num1,s, num2);
	}
}
