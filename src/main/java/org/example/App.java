package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        String url = "https://news.google.com/topics/CAAqHAgKIhZDQklTQ2pvSWJHOWpZV3hmZGpJb0FBUAE/sections/CAQiUENCSVNOam9JYkc5allXeGZkakpDRUd4dlkyRnNYM1l5WDNObFkzUnBiMjV5Q3hJSkwyMHZNREUyYlhBNWVnc0tDUzl0THpBeE5tMXdPU2dBKjEIACotCAoiJ0NCSVNGem9JYkc5allXeGZkako2Q3dvSkwyMHZNREUyYlhBNUtBQVABUAE?hl=en-IN&gl=IN&ceid=IN%3Aen";
        try{


            Document doc = Jsoup.connect(url).get();

            Elements content = doc.getElementsByClass("D9SJMe");

            Elements subContent = content.first().getElementsByTag("a");



            JFrame root = new JFrame("Google News");
            root.setSize(500,500);

            Font f = new Font("Poppins", Font.BOLD,20);

            JLabel dataL = new JLabel();
            dataL.setFont(f);

            Button b = new Button("Get");
            b.setFont(f);
            b.addActionListener(event->{
                // click

                for (Element e : subContent){
                    String mainData= String.valueOf(sb.append(e.attr("aria-label")).append("<br>"));
                    dataL.setText(mainData);
                }
            });

            root.setLayout(new BorderLayout());

            root.add(dataL, BorderLayout.NORTH);
            root.add(b, BorderLayout.SOUTH);

            root.setVisible(true);


        }catch(Exception e){
            System.out.println(e);
        }
        sb.append("</html>");
    }
}
