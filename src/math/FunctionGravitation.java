package math;
// @author Dreist

import objects.Planet;
import math.Function;


/**
 * This class gives the Force to every Planet
 */
public class FunctionGravitation implements Function {
  double _G;
  Planet[] _p;

  public FunctionGravitation(double G, Planet[] p){
    _G = G;
    _p = p;
  }


  /**
   * @param x 3d position vector for every planet 
   * @param t time
   * @return calculated Force / Mass
   */
  @Override
  public double[][] value(double[][] x, double t) {
    double D; // absolute value of the distance
    double[] d = {0.0,0.0,0.0}; // distance vector between Planets
    double[][] F = new double[x.length][3];

    for (int i = 0; i < _p.length; i++) {
      F[i][0] = 0.0;
      F[i][1] = 0.0;
      F[i][2] = 0.0;

      for (int j = 0; j < _p.length; j++) {

        if (i != j) {

          for (int n = 0; n < 3; n++) {
            d[n] = x[i][n] - x[j][n];
          }

          D = Math.sqrt(d[0]*d[0] + d[1]*d[1] + d[2]*d[2]);

          // D should not be zero
          if (D == 0) D = 1.0; // TODO Richtiger Wert für D

          for (int n = 0; n < 3; n++) {
            F[i][n] += _G * _p[j].getMass() * d[n] / (D*D*D);
          }
        }
      }
    }

    return x;
  }
}
