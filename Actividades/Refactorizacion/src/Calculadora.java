public class Calculadora {
    private boolean status;

    public Calculadora() {
        this.status = true;
    }
    public boolean getStatus() {
        return status;
    }
    public int addition(int a, int b) {
        return a + b;
    }
    public int resta(int a, int b) {
        return a - b;
    }
    public int division(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return a / b;
    }
    public int multiplicacion(int a, int b){
        try {
            return Math.multiplyExact(a,b);
        } catch (ArithmeticException e){
            throw new ArithmeticException("Numeros muy grandes, Overflow en la multiplicacion");
        }
    }

    public double raizCuadrada(double a){
        if(a<0) {
            throw new IllegalArgumentException("No se puede calcular la raiz cuadrada de un numero negativo");
        }
        return Math.sqrt(a);
    }

    public int factorial(int a){
        if(a<0) {
            throw new IllegalArgumentException("No se puede calcular el factorial de un numero negativo");
        }
        int fact = 1;
        for(int i=2; i<=a; i++){
            fact *= i;
        }
        return fact;
    }

}
