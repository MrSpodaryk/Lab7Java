package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComandLineRuner {
    
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
    
    public static void main(String[] args) throws IOException {
        StringProcessor sp = new StringProcessor();
        
        String lenght = ComandLineRuner.readLenght();
        
        String text = ComandLineRuner.readInputText();
        
        System.out.println(sp.filterText(text, lenght));
       
    }
}
