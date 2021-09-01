import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Taller01Sismos {
    public static void main(String[] args) {
        iniciarSimulacion();
    }

    public static void iniciarSimulacion() {
        double[][] sismos = new double[10][7];
        iniciarMenu(sismos);
    }

    public static void iniciarMenu(double[][] sismos) {
        while (true) {
            mostrarMenu();
            int opcion = leerOpcionMenu();
            if (!validarOpcionMenu(opcion)){
                System.out.println("Valor fuera de rango");
            }else{
                ejecutarMenu(opcion, sismos);
            }
        }
    }

    public static int leerOpcionMenu() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese una opción:");
        return scanner.nextInt();
    }

    private static boolean validarOpcionMenu(int opcion) {
        return -1 < opcion && opcion < 5;
    }

    public static void mostrarMenu(){
        System.out.println("***********************************************************");
        System.out.println("-------------Bienvenido al simulador de sismos-------------");
        System.out.println("*                       MENÚ                              *");
        System.out.println("[1]Ingresar datos");
        System.out.println("[2]Mostrar sismo de mayor magnitud");
        System.out.println("[3]Contar sismos mayores o iguales a 5.0");
        System.out.println("[4]Enviar SMS por cada sismo mayor o igual a 7.0");
        System.out.println("[0]Salir");
        System.out.println("***********************************************************");

    }

    public static void ejecutarMenu(int opcion, double[][] sismos) {
        switch (opcion) {
            case 1 -> {
                System.out.println("Ingresando datos...");
                llenarArreglo(sismos);
            }
            case 2 -> {
                if (comprobarLlenado(sismos)==0){
                    System.out.println("Ingresa los datos primero");
                    iniciarMenu(sismos);
                }
                double mayorSismo = buscarMayorSismo(sismos);
                System.out.println("El sismo de mayor magnitud fue de: " + mayorSismo + " grados en la escala de magnitud de momento");

            }
            case 3 -> {
                if (comprobarLlenado(sismos)==0){
                    System.out.println("Ingresa los datos primero");
                    iniciarMenu(sismos);
                }
                int mayoresA5 = contarMayoresa5(sismos);
                System.out.println("¡¡Hubieron " + mayoresA5 +" sismos de magnitud mayor a 5.0!!");
            }
            case 4 -> {
                if (comprobarLlenado(sismos)==0){
                    System.out.println("Ingresa los datos primero");
                    iniciarMenu(sismos);
                }
                enviarSMS(sismos);
            }
            case 0 -> System.exit(0);
        }
    }

    public static double[][] llenarArreglo(double[][] sismos) {
        for (int i = 0; i < sismos.length ; i++) {
            for (int j = 0; j < sismos[i].length; j++) {
                sismos[i][j] =  Math.random()*10;
            }
        }
        return sismos;
    }

    public static void mostrarArreglo(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("[" + arr[i][j] + "]");

            }
            System.out.println("");
        }
    }

    public static int contarMayoresa5(double[][] arr) {
        int contadorMayoresA5 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>=5.0){
                    contadorMayoresA5++;
                }
            }
        }
        return contadorMayoresA5;
    }

    public static void enviarSMS(double[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>=7.0){
                    System.out.println("Alerta!!! se debe evacuar zona costera!");
                }
            }
        }
    }
    public static double buscarMayorSismo(double[][] arr){
        double mayor = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>mayor){
                    mayor = arr[i][j];
                }
            }
        }
        return mayor;
    }

    public static double comprobarLlenado(double[][] arr){
        double sumTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sumTotal= sumTotal +arr[i][j];
            }
        }
        return  sumTotal;
    }



}
