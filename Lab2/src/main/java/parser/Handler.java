package parser;

import model.Ingredients;
import model.Candy;
import model.Value;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import static util.Strings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Handler extends DefaultHandler {
    private String val;
    private List<Candy> candies = new ArrayList<>();

    @Override
    public void startElement(String url, String name, String attributeName, Attributes attributes) {
        switch (attributeName) {
            case CANDY -> {
                Candy candy = new Candy();
                candies.add(candy);
            }
            case INGREDIENTS -> {
                Ingredients ings = new Ingredients();
                getLastCandy().setIngredients(ings);
            }
            case VALUE -> {
                Value value = new Value();
                getLastCandy().setValue(value);
            }
        }
    }

    @Override
    public void endElement(String uri, String name, String attributeName) {
        switch (attributeName) {
            case ID -> getLastCandy().setId(Integer.parseInt(val));
            case NAME -> getLastCandy().setName(val);
            case ENERGY -> getLastCandy().setEnergy(Integer.parseInt(val));
            case TYPE -> getLastCandy().setType(val);
            case PRODUCTION -> getLastCandy().setProduction(val);
            case PROTEIN -> getLastCandy().getValue().setProtein(Integer.parseInt(val));
            case FATS -> getLastCandy().getValue().setFats(Integer.parseInt(val));
            case HYDROCARBONATES -> getLastCandy().getValue().setHydrocarbonates(Integer.parseInt(val));
            case WATER -> getLastCandy().getIngredients().setWater(Integer.parseInt(val));
            case SUGAR -> getLastCandy().getIngredients().setSugar(Integer.parseInt(val));
            case FRUCTOSE -> getLastCandy().getIngredients().setFructose(Integer.parseInt(val));
            case CHOCOLATE_TYPE -> getLastCandy().getIngredients().setChocolateType(val);
            case VANILLE -> getLastCandy().getIngredients().setVanille(Integer.parseInt(val));
        }
    }

    public void setField(String attributeName, String val, Map<String, String> attributes) {
        this.val = val;
        switch (attributeName) {
            case CANDY -> {
                Candy candy = new Candy();
                candies.add(candy);
            }
            case ID -> getLastCandy().setId(Integer.parseInt(val));
            case NAME -> getLastCandy().setName(val);
            case ENERGY -> getLastCandy().setEnergy(Integer.parseInt(val));
            case TYPE -> getLastCandy().setType(val);
            case PRODUCTION -> getLastCandy().setProduction(val);
            case PROTEIN -> getLastCandy().getValue().setProtein(Integer.parseInt(val));
            case FATS -> getLastCandy().getValue().setFats(Integer.parseInt(val));
            case HYDROCARBONATES -> getLastCandy().getValue().setHydrocarbonates(Integer.parseInt(val));
            case WATER -> getLastCandy().getIngredients().setWater(Integer.parseInt(val));
            case SUGAR -> getLastCandy().getIngredients().setSugar(Integer.parseInt(val));
            case FRUCTOSE -> getLastCandy().getIngredients().setFructose(Integer.parseInt(val));
            case CHOCOLATE_TYPE -> getLastCandy().getIngredients().setChocolateType(val);
            case VANILLE -> getLastCandy().getIngredients().setVanille(Integer.parseInt(val));
            case VALUE -> {
                Value value = new Value();
                getLastCandy().setValue(value);
            }
            case INGREDIENTS -> {
                Ingredients ings = new Ingredients();
                getLastCandy().setIngredients(ings);
            }

        }
    }

    public List<Candy> getCandiesList() {
        return candies;
    }

    @Override
    public void startDocument() throws SAXException {
        candies = new ArrayList<>();
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        val = new String(ch, start, length);
    }

    private Candy getLastCandy() {
        return candies.get(candies.size() - 1);
    }

    public String getName() {
        return CANDY;
    }
}