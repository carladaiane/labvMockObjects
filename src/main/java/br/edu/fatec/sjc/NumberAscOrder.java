package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NumberAscOrder<T extends Number> {

    private final CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("A pilha não pode ser nula.");
        }
        this.stack = stack;
    }

    public List<T> sort() {
        List<T> numbers = new ArrayList<>();

        while (!stack.isEmpty()) {
            try {
                numbers.add(stack.pop());
            } catch (StackEmptyException e) {
                break;
            }
        }

        numbers.sort(Comparator.comparingDouble(Number::doubleValue));

        return numbers;
    }
}
