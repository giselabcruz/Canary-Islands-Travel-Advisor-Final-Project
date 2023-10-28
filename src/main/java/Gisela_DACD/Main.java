package Gisela_DACD;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid={API_KEY}");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.getRequestMethod();
        connection.connect();

        int respondeCode = connection.getResponseCode();
        if(respondeCode != 200){
            throw new RuntimeException("Response code is not what was expected: " + respondeCode);
        } else {
            StringBuilder dataString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                dataString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println(dataString);
        }
        }
    }