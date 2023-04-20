import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private static Calculadora calculadora;
    Throwable exception;
    @BeforeAll
    public static void init(){
        calculadora = new Calculadora();
    }


    @Test
    public void whenCalculatorInitializedThenReturnTrue() {
        Calculadora calculadora = new Calculadora();
        assertTrue(calculadora.getStatus());
    }

    @Test
    public void whenAdditionTwoNumberThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();

        assertEquals( 5, calculadora.addition(2,3));
    }

    @Test
    public void whenDivisionThenReturnCorrectAnswer() {
        assertEquals(2, calculadora.division(8, 4));
    }

    @Test
    public void whenDivisionByZeroThenThrowException() {
        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.division(5, 0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }

    @Test
    public void whenMultiplicacionThenReturnCorrectAnswer() {
        assertEquals(32, calculadora.multiplicacion(8, 4));
    }

    @Test
    public void whenMultiplicacionLongNumberThenThrowException(){
        exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.multiplicacion(Integer.MAX_VALUE, 2);
        });
        assertEquals("Numeros muy grandes, Overflow en la multiplicacion", exception.getMessage());
    }

    @Test
    public void whenRaizcuadradaNumberPositiveThenReturnCorrectAnswer() {
        assertEquals(2, calculadora.raizCuadrada(4));
    }

    @Test
    public void whenRaiznCuadradaNumberNegativeThenTrhowException(){
        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.raizCuadrada(-5);
        });
        assertEquals("No se puede calcular la raiz cuadrada de un numero negativo", exception.getMessage());
    }

    @Test
    public void whenFactorialNumberPositiveThenReturnCorrectAnswer() {
        assertEquals(24, calculadora.factorial(4));
    }

    @Test
    public void whenFactorialNumberNegativeThenTrhowException(){
        exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.factorial(-5);
        });
        assertEquals("No se puede calcular el factorial de un numero negativo", exception.getMessage());
    }

}