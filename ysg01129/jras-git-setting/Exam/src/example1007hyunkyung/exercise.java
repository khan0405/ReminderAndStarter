package example1007hyunkyung;

public class exercise {
	public static void main(String args[]){
		// 큰 금액의 동전을 우전적으로 거슬러 줘야함.
		int[] coinUnit = {500, 100, 50, 10};

		int money = 3180;
		System.out.println("money="+money);
		for(int i=0;i<coinUnit.length;i++){
			int coinNum=0;
			coinNum= money/coinUnit[i];
			System.out.println(coinUnit[i]+"원:"+coinNum);
			money = money - coinNum*coinUnit[i];
		}
	}

}
