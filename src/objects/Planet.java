package objects;
// @author Dreist

public class Planet {
  double _mass, _t;
  double[] _pos, _speed;

  /**
   * Constructor von Planet
   * 
   * @param mass Mass   
   * @param position Position [x,y,z]
   * @param speed Speed [Vx,Vy,Vz]
   */
  public Planet(double mass, double[] position, double[] speed, double t){
    assert(mass != 0);
    assert(position.length == 3);
    assert(speed.length == 3);

    _mass = mass;
    _pos = position;
    _speed = speed;
    _t = t;
  }

  /**
   * Moves the planet in dependence of Force and time difference
   *
   * @param F Force in x,y,z direction
   * @param t time
   */
  public void movePlanet(double[] F, double t) {
    assert(F.length == 3);

    for (int i = 0; i < 3; i++) {
      _speed[i] += F[i] / _mass;
      _pos[i]   += _speed[i] * (t-_t);
    }
    _t = t;
  }


  /*
   * #########################  Get/Set Methods  #########################
   */

  public double getMass(){
    return _mass;
  }
  public double[] getSpeed(){
    return _speed;
  }
  public double[] getPosition() {
    return _pos;
  }
}
