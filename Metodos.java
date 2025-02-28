import java.util.Scanner;


public class Metodos {
    Scanner sc = new Scanner(System.in);

    public Ventas[][] LlenarMatrizConVentasCadaMes(int d) {
        Ventas[][] m = new Ventas[d][d];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                Ventas v = new Ventas();
                System.out.println("ingrese el mes");
                v.setMes(sc.next());
                System.out.println("ingrese las ventas");
                v.setVentas(sc.nextInt());
                m[i][j] = v;
            }
        }
        return m;
    }
    public void ValidarMesAbril(Ventas[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j].getMes().equalsIgnoreCase("abril")) {
                    System.out.println("las ventas del mes de abril son: " + m[i][j].getVentas());
                }
            }
        }
 }
            
    public void MostrarMatrizConVentasAbril(Ventas[][] m ) {
        System.out.println("Desea validar el mes de abril");
        String respuesta = sc.next();
        if (respuesta.equalsIgnoreCase("si")) {
            ValidarMesAbril(m);
        }
       
    }

}
