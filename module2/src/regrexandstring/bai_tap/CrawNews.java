package regrexandstring.bai_tap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawNews {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));

            scanner.useDelimiter("\\Z");

            String news = scanner.next();
            scanner.close();
//\s{20}<a {2}data-utm="(.*?)"\s{2}href=""\s{2}
            news = news.replaceAll("\\R", "");
            System.out.println(news);
            Pattern pattern = Pattern.compile("<h3 class='news-item__title'>(.*?)title=\"(.*?)\"");

            Matcher matcher = pattern.matcher(news);
            while (matcher.find()) {
                System.out.println(matcher.group(2));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
