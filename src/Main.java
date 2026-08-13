public class Main {
    public static void main(String[] args) {
        CuentaAhorros cuentaAhorros = new CuentaAhorros("1001", "Lina Lopez", 600000, 1.5, 500000);
        System.out.println("--- Cuenta de Ahorros ---");
        System.out.println(cuentaAhorros.describir());
        cuentaAhorros.realizarRetiro(200000, true);
        System.out.println(cuentaAhorros.describir());
        System.out.println("Interes del mes: $" + cuentaAhorros.calcularInteresDelMes());

        System.out.println("\n--- Cuenta Corriente ---");
        CuentaCorriente cuentaCorriente = new CuentaCorriente("2002", "Tatiana Perez", 100000, 5000, 300000);
        System.out.println(cuentaCorriente.describir());
        cuentaCorriente.realizarRetiro(200000);
        System.out.println("Saldo despues de retiro de 200000: $" + cuentaCorriente.getSaldo());
        System.out.println("Intentando retiro de 300000...");
        cuentaCorriente.realizarRetiro(300000);
        System.out.println("Saldo final: $" + cuentaCorriente.getSaldo());

        System.out.println("\n--- Cuenta de Inversion ---");
        CuentaInversion cuentaInversion = new CuentaInversion("3003", "Jennifer Lopez", 1000000, 11.0, 12, 50000);
        System.out.println(cuentaInversion.describir());
        cuentaInversion.realizarRetiro(100000);
        System.out.println("Saldo despues de retiro anticipado: $" + cuentaInversion.getSaldo());
        System.out.println("Comision a 6 meses (antes de plazo): $" + cuentaInversion.calcularComision(6));
        System.out.println("Comision a 12 meses (en plazo): $" + cuentaInversion.calcularComision(12));

        System.out.println("\n--- Prueba de Polimorfismo ---");
        CuentaBancaria[] cuentas = {cuentaAhorros, cuentaCorriente, cuentaInversion};
        for (CuentaBancaria cb : cuentas) {
            System.out.println(cb.describir());
            System.out.println("Comision base: $" + cb.calcularComision());
        }
    }
}