package math;
// @author Dreist

import main.Planet;


public class FunctionGravitation implements Function {
    double _G;

    public FunctionGravitation(double G){
        _G = G;
    }


    @Override
    public Planet[] value(Planet[] P, double t) {
        double dx, dy, dz, d, F, Vx, Vy, Vz;
        Planet p[] = P.clone();
        for (Planet i: p) {
            for (Planet j: p) {
                if (i != j) {
                    dx = i.getX() - j.getX();
                    dy = i.getY() - j.getY();
                    dz = i.getZ() - j.getZ();
                    
                    d = Math.sqrt(dx*dx + dy*dy + dz*dz);
                    F = _G * j.getMass() / d;
                    Vx = i.getVx() + F * dx / d;
                    Vy = i.getVy() + F * dy / d;
                    Vz = i.getVz() + F * dz / d;
                    
                    i.setVx(Vx);
                    i.setVy(Vy);
                    i.setVz(Vz);
                    
                    i.setX(Vx + i.getX());
                    i.setY(Vy + i.getY());
                    i.setZ(Vz + i.getZ());
                }
            }
        }
        return p;
    }
}
