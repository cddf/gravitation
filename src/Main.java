
/**
 *
 * @author Dreist
 */
import java.io.FileWriter;
import java.io.IOException;

import math.Function;
import math.FunctionGravitation;
import math.FunctionVelocity;
import objects.Planet;
import solver.Solver;
import solver.SolverEuler;

public class Main {
	double _h, _G, _dim;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Planet[] p = new Planet[2];
		double[] x1 = {0,-50,0};
		double[] x2 = {0,50,0};
		double[] v1 = {0,0,0};
		double[] v2 = {0,0,0};
		Planet X1 = new Planet(1.0, x1, v1, 0.0);
		Planet X2 = new Planet(1.0, x2, v2, 0.0);
		p[0] = X1;
		p[1] = X2;

		Function fG = new FunctionGravitation(0.1, p);
		Solver sG = new SolverEuler(fG);
		Function fV = new FunctionVelocity(sG, p, 0.1);
		Solver sV = new SolverEuler(fV);

		double[][] r = new double[2][3];
		double[][] dr = new double[2][3];

		for(int i = 0; i < 10; i++) {
			r[0] = p[0].getPosition();
			r[1] = p[1].getPosition();

			dr = sV.calculate(r, 0.1, 0.1 * i);
			// x += dr
			for (int m = 0; m < p.length; m++){
				for (int n = 0; n < r[0].length; n++) {
					r[m][n] += dr[m][n];
				}
				p[m].movePlanet(r[m], 0.1 * i + 0.1);
			}

			System.out.print(r[0][0] + " " + r[0][1] + " " + r[0][2] + " | ");
			System.out.println(r[1][0] + " " + r[1][1] + " " + r[1][2]);
		}

	}
	
	private void writePlanets(Planet[] p, String name) {
		try {
			FileWriter fstream = new FileWriter(name);
			
			// File Header
			fstream.write("# G = " + _G + 
					"\n# dim = " + _dim);
			
			for (int i = 0; i < p.length; i++){
				fstream.write(p[i].getMass() + " \n");
			}
			fstream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
