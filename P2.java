public class P2 {
    public void Punto2(int d) {
        Metodos m = new Metodos();
        Ventas[][] matriz = m.LlenarMatrizConVentasCadaMes(d);
        m.MostrarMatrizConVentasAbril(matriz);
    }
}
