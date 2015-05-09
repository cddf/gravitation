
package solver;

import objects.Planet;

/**
 *
 * @author Dreist
 */
public interface Solver {
    public Planet[] calculate(Planet p[], double h, double t);
    
}
