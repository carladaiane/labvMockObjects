package br.edu.fatec.sjc;

public class IntegerStrategy implements CalculableStrategy<Integer> {
    @Override
    public Integer calculateValue(Integer value) {
        if (value == null) {
            throw new NullPointerException("Valor não pode ser nulo");
        }
        return value;
    }
}

