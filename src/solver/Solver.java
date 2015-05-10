
package solver;

import objects.Planet;

/**
 *
 * @author Dreist
 */
public interface Solver {

  /**
   * @return result x[] of the next time step t + h
   */
  public double[][] calculate(double x[][], double h, double t);
    
}
