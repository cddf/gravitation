package objects;
// @author Dreist

public class Planet {
  double _mass, _t;
  double[] _pos, _velocity;

  /**
   * Constructor von Planet
   * 
   * @param mass Mass   
   * @param position Position [x,y,z]
   * @param velocity Velocity [Vx,Vy,Vz]
   */
  public Planet(double mass, double[] position, double[] velocity, double t){
    assert(mass != 0);
    assert(position.length == 3);
    assert(velocity.length == 3);

    _mass = mass;
    _pos = position;
    _velocity = velocity;
    _t = t;
  }

  /**
   * Moves the planet in dependence of Force and time difference
   *
   * @param F Force in x,y,z direction
   * @param t time
   */
  public void movePlanet(double[] x, double t) {

    for (int i = 0; i < x.length; i++) {
      _velocity[i] += x[i] / t;
      _pos[i]   = x[i];
    }
    _t = t;
  }


  /*
   * #########################  Get/Set Methods  #########################
   */

  public double getMass(){
    return _mass;
  }
  public double[] getVelocity(){
    return _velocity;
  }
  public double[] getPosition() {
    return _pos;
  }
}
