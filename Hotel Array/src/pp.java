
public class pp {
static Room[] pp = new Room[5];
 
 public  static void add( Room obj ){
	 for(int i = 0;i<pp.length;i++){
		if(!pp[i].equals(null)){
			pp[i] = obj;
		}
	 }
 }
 
}
