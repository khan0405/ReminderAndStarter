package example1007hyunkyung;

public class exercise3 {
	public static void main(String args[]){
		int x=0;
		int y=0;
		for(x=0;x<=10;x++){ // 0<=x<=10
			for(y=0;y<=10;y++){ // 0<=y<=10	
				if(2*x+4*y==10){ // 방정식 2x+4y=10 
					System.out.println("x="+x+", y="+y);
				}
			}
		}	
	}
}
