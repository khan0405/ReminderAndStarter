package jras.study.homework;

public class Exercise4_8 {
	public static void main(String[] args) {
		new Exercise4_8().doHomework();
	}
	
	public void doHomework() {
		XyZeroBaseCoordinateIterator iterator = new XyZeroBaseCoordinateIterator(1, 10);
		while(iterator.hasNext()) {
			int[] nextXy = iterator.nextXy();
			System.out.printf("x = %d, y = %d\n", nextXy[0], nextXy[1]);
		}
	}
	
	class XyZeroBaseCoordinateIterator {
		private int maxX = 0;
		private int maxY = 0;
		private int x;
		private int y;
		
		public XyZeroBaseCoordinateIterator(int maxX, int maxY) {
			this.maxX = maxX;
			this.maxY = maxY;
			this.x = 0;
			this.y = 0;
		}
		
		public boolean hasNext() {
			if (x <= maxX && y <= maxY) {
				return true;
			}
			return false;
		}
		
		public int[] nextXy() {
			
			int[] xy = new int[]{x, y};
			
			if (y <= maxY) {
				y++;
		 	}
			
			if (x <= maxX && y == maxY) {
				x++;
				y = 0;
			}
			
			if (x == maxX) {
				x = 0;
			}
			
			return xy;
		}		
	}
}
