package jras.study.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercise4_8 {
	public static void main(String[] args) {
		new Exercise4_8().doHomework();
	}
	
	private List<NextXy> answerList;
	
	public Exercise4_8() {
		answerList = new ArrayList<>();
	}
	
	public void doHomework() {
		XyZeroBaseCoordinateIterator iterator = new XyZeroBaseCoordinateIterator(11, 11);
		while(iterator.hasNext()) {
			calculate(iterator.nextXy(), (NextXy xy) -> answerList.add(xy));
		}
		
		for(NextXy nextXy : answerList) {
			System.out.printf("x = %d, y = %d\n", nextXy.x(), nextXy.y());
		}
	}
	
	protected void calculate(NextXy nextXy, Consumer<NextXy> c) {
		if (((2*nextXy.x()) + (4*nextXy.y()) - 10) == 0) {
			c.accept(nextXy);
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
		
		public NextXy nextXy() {
			
			NextXy xy = new NextXy(x, y);
			
			if (y <= maxY) {
				y++;
		 	}
			
			if (x <= maxX && y == maxY) {
				y = 0;
				x++;
			}
			
			return xy;
		}
	}
	
	class NextXy {
		private int x;
		private int y;
		
		public NextXy(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int x() {
			return x;
		}
		
		public int y() {
			return y;
		}
	}
}
