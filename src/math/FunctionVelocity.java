package math;
// @author Dreist

import objects.Planet;
import math.Function;
import math.FunctionGravitation;
import solver.Solver;


/**
 * This class gives the speed to every Planet
 */
public class FunctionVelocity implements Function {
  Solver _solver;
  double _h;
  Planet[] _p;

  public FunctionVelocity(Solver solver, Planet[] p, double h){
    _solver = solver;
    _h = h;
    _p = p;
  }


  /**
   * @param x 3d position vector for every planet 
   * @param t time
   * @return calculated velocity
   */
  @Override
  public double[][] value(double[][] x, double t) {
	  double[][] v = _solver.calculate(x, _h, t-_h);
	  
	  for (int i = 0; i < _p.length; i++){
		  for (int j = 0; j < x[0].length; j++) {
			  v[i][j] += _p[0].getVelocity()[j];
		  }
	  }
    return v;
  }
}
