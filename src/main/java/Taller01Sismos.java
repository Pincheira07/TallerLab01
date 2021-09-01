import java.util.Scanner;

public class Taller01Sismos {
    public static void main(String[] args) {
        iniciarSimulacion();
    }

    public static void iniciarSimulacion() {
        iniciarMenu();
    }

    public static void iniciarMenu() {
        while (true) {
            mostrarMenu();
            int opcion = leerOpcionMenu();
            if (!validarOpcionMenu(opcion)){
                System.out.println("Valor fuera de rango");
            }else{
                ejecutarMenu(opcion);
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

    public static void ejecutarMenu(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("Ingresando datos...");

            }
            case 2 -> {
                System.out.println("El sismo de mayor magnitud fue: ");
            }
            case 3 -> {
                System.out.println("Hubieron " + 10 +"sismos mayores a 5.0");
            }
            case 4 -> {
                System.out.println("Alerta!!! se debe evacuar zona costera!");

            }
            case 0 -> System.exit(0);
        }
    }


}
