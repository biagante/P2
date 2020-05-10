
import static java.lang.System.*;

public class House {

  public House(String houseType,int maxSize,int extensionSize) {
    this.houseType = houseType;
    this.extensionSize = extensionSize;
    rooms = new Room[maxSize];
    size = 0;
    doors = new Door[maxSize];
    numDoors = 0;
  }

  public House(String houseType) {
    this(houseType,8,4);
  } 

  public int size() {
    return size;
  }

  public int maxSize() {
    return rooms.length;
  }

  public Room room(int i) {
    return rooms[i];
  }

  public int addRoom(Room r) {
    if (size == rooms.length) extendHouse();
    rooms[size] = r;
    size++;
    return size;
  }

  private void extendHouse() {
    Room [] newRooms = new Room[rooms.length+extensionSize];
    arraycopy(rooms, 0, newRooms, 0, rooms.length);
    rooms = newRooms;
  } 

  private String houseType;
  private int extensionSize;
  private Room [] rooms;
  private int size;
  private Door [] doors;
  private int numDoors;

  public void addDoor(Door d) { 
	//verifica se o vetor está cheio
	if (numDoors == doors.length)
	{
		extendRooms();
	}
    doors[numDoors] = d;
    numDoors++;
  }

  public int numDoors() {
    return numDoors;
  }

  public int maxNumDoors() {
    return doors.length;
  }
  
  //extende a capacidade do vetor 
  private void extendRooms(){
	  Door[] newDoors = new Door[doors.length + extensionSize];
	  arraycopy(doors, 0, newDoors, 0, doors.length);
	  doors = newDoors;
  }  
  //procura o quarto mais proximo
  public int roomClosestToRoomType(String roomType){
	  double minDist = 999;
	  double dist = 0;
	  int closestIndex = 0;
	  for (int i = 0; i < size; i++)
	  {
		  if (rooms[i].roomType().equals(roomType))
		  {
			  for (int k = 0; k < size; k++)
			  {
				  if (!roomType.equals(rooms[k].roomType()))
				  {
					  dist = rooms[i].geomCenter().distTo(rooms[k].geomCenter());
					  if (dist < minDist)
					  {
						  closestIndex = k;
						  minDist = dist;
					  }
				  }
			  }
			  
		  }
	  }
	  return closestIndex;	  
  }
  
  //
  public int maxDoorsInAnyRoom(){
	  int[] numberDoors = new int[size];
	  for (int i = 0; i < numDoors; i++)
	  {
		  for (int j = 0; j < size; j++)
		  {
			  if (doors[i].room1() == j)
			  {
				  numberDoors[j]++;
			  }
			  if (doors[i].room2() == j)
			  {
				  numberDoors[j]++;
			  }
		  }
	  }
	  int maxDoors = 0;
	  for (int i : numberDoors)
	  {
		  if (i > maxDoors)
		  {
			maxDoors = i;
		  }
	  }
	  return maxDoors;
  }
  
  

}

