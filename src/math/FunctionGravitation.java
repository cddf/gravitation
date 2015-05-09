package math;
// @author Dreist

import objects.Planet;
import math.Function;


public class FunctionGravitation implements Function {
  double _G;

  public FunctionGravitation(double G){
    _G = G;
  }


  @Override
  public Planet[] value(Planet[] P, double t) {
    double D;
    double[] d = {0.0,0.0,0.0};
    Planet p[] = P.clone();

    for (Planet i: p) {
      double [] F = {0.0,0.0,0.0};

      for (Planet j: p) {

        if (i != j) {
          double[] position1 = i.getPosition();
          double[] position2 = j.getPosition();

          for (int n = 0; n < 3; n++) {
            d[n] = position1[n] - position2[n];
          }

          D = Math.sqrt(d[0]*d[0] + d[1]*d[1] + d[2]*d[2]);

          for (int n = 0; n < 3; n++) {
            F[n] += _G * i.getMass() * j.getMass() * d[n] / (D*D*D);
          }

        }
      }

    }
    return p;
  }
}
