package math;
// @author Dreist

import objects.Planet;
import math.Function;
import math.FunctionGravitation;
import solver.Solver;


/**
 * This class gives the speed to every Planet
 */
public class FunctionSpeed implements Function {
  Solver _solver;
  Function _f;
  double _h = h;

  public FunctionSpeed(Solver solver, Planet[] p, double G, double h){
    _solver = solver;
    _h = h;

    _f = new FunctionGravitation(G, p);
  }


  /**
   * @param x 3d position vector for every planet 
   * @param t time
   * @return calculated speed
   */
  @Override
  public double[][] value(double[][] x, double t) {
    double[][] v = _solver.calculate(x, _h, t-_h);
  }
}
