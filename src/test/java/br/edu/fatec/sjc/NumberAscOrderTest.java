package br.edu.fatec.sjc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberAscOrderTest {

    @Test
    @DisplayName("Deve ordenar os números da pilha em ordem crescente")
    void deveOrdenarNumerosDaPilha() throws StackFullException {
        CustomStack<Integer> stack = new CustomStack<>(6, new IntegerStrategy());
        stack.push(42);
        stack.push(10);
        stack.push(25);
        stack.push(5);
        stack.push(60);
        stack.push(33);

        NumberAscOrder<Integer> order = new NumberAscOrder<>(stack);

        List<Integer> resultado = order.sort();

        assertEquals(List.of(5, 10, 25, 33, 42, 60), resultado,
                "Os números deveriam estar ordenados em ordem crescente");
    }

    @Test
    @DisplayName("Deve retornar uma lista vazia se a pilha estiver vazia")
    void deveRetornarListaVaziaSePilhaEstiverVazia() {
        CustomStack<Integer> stack = new CustomStack<>(6, new IntegerStrategy());
        NumberAscOrder<Integer> order = new NumberAscOrder<>(stack);

        List<Integer> resultado = order.sort();

        assertTrue(resultado.isEmpty(), "A lista deveria estar vazia");
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException se a pilha for nula")
    void deveLancarExcecaoSePilhaForNula() {
        assertThrows(IllegalArgumentException.class, () -> new NumberAscOrder<>(null),
                "Esperado lançamento de exceção ao passar pilha nula");
    }

    @Test
    @DisplayName("Deve manter o comportamento com números negativos e repetidos")
    void deveOrdenarComNumerosNegativosERepetidos() throws StackFullException {

        CustomStack<Integer> stack = new CustomStack<>(7, new IntegerStrategy());
        stack.push(-10);
        stack.push(5);
        stack.push(0);
        stack.push(-10);
        stack.push(3);
        stack.push(3);
        stack.push(1);

        NumberAscOrder<Integer> order = new NumberAscOrder<>(stack);

        List<Integer> resultado = order.sort();

        assertEquals(List.of(-10, -10, 0, 1, 3, 3, 5), resultado,
                "A lista deveria estar corretamente ordenada, incluindo negativos e repetidos");
    }
}
