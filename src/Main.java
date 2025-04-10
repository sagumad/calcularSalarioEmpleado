import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreEmpleado, documentoEmpleado, diaDescanso = "";
        double salarioBruto = 0;
        double salarioNeto = 0;
        double deduccionPension = 0;
        double deduccionSalud = 0;
        double horasTrabajadas = 0;
        double valorHora = 0;
        double bonificacionEmpleado = 0;
        double valorSalarioMinimo = 1423500;
        double auxilioTransporte = 200000;
        double valorHorasExtras = 0;
        double cantidadHorasExtras = 0;
        double totalValorHorasExtras = 0;

        System.out.print("Ingrese el nombre del empleado: ");

        nombreEmpleado = sc.nextLine();

        System.out.print("Ingrese el documento del empleado: ");

        documentoEmpleado = sc.nextLine();

        System.out.print("ingrese el dia de descanso (L-V): ");

        diaDescanso = sc.nextLine();

        System.out.print("ingrese el valor de la hora:");

        valorHora = sc.nextDouble();

        System.out.print("ingrese las horas trabajadas:");

        horasTrabajadas = sc.nextDouble();

        salarioBruto = horasTrabajadas * valorHora;

        if (salarioBruto <= valorSalarioMinimo * 2) {
            auxilioTransporte = 200000;
            bonificacionEmpleado = 0.1 * salarioBruto;
        } else {
            auxilioTransporte = 0;
            bonificacionEmpleado = 0;

        }
        deduccionPension = 0.04 * salarioBruto;
        deduccionSalud = 0.04 * salarioBruto;
        if (horasTrabajadas > 96) {
            cantidadHorasExtras = horasTrabajadas - 96;
            valorHorasExtras = valorHora * 1.25;
            totalValorHorasExtras = cantidadHorasExtras * valorHorasExtras;
            salarioBruto = salarioBruto + totalValorHorasExtras;
        } else {
            cantidadHorasExtras = 0;
            valorHorasExtras = 0;
            totalValorHorasExtras = 0;

        }

        if (horasTrabajadas < 24) {
            System.out.print("El empleado no ha trabajado lo suficiente para recibir salario.");
        } else {
            salarioNeto = salarioBruto - (deduccionPension + deduccionSalud) + auxilioTransporte + bonificacionEmpleado
                    + valorHorasExtras;
            System.out.println("El salario bruto del empleado " + nombreEmpleado + " es: " + salarioBruto);
            System.out.println("El salario neto del empleado" + nombreEmpleado + " es: " + salarioNeto);
            System.out.println("El valor de la deduccion de pension es: " + deduccionPension);
            System.out.println("El valor de la deduccion de salud es: " + deduccionSalud);
            System.out.println("El valor del auxilio de transporte es: " + auxilioTransporte);
            System.out.println(
                    "El valor de la bonificacion del empleado " + nombreEmpleado + "es: " + bonificacionEmpleado);
            System.out.println("El valor de las horas extras es: " + totalValorHorasExtras);
        }

    }
}
