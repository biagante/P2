
public class Door {

  // Declare necessary fields here...
	private double w;
	private double h;
	private int r1;
	private int r2;
	
  /** Constructs a new Door between two rooms.
   * @param r1 Identifier of a room.
   * @param r2 Identifiier of another room.  It cannot be the same as r1!
   * @param w  Door width (in meters).  Must be positive.
   * @param h  Door height (in meters).  Must be positive.
   */
  public Door(int r1, int r2, double w, double h) {
	  assert w > 0;
	  assert h > 0;
	  assert r1 != r2;
	  
	  this.w = w;
	  this.h = h;
	  this.r1 = r1;
	  this.r2 = r2;	
  }
  
  public double area(){
	  return w*h;
  }
  
  public int room1(){
	  return r1;
  }
  
  public int room2(){
	  return r2;
  }

}

