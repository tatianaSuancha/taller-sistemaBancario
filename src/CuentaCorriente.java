public class CuentaCorriente extends CuentaBancaria {
    private double comisionPorTransaccion;
    private double limiteSobregiro;


    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double comisionPorTransaccion, double limiteSobregiro) {
        super(numeroCuenta, titular, saldo);
        this.comisionPorTransaccion = comisionPorTransaccion;
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public String describir() {
        return super.describir()+" | Comisión por transacción: $"+comisionPorTransaccion;
    }

    @Override
    public double calcularComision() {
        return comisionPorTransaccion;
    }

    @Override
    public void realizarRetiro(double monto) {
        double saldoResultante = getSaldo() - monto - comisionPorTransaccion;
        if (saldoResultante < -limiteSobregiro) {
            System.out.println("el retiro no posible porque es mayor que el limite de sobregiro");
        } else {
            setSaldo(saldoResultante);
            System.out.println("el retiro si fue posible");
        }
    }

}
