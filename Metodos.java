import java.util.Scanner;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    public ObjProducto[][] LlenarMatriz(int d) {
        ObjProducto[][] m = new ObjProducto[d][d];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                ObjProducto o = new ObjProducto();
                System.out.println("Ingrese el nombre producto");
                o.setNombre(sc.next());
                System.out.println("Ingrese el precio del producto");
                o.setPrecio((Double) (Math.random() * 80000 + 1));
                System.out.println("Ingrese la cantidad");
                o.setCantidad((int) (Math.random() * 10 + 1));
                m[i][j] = o;
            }
        }
        return m;
    }

    public void MotrarMatrizOriginal(ObjProducto[][] m, int punto) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.println("Nombre Producto:" + m[i][j].getNombre());
                System.out.println("Precio Producto: " + m[i][j].getPrecio());
                if (punto == 5) {
                    System.out.println("Stock Producto: " + m[i][j].getCantidad());
                } else {
                    System.out.println("Cantidad Producto: " + m[i][j].getCantidad());
                }

                System.out.println("");
            }
        }
    }

    public String BuscarProducto(ObjProducto[][] m) {
        String mensaje = "", MensajeResult = "";
        System.out.println("ingrese el nombre del producto a buscar");
        mensaje = sc.next();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j].getNombre().toLowerCase().equals(mensaje)) {
                    MensajeResult = "el producto se encuentra en la fila: " + i + " en la columna: " + j;
                }
            }
        }
        return MensajeResult;
    }

    public ObjProducto[][] FusionarMatrices(ObjProducto[][] m1, ObjProducto[][] m2, ObjProducto[][] m3) {
        int i3 = 0, j3 = 0, j3aux = 0;
        for (int i = 0; i < m1.length; i++) {
            int a = m3[0].length;
            if (j3aux == a) {
                break;
            }
            for (int j = 0; j < m1.length; j++) {
                for (int i2 = 0; i2 < m2.length; i2++) {
                    for (int j2 = 0; j2 < m2.length; j2++) {
                        if (m1[i][j].getNombre().equalsIgnoreCase(m2[i2][j2].getNombre())) {
                            ObjProducto o = new ObjProducto();
                            o.setNombre(m1[i2][j2].getNombre());
                            o.setCantidad(m1[i][j].getCantidad() + m2[i2][j2].getCantidad());
                            o.setPrecio(m1[i2][j2].getPrecio());
                            m3[i3][j3aux] = o;
                            j3 = j3 + 1;
                        } else {
                            if (j3 > ((m1.length * m1.length) - 1)) {
                                ObjProducto o = new ObjProducto();
                                o.setNombre(m1[i2][j2].getNombre());
                                o.setCantidad(m1[i2][j2].getCantidad());
                                o.setPrecio(m1[i2][j2].getPrecio());
                                m3[i3][j3aux] = o;
                                j3aux = j3aux + 1;
                            } else {
                                ObjProducto o = new ObjProducto();
                                o.setNombre(m2[i2][j2].getNombre());
                                o.setCantidad(m2[i2][j2].getCantidad());
                                o.setPrecio(m2[i2][j2].getPrecio());
                                m3[i][j3] = o;
                                j3 = j3 + 1;

                            }

                        }

                    }
                }
                i3 = i3 + 1;
            }
            i3 = i3 + 1;
        }
        return m3;
    }
}
