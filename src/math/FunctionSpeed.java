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
  double _h;

  public FunctionSpeed(Solver solver, Planet[] p, double h){
    _solver = solver;
    _h = h;
  }


  /**
   * @param x 3d position vector for every planet 
   * @param t time
   * @return calculated speed
   */
  @Override
  public double[][] value(double[][] x, double t) {
    double[][] v = _solver.calculate(x, _h, t-_h);
    return v;
  }
}
