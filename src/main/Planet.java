package main;
// @author Dreist

public class Planet {
    double _mass,_x,_y,_z,_Vx,_Vy,_Vz;

    /**
     * Constructor von Planet
     * 
     * @param mass Mass   
     * @param x x
     * @param y y
     * @param z z
     * @param vX v_x
     * @param vY v_y
     * @param vZ v_z
     */
    public Planet(double mass, double x, double y, double z, double Vx, double Vy, double Vz){
        _mass = mass;
        _x = x;
        _y = y;
        _z = z;
        _Vx = Vx;
        _Vy = Vy;
        _Vz = Vz;  
    }

    /*
     * #########################  Get/Set Methods  #########################
     */
    
    public double getMass(){
        return _mass;
    }
    public void setX(double x){
        _x = x;
    }
    public double getX(){
        return _x;
    }
    public void setY(double y){
        _y = y;
    }
    public double getY(){
        return _y;
    }
    public void setZ(double z){
        _z = z;
    }
    public double getZ(){
        return _z;
    }
    public void setVx(double Vx){
        _Vx = Vx;
    }
    public double getVx(){
        return _Vx;
    }
    public void setVy(double Vy){
        _Vy = Vy;
    }
    public double getVy(){
        return _Vy;
    }
    public void setVz(double Vz){
        _Vz = Vz;
    }
    public double getVz(){
        return _Vz;
    }

    
    
    
}
