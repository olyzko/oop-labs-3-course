package model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Candy {
    private int id;
    private String name;
    private int energy;
    private String type;
    private Value value;
    private Ingredients ingredients;
    private String production;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, energy, type, value, ingredients, production);
    }
}