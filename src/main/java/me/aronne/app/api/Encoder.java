package me.aronne.app.api;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Encoder {

    //parse resources/js/encoder.json and put in a String variable using org.json.simple parser
    JSONParser parser = new JSONParser();
    // new reader
    private final Object encoder = parser.parse("resources/js/encoder.json");
    private final String bpe_file = Files.newBufferedReader(Paths.get("resources/js/vocab.bpe"), StandardCharsets.UTF_8).lines().reduce("", String::concat);

    //a method called range with two int params, and returns an int array
    public int[] range(int start, int end) {
        int[] range = new int[end - start];
        for (int i = 0; i < range.length; i++) {
            range[i] = start + i;
        }
        return range;
    }

    //a method called ord, that takes a char param, and returns its unicode value
    public int ord(char c) {
        return c;
    }

    //a method called chr, that takes an int param, and returns its char value
    public String chr(int i) {
        return String.valueOf((char) i);
    }

    //a method called bpe_tokenize, that takes a String param, and returns a String array
    public String[] bpe_tokenize(String text) {
        String[] tokens = text.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replaceAll("@@ ", "");
        }
        return tokens;
    }

    //a method called bpe_detokenize, that takes a String array param, and returns a String
    public String bpe_detokenize(String[] tokens) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            sb.append(tokens[i]).append(" ");
        }
        return sb.toString();
    }

    //a method called bpe_detokenize, that takes a String param, and returns a String
    public String bpe_detokenize(String text) {
        String[] tokens = bpe_tokenize(text);
        return bpe_detokenize(tokens);
    }

    //a method called bpe_encode, that takes a String param, and returns a String array
    public String[] bpe_encode(String text) {
        String[] tokens = bpe_tokenize(text);
        String[] encoded = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            encoded[i] = bpe_file.substring(bpe_file.indexOf(tokens[i]));
        }
        return encoded;
    }

    //a method called bpe_decode, that takes a String array param, and returns a String
    public String bpe_decode(String[] tokens) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.length; i++) {
            sb.append(bpe_detokenize(tokens[i].split(" ")));

        }
        return sb.toString();
    }


    public Encoder() throws ParseException, IOException {
    }
}