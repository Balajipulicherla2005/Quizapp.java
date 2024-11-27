import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String text;
    private String[] options;
    private int correctAnswerIndex;

    // Constructor
    public Question(String text, String[] options, int correctAnswerIndex) {
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getters
    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }

    public String getCorrectAnswer() {
        return options[correctAnswerIndex];
    }
}

class Quiz {
    private ArrayList<Question> questions;

    // Constructor
    public Quiz() {
        questions = new ArrayList<>();
    }

    // Add a question to the quiz
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Run the quiz
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("\nWelcome to the Quiz!");
        System.out.println("=====================");

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            // Display question
            System.out.println("\nQuestion " + (i + 1) + ": " + question.getText());
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }

            // Get user's answer with input validation
            int userChoice = -1;
            while (true) {
                System.out.print("Your choice (enter the option number): ");
                try {
                    userChoice = Integer.parseInt(scanner.nextLine());
                    if (userChoice >= 1 && userChoice <= options.length) {
                        break;
                    } else {
                        System.out.println("Please choose a number between 1 and " + options.length + ".");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            // Check the answer
            if (question.isCorrect(userChoice - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer());
            }
        }

        // Display final score
        System.out.println("\nQuiz Completed!");
        System.out.println("=================");
        System.out.println("Your score: " + score + "/" + questions.size());

        scanner.close();
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Add questions to the quiz
        quiz.addQuestion(new Question(
                "who left the first world cup in circket india team in the year?",
                new String[] { "2007", "1983", "2003", "2011" },
                1));
        quiz.addQuestion(new Question(
                "who is the chairman of tcs?",
                new String[] { "K. Krithivasan", "Rajesh Gopinathan", "N. Chandrasekaran", "Ratan Tata" },
                2));
        quiz.addQuestion(new Question(
                "What are the most popular programming languages?",
                new String[] { "css", "HTML", "javascript", "SQL" },
                2));
        quiz.addQuestion(new Question(
                "In which year did World War II end?",
                new String[] { "1950", "1947", "1985", "1942" },
                2));
        quiz.addQuestion(new Question(
                "who invented telephone?",
                new String[] { "Nikola Tesla", "Thomas Edison", "Guglielmo Marconi", "Alexander Graham Bell" },
                3));
        quiz.addQuestion(new Question(
                "What is the tallest mountain in the world?",
                new String[] { "paris", "Mount Everest", "Jupiter", "Mars" },
                1));
        quiz.addQuestion(new Question(
                "What does WWW stand for in a website browser?",
                new String[] { "web wide world", "world web wide", "World Wide Web", "wide web world" },
                2));
        quiz.addQuestion(new Question(
                "Which famous scientist developed the theory of relativity?",
                new String[] { "Nikola Tesla", "Galileo Galilei", "Albert Einstein", "Isaac Newton" },
                2));
        quiz.addQuestion(new Question(
                "Who is known as the father of modern physics?",
                new String[] { "Albert Einstein", "Nikola Tesla", "Galileo Galilei", "Isaac Newton" },
                0));
        quiz.addQuestion(new Question(
                "who was first president of india?",
                new String[] { "Mahatma Gandhi", "Jawaharlal Nehru", "Dr. Rajendra Prasad",
                        "Sardar Vallabhbhai Patel" },
                2));
        quiz.addQuestion(new Question(
                "who invented java programming language?",
                new String[] { "James Gosling", "Dennis Ritchie", "Guido van Rossum", "Bjarne Stroustrup" },
                0));
        quiz.addQuestion(new Question(
                "who was the first prime minister of india?",
                new String[] { "Mahatma Gandhi", "Dr. Rajendra Prasad", "Jawaharlal Nehru",
                        "Sardar Vallabhbhai Patel" },
                2));
        quiz.addQuestion(new Question(
                "Who killed the mahatma gandhi?",
                new String[] { "Bhagat Singh", "Nathuram Godse", "Veer Savarkar", "Subhas Chandra Bose" },
                1));
        quiz.addQuestion(new Question(
                "who's the google ceo in the year 2024?",
                new String[] { "Sundar Pichai", "Larry Page", "Sergey Brin", "Eric Schmidt" },
                0));
        quiz.addQuestion(new Question(
                "Who's the ceo of IT company in the year 2024?",
                new String[] { "Narayana Murthy", "S.D. Shibulal", "Salil Parekh", "Nandan Nilekani" },
                2));
        quiz.addQuestion(new Question(
                "Who's the founder of microsoft?",
                new String[] { "Larry Page", "Bill Gates", "Mark Zuckerberg", "Steve Jobs" },
                1));
        quiz.addQuestion(new Question(
                "who's the richest person in india?",
                new String[] { "Mukesh Ambani", "Gautam Adani", "avitri Jindal", "Shiv Nadar" },
                0));
        quiz.addQuestion(new Question(
                "who's was 11th president of india?",
                new String[] { "Dr. Rajendra Prasad", "Pratibha Patil", "Dr. A.P.J. Abdul Kalam",
                        "Shankar Dayal Sharma" },
                2));
        quiz.addQuestion(new Question(
                "Who's the founder of artificial intelligence?",
                new String[] { "Marvin Minsky", "John McCarthy", "Alan Turing", "Herbert A.Simon" },
                1));
        quiz.addQuestion(new Question(
                "who's the best ever captain in India team?",
                new String[] { "MS Dhoni", "Virat Kohli", "Sourav Ganguly", "Kapil Dev" },
                0));
        // Start the quiz
        quiz.start();
    }
}
