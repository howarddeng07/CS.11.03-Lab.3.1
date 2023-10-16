import java.util.Scanner;

public class TextBasedGame {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the CS class adventure game!");
            System.out.println("You wake up in the students affairs room, you find the admin laptop.");
            System.out.println("Choose your CS teacher for the year:\n1. Adam Ewing *****\n2. Nitu Nahar ****\n3. Simon Tam ****\n4. Sanaz Momeni ****\n5. Mark Hayes ****\n6. Edward Lagos ****");
            int teacherChoice = scanInt();
            playGame(teacherChoice);

            System.out.println("Do you want to play again?\n1. Yes\n2. No");
            int playAgain = scanInt();
            if (playAgain != 1) {
                break;
            }
        }
    }

    private static void playGame(int teacherChoice) {
        double studentGrade = 0;
        if (teacherChoice<1 || teacherChoice>6){
            System.out.println("Invalid choice, please try again");
            return;
        }
        else if (teacherChoice == 6){
            System.out.println("The teacher you selected is no longer available, please try again");
            return;
        }
        System.out.println("Will you pay attention in class?\n1. Yes\n2. No");
        int attentionChoice = scanInt();
        System.out.println("Will you study after class? \n1. Yes\n2. No");
        int studyChoice = scanInt();

        System.out.println("It is extended learning time, will you visit your teacher?\n1. Yes\n2. No");
        int extendedLearningChoice = scanInt();

        if (teacherChoice == 1) {
            studentGrade = 100;
        } else {
            studentGrade += processChoice(attentionChoice, 80, 0);
            studentGrade += processChoice(studyChoice, 15, 0);
            studentGrade = extendedLearningChoice == 1 ? studentGrade * 1.1 : studentGrade / 1.1;
            studentGrade = Math.min(studentGrade, 100);
        }

        printGrade(studentGrade, teacherChoice);
    }

    private static int scanInt() {
        return scanner.nextInt();
    }

    private static int processChoice(int choice, int valueIfYes, int valueIfNo) {
        int result = choice == 1 ? valueIfYes : valueIfNo;
        return result;
    }

    private static void printGrade(double grade, int teacherChoice) {
        int integerGrade = (int) grade;
        if (integerGrade >= 90) {
            String message = teacherChoice == 1 ? "This is because you're in Mr Ewing's class where you don't have to pay attention, study, or attend extended learning and still score 100" : "";
            System.out.println("Your exam grade is " + integerGrade + ". Congratulations! Since you scored above 90, you won. " + message + ".");
        } else {
            System.out.println("Your exam grade is " + integerGrade + ". Unfortunately, you lost.");
        }
    }
}