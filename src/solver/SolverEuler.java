package solver;
// @author Dreist

import objects.Planet;
import math.Function;

public class SolverEuler implements Solver {
  Function _f;

  public SolverEuler(Function f){
    _f = f;
  }

  @Override
  public double[][] calculate(double x[][], double h, double t) {
    double[][] f = _f.value(x, t+h);

    for (int i = 0; i < x.length; i++) {
      for (int j = 0; j < x[0].length; j++) {
        x[i][j] += 0 ;//h * f[i][j];
      }
    }
    return x;
  }
}
