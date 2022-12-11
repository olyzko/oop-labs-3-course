package model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ingredients {
    private int water;
    private int sugar;
    private int fructose;
    private String chocolateType;
    private int vanille;

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
        return Objects.hash(water, sugar, fructose, chocolateType, vanille);
    }
}