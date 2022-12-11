package parser;

import model.Candies;

import model.Candy;
import model.Ingredients;
import model.Value;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import static util.Strings.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMParser {
    public static Candies apply(String xmlPath)
            throws ParserConfigurationException, IOException, SAXException {
        var dbf = DocumentBuilderFactory.newInstance();
        var db = dbf.newDocumentBuilder();
        var doc = db.parse(new File(xmlPath));
        var nodeList = doc.getElementsByTagName(CANDY);
        var candies = new ArrayList<Candy>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            var node = nodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
            var element = (Element) node;
            candies.add(createCandy(element));
        }
        return new Candies(candies);
    }

    private static Candy createCandy(Element element) {
        int id = Integer.parseInt(element.getAttribute(ID));
        String name = getByTag(element, NAME);
        int energy = Integer.parseInt(getByTag(element, ENERGY));
        String type = getByTag(element, TYPE);
        var value = (Element) element.getElementsByTagName(VALUE).item(0);
        var ingredients = (Element) element.getElementsByTagName(INGREDIENTS).item(0);
        String production = getByTag(element, TYPE);
        return new Candy(id, name, energy, type, createValue(value), createIngredients(ingredients), production);
    }

    private static Value createValue(Element element){
        int protein = Integer.parseInt(getByTag(element, PROTEIN));
        int fats = Integer.parseInt(getByTag(element, FATS));
        int hydrocarbonates = Integer.parseInt(getByTag(element, HYDROCARBONATES));
        return new Value(protein, fats, hydrocarbonates);
    }

    private static Ingredients createIngredients(Element element) {
        int water = Integer.parseInt(getByTag(element, WATER));
        int sugar = Integer.parseInt(getByTag(element, SUGAR));
        int fructose = Integer.parseInt(getByTag(element, FRUCTOSE));
        String chocoType = getByTag(element, CHOCOLATE_TYPE);
        int vanille = Integer.parseInt(getByTag(element, VANILLE));
        return new Ingredients(water, sugar, fructose, chocoType, vanille);
    }

    private static String getByTag(Element element, String tag) {
        return element.getElementsByTagName(tag).item(0).getTextContent();
    }
}