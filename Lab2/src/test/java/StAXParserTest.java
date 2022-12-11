import lombok.SneakyThrows;
import parser.StAXParser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StAXParserTest {
    @Test
    @SneakyThrows
    public void parseTest() {
        var candies = StAXParser.apply(Main.XMLPath).getCandies();
        assertEquals(candies.size(), 3);
        assertEquals(candies.get(0), MockData.candy);
    }
}