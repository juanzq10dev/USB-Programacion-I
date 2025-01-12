
import java.util.*;

public class NumerosPrimos {
    
    public ArrayList<Integer> generate(int numeroDescomponer) {
        ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
        int divisor = 2;
        while (divisor <= numeroDescomponer) {
            int producto = numeroDescomponer % divisor;
            if (producto == 0) {
                if (numerosPrimos.size() > 0) {
                    for (int i : numerosPrimos) {
                        producto = divisor % i;
                        if (producto == 0) {
                            break;
                        }
                    }
                    if (producto != 0) {
                        numerosPrimos.add(divisor);
                    }
                } 
                else {
                    numerosPrimos.add(divisor);
                }
            }
            divisor = divisor + 1;
        }
        return numerosPrimos;
    }
}
