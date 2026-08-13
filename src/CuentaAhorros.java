public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresMensual;
    private double saldoMinimo;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteresMensual, double saldoMinimo) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteresMensual = tasaInteresMensual;
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public String describir() {
        return super.describir() +" | Tasa mensual: " + tasaInteresMensual+"%";
    }

    @Override
    public double calcularComision() {
        if (getSaldo() < saldoMinimo) {
            return 12000.0;
        } else {
            return 0.0;
        }
    }

    public void realizarRetiro(double monto, boolean esUrgente) {
        if (esUrgente) {
            double saldoResultante = getSaldo() - monto;
            if (saldoResultante < saldoMinimo) {
                setSaldo(saldoResultante - 12000.0);
            } else {
                setSaldo(saldoResultante);
            }
        } else {
            realizarRetiro(monto);
        }
    }

    public double calcularInteresDelMes() {
        return getSaldo() * tasaInteresMensual / 100;
    }
}
