package ua.lviv.iot;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private Pattern paternToSearchWords;
    private Pattern paternToSearchQuestions;
    private Matcher matcherToFindedQuestions;
    private Matcher matcherToFindedWords;

    public final String filterText(String text, String lenght) throws IOException {

        Set<String> listOfWords = new LinkedHashSet<>();
        
        paternToSearchQuestions = Pattern
                .compile("(([a-zA-Z0-9а-яА-я]|[,]|[;])+\\s*)+(\\?)");
        paternToSearchWords = Pattern.compile("\\b[A-Za-zА-Яа-я]{" + lenght + "}\\b");

        matcherToFindedQuestions = paternToSearchQuestions.matcher(text);

        while (matcherToFindedQuestions.find()) {
            String resultSentences = matcherToFindedQuestions.group();
            matcherToFindedWords = paternToSearchWords.matcher(resultSentences);

            while (matcherToFindedWords.find()) {

                String resultWords = matcherToFindedWords.group();
                listOfWords.add(resultWords);
            }
        }
        return listOfWords.toString();
    }
}
