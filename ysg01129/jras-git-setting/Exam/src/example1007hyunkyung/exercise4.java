package example1007hyunkyung;

public class exercise4 {
	public static void main(String args[]){
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];

		//배열 ballArr의 임의의 요소 2개를 골라서 위치를바꾼다. 20번 반복
		for(int x=0;x<20;x++){
			int i = (int)(Math.random()*ballArr.length);
			int j = (int)(Math.random()*ballArr.length);
			int tmp=0;

			tmp = ballArr[i];          // 위치 바꿈.
			ballArr[i]=ballArr[j];
			ballArr[j]=tmp;

		}//배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		System.arraycopy(ballArr,0,ball3,0,ball3.length);
		//System.arraycopy(복사할 배열, 복사 시작점, 복사될 배열, 붙이기 시작점, 복사할 개수)

		for(int i=0; i<ball3.length;i++){
			System.out.print(ball3[i]);
		}
	}// end of main
}// end of class
