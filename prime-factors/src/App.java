import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        NumerosPrimos numerosPrimos = new NumerosPrimos();
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número"));
        ArrayList<Integer> numPrimos = numerosPrimos.generate(numero);
        JOptionPane.showMessageDialog(null, "Los números primos son: " + numPrimos.toString(), "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
    }
}
