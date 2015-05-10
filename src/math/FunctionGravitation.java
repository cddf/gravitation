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
		double[][] a = new double[x.length][3];

		for (int i = 0; i < _p.length; i++) {
			a[i][0] = 0.0; // TODO schöner
			a[i][1] = 0.0;
			a[i][2] = 0.0;

			for (int j = 0; j < _p.length; j++) {

				if (i != j) {
					double[] d = new double[x[0].length]; // distance vector between Planets

					// d = r_j - r_i
					double DSquare = 0;
					for (int n = 0; n < x[0].length; n++) {
						d[n] = x[j][n] - x[i][n];
						DSquare += d[n] * d[n];
					}

					D = Math.sqrt(DSquare);

					// D should not be zero
					if (D == 0) D = 1.0; // TODO Richtiger Wert für D

					for (int n = 0; n < x[0].length; n++) {
						a[i][n] += _G * _p[j].getMass() * d[n] / (D*D*D);
					}
				}
			}
		}

		return a;
	}
}
