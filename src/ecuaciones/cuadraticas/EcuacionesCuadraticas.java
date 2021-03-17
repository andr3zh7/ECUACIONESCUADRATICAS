// ANDRES LORIA HERRERA 19070058
// 4° "B"
package ecuaciones.cuadraticas;

import java.util.Scanner;

public class EcuacionesCuadraticas {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int r = 0, obcion = 0;
        double a = 0, b = 0, c = 0;
        double x1, x2, raiz1, raiz2;
        do {

            System.out.println("lista de actividades que puede realizar");
            
            System.out.println("1. calcular una ecuacion cuadratica por formula general");
            System.out.println("2. calcular una ecuacion cuadratica por raizes de la formula general");
            System.out.println("3. calcular una ecuacion cuadratica por fórmula cuadrática al racionalizar el numerador");
            System.out.println("4. calcular e^x");
            System.out.println("5. calcular e^-x");
            System.out.println("6. calcular la varianza");
            System.out.println("escoge una actividad que quieras realizar");
            obcion = teclado.nextInt();
            switch (obcion) {

                case 1: {
                    System.out.println("calculo de una ecuacion cuadratica por formula general");
                    System.out.println("ingresa el primer valor (a)");
                    a = teclado.nextDouble();
                    System.out.println("ingresa el segundo valor (b)");
                    b = teclado.nextDouble();
                    System.out.println("ingresa el tercer valor (c)");
                    c = teclado.nextDouble();
                    double numero = (b * b) - (4 * a * c);
                    if (numero > 0) {
                        System.out.println("la ecuacion tiene dos respuestas");
                        x1 = (-b + Math.sqrt(numero)) / 2 * a;
                        x2 = (-b - Math.sqrt(numero)) / 2 * a;
                        System.out.println("x1= " + x1);
                        System.out.println("x2= " + x2);
                    } else {
                        if (numero == 0) {
                            x1 = (-b) / 2 * a;
                            System.out.println("la ecuacion solo tiene una respuesta");
                            System.out.println("x1=" + x1);
                        } else {
                            System.out.println("la ecuacion no tiene solucion");
                        }
                    }
                }
                break;

                case 2:
                    System.out.println("calculo de una ecuacion cuadratica por raizes de la formula general");
                    System.out.println("ingresa el primer valor (a)");
                    a = teclado.nextDouble();
                    System.out.println("ingresa el segundo valor (b)");
                    b = teclado.nextDouble();
                    System.out.println("ingresa el tercer valor (c)");
                    c = teclado.nextDouble();
                    if ((4 * a * c) > (b * b)) {
                        System.out.println("esta ecuacion no tiene raiz");

                    } else if (a > 0 || a < 0) {
                        double x = (b * b) - 4 * a * c;
                        raiz1 = -b + Math.pow(x, 0.5);
                        raiz1 = raiz1 / (2 * a);
                        raiz2 = ((-b) - (Math.pow(x, 0.5))) / (2 * a);
                        System.out.println("raiz1= " + raiz1);
                        System.out.println("raiz2= " + raiz2);
                    }
                    break;

                case 3: {
                    System.out.println("calculo de una ecuacion cuadratica por fórmula cuadrática al racionalizar el numerador");    
                    System.out.println("ingresa el primer valor (a)");
                    a = teclado.nextDouble();
                    System.out.println("ingresa el segundo valor (b)");
                    b = teclado.nextDouble();
                    System.out.println("ingresa el tercer valor (c)");
                    c = teclado.nextDouble();

                    double numero1 = (b * b) - 4 * (a * c);
                    x1 = (-2 * c) / (b + Math.sqrt(numero1));
                    System.out.println("el valor de x1= " + x1);
                    double numero2 = (b * b) - 4 * (a * c);
                    x2 = (-2 * c) / (b - Math.sqrt(numero2));
                    System.out.println("el valor de x2= " + x2);
                }
                break;
                case 4: {
                    System.out.println("calculo de e^x");
                    System.out.println("terminos deseados(j)");
                    int n = teclado.nextInt();
                    System.out.println("ingrese el valor de x");
                    int x = teclado.nextInt();

                    double s = 0, t;
                    for (int i = 0; i < n; i++) {
                        t = Math.pow(x, i) / factorial(i);
                        s += t;
                    }

                    System.out.printf("f(%d)=%f\n", x, s);
                }
                break;
                case 5: {
                    System.out.println("calculo de e^-x");
                    System.out.println("");
                    System.out.println("introduzca el valor de X");
                    int x = teclado.nextInt();
                    System.out.println("terminos deseados(j)");
                    int j = teclado.nextInt();
                    double suma = 0;

                    for (int i = 0; i < j + 1; i++) {
                        suma = suma + 1 / (Math.pow(x, i) / (factorial(i)));
                    }

                    System.out.println("");
                    System.out.println("resultado: " + suma);
                }
                break;
                case 6: {
                    System.out.println("calculo de la varianza");
                    System.out.println("tamaño de la serie");
                    int serie=teclado.nextInt();
                    int uno[] = new int[serie];
                    int sumatoria = 0;
                    float media = 0;
                    double varianza = 0;

                    System.out.println("Ingrese el valor de 10 numeros como prueba");

                    for (int i = 0; i < serie; i++) {

                        System.out.print("Ingrese el valor " + (i + 1) + ":");
                        uno[i] = teclado.nextInt();

                        sumatoria = sumatoria + uno[i];

                    }
                    

                    media = sumatoria / serie;

                    for (int i = 0; i < serie; i++) {
                        double rango;
                        double y=uno[i]-media;
                        rango = Math.pow(y, 2f);
                        varianza = varianza + rango;
                    }
                    varianza = varianza / serie;
                    System.out.println("la varianza de los numeros ingresados es: "+varianza);
                }
                break;

            }

            System.out.println("quieres ingresar otra ecuacion 1=si, 2=no");
            r = teclado.nextInt();
        } while (r == 1);
    }

    public static double factorial(int n) {
        double aux = 1;
        for (int i = 2; i <= n; i++) {
            aux *= i;
        }
        return aux;
    }
}