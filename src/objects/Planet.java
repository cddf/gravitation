package objects;
// @author Dreist

public class Planet {
  double _mass;
  double[] _pos, _posNew, _speed, _speedNew;

  /**
   * Constructor von Planet
   * 
   * @param mass Mass   
   * @param position Position [x,y,z]
   * @param speed Speed [Vx,Vy,Vz]
   */
  public Planet(double mass, double[] position, double[] speed){
    assert(mass != 0);
    assert(position.length == 3);
    assert(speed.length == 3);

    _mass = mass;
    _pos = position;
    _speed = speed;
  }

  /**
   * Moves the planet in dependence of Force and time difference
   *
   * @param F Force in x,y,z direction
   * @param dt time difference to the last update
   */
  public void movePlanet(double[] F, double dt) {
    assert(F.length == 3);
    assert(_speedNew == null);
    assert(_posNew == null);

    for (int i = 0; i < 3; i++) {
      _speedNew[i] += F[i] / _mass;
      _posNew[i]   += _speedNew[i] * dt;
    }
  }

  public void updateChanges()
  {
    _speed = _speedNew;
    _pos = _posNew;

    _speedNew = null;
    _posNew = null;
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
