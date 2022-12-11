import lombok.SneakyThrows;
import parser.DOMParser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DOMParserTest {

    @Test
    @SneakyThrows
    public void parseTest() {
        var candies = DOMParser.apply(Main.XMLPath).getCandies();
        assertEquals(candies.size(), 3);
        assertEquals(candies.get(0), MockData.candy);
    }
}