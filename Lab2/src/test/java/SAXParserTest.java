import lombok.SneakyThrows;
import parser.SAXParser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SAXParserTest {
    @Test
    @SneakyThrows
    public void parseTest() {
        var candies = SAXParser.apply(Main.XMLPath).getCandies();
        assertEquals(candies.size(), 3);
        assertEquals(candies.get(0), MockData.candy);
    }
}