package solver;
// @author Dreist

import math.Function;

public class SolverEuler implements Solver {
  Function _f;

  public SolverEuler(Function f){
    _f = f;
  }

  @Override
  public double[][] calculate(double x[][], double h, double t) {
    double[][] f = _f.value(x, t+h);
    double[][] X = new double[x.length][x[0].length];

    for (int i = 0; i < x.length; i++) {
      for (int j = 0; j < x[0].length; j++) {
        X[i][j] = h * f[i][j];
      }
    }
    return X;
  }
}
