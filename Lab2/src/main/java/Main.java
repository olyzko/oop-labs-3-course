import parser.DOMParser;
import parser.SAXParser;
import parser.StAXParser;

public class Main {
    static String XMLPath = "src/main/resources/candies.xml";
    static String XSDPath = "src/main/resources/candies.xsd";

    public static void main(String[] args) throws Exception {
        {
            System.out.println("DOM");
            var candies = DOMParser.apply(XMLPath);
            System.out.println(candies);
            System.out.println();
        }

        {
            System.out.println("StAX");
            var candies = StAXParser.apply(XMLPath);
            System.out.println(candies);
            System.out.println();
        }

        {
            System.out.println("SAX");
            var candies = SAXParser.apply(XMLPath);
            System.out.println(candies);
            System.out.println();
        }
    }
}