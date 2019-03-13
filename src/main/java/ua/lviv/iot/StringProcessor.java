package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    Pattern pattern2 = Pattern.compile("\\w{1}");

    Pattern pattern = Pattern.compile("`?$");
    Matcher matcher;
    Matcher matcher2;


    public static String readInputText() throws IOException {

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Введіть текст");
            return br.readLine();

        } catch (IOException e) {
            return "помилка";
        }
    }

    public String readLength() throws IOException {
        
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Enter Length");
            return br.readLine();

        } catch (IOException e) {
            return "помилка";
        }
    }

    public void FilterText() throws IOException {
        matcher = pattern.matcher(readInputText());

    }

    public void PrintFilterText() throws IOException {

        while (matcher.find()) {
            System.out.println(matcher.group());

        }

    }

    public static void main(String... strings) throws IOException {
        StringProcessor sp = new StringProcessor();
        sp.FilterText();
        sp.PrintFilterText();
        

    }
}
