package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private String lenght;
    private Pattern paternToSearchWords;
    private Pattern paternToSearchQuestions;
    private Matcher matcherToFindedQuestions;
    private Matcher matcherToFindedWords;
    private Set<String> listOfWords = new LinkedHashSet<>();

    public final Set<String> getListOfWords() {
        return listOfWords;
    }

    public static final String readInputText() throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Введіть текст");
        return br.readLine();
    }

    public static final String readLenght() throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Введіть довжину");
        return br.readLine();
    }

    public final void filterText() throws IOException {

        lenght = StringProcessor.readLenght();

        paternToSearchQuestions = Pattern
                .compile("(([a-zA-Z0-9а-яА-я]|[,]|[;])+\\s*)+(\\?)");
        paternToSearchWords = Pattern
                .compile("\\b[A-Za-zА-Яа-я]{" + lenght + "}\\b");

        matcherToFindedQuestions = paternToSearchQuestions
                .matcher(StringProcessor.readInputText());

        while (matcherToFindedQuestions.find()) {

            String resultSentences = matcherToFindedQuestions.group();
            matcherToFindedWords = paternToSearchWords.matcher(resultSentences);

            while (matcherToFindedWords.find()) {

                String resultWords = matcherToFindedWords.group();
                listOfWords.add(resultWords);
            }
        }
    }

    public final String printFilterText() {

        return listOfWords.toString();
    }

    public static void main(String[] args) throws IOException {
        StringProcessor sp = new StringProcessor();
        sp.filterText();
        System.out.println(sp.printFilterText());
    }

    public final void filterConstantText() throws IOException {

        String text = "Hello! What are you doing? There is my house."
                + " Who is there? Do you like learning English? "
                + "Do you like learning English? What are you doing now?"
                + "Watch this? You sleep now.";

        paternToSearchQuestions = Pattern
                .compile("(([a-zA-Z0-9а-яА-я]|[,]|[;])+\\s*)+(\\?)");
        paternToSearchWords = Pattern.compile("\\b[A-Za-zА-Яа-я]{4}\\b");

        matcherToFindedQuestions = paternToSearchQuestions.matcher(text);

        while (matcherToFindedQuestions.find()) {

            String resultSentences = matcherToFindedQuestions.group();
            matcherToFindedWords = paternToSearchWords.matcher(resultSentences);

            while (matcherToFindedWords.find()) {

                String resultWords = matcherToFindedWords.group();
                listOfWords.add(resultWords);
            }
        }
    }

    public final String printConstantFilterText() {

        return listOfWords.toString();
    }
}
