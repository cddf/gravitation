
/**
 *
 * @author Dreist
 */
import math.Function;
import math.FunctionGravitation;
import math.FunctionSpeed;
import objects.Planet;
import solver.Solver;
import solver.SolverEuler;

public class Main {
    double _h;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Planet[] p = new Planet[2];
      double[] x1 = {0,0,0};
      double[] x2 = {0,1,0};
      double[] v1 = {0,0,0};
      double[] v2 = {0,0,0};
      Planet X1 = new Planet(1.0, x1, v1, 0.0);
      Planet X2 = new Planet(1.0, x2, v2, 0.0);
      p[0] = X1;
      p[1] = X2;

      Function fG = new FunctionGravitation(1, p);
      Solver sG = new SolverEuler(fG);
      Function fS = new FunctionSpeed(sG, p, 0.1);
      Solver sS = new SolverEuler(fS);

      double[][] r = new double[2][3];
      r[0] = p[0].getPosition();
      r[1] = p[1].getPosition();

      for(int i = 0; i < 100; i++) {
        r = sS.calculate(r, 0.1, i);
        System.out.print(r[0][0] + " " + r[0][1] + " " + r[0][2] + " | ");
        System.out.println(r[1][0] + " " + r[1][1] + " " + r[1][2]);
      }

        
      System.out.println("Irgendwann wird hier das Programm gestartet..."); 
    }
    
    
}
