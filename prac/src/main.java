/**
 * Created by Frankie on 5/22/2016.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {
    public static void main( String []args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String linea = sc.nextLine();
        Pattern p = Pattern.compile("(https|http):\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)");
        boolean m = p.matcher(linea).find();

        if(m==true) {

            System.out.print("La url es valida\n");


            Document doc = Jsoup.connect(linea).get();
            int lineCount = doc.html().split("\n").length;
            System.out.print("La cantidad de lineas son " + lineCount);

            Elements cantparrafo = doc.getElementsByTag("p");
            System.out.print("\nLa cantidad de parrafos es " + cantparrafo.size());

            Elements cantimg = doc.getElementsByTag("img");
            System.out.print("\nLa cantidad de imagenes es " + cantimg.size());

            Elements cantform = doc.getElementsByTag("form");
            System.out.print("\nLa cantidad de formularios son " + cantform.size());


            Elements forms = doc.getElementsByTag("form");
            //for (Element form : forms) {
            //   String forminput = form.attr("input");


            //}
            System.out.print(forms);


        }






    }


}
