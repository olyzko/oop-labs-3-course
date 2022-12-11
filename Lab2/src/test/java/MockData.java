import model.Candy;
import model.Ingredients;
import model.Value;

public class MockData {
    static Candy candy = new Candy(
            1,
            "Romashka",
            3500,
            "chocolate",
            new Value(1520, 225, 920),
            new Ingredients(420, 15, 200, "black", 130),
            "Roshen");
}