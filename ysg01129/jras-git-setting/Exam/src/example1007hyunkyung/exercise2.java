package example1007hyunkyung;


public class exercise2 {
	public static void main(String args[]){
		if(args.length!=1){
			System.out.println("USAGE: java exercise _ 3120");
			System.exit(0);
		}
		//문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		int money = Integer.parseInt(args[0]);

		System.out.println("money="+money);

		int[] coinUnit = {500, 100, 50, 10};// 동전의 단위
		int[] coin= {5, 5, 5, 5 }; // 단위별 동전의 개수

		for(int i=0; i<coinUnit.length;i++){ // 동전의 단위 갯수만큼 루프

			int coinNum=0; // 코인 갯수
			coinNum= money/coinUnit[i]; //코인 갯수 = 금액 / 동전의 단위

			/**
			 * 1. 금액(money)의 동전단위로 나눠서 필요한 동전의 개수(coinNum)을 구한다.
			 * 2. 배열 coin애서 coinNum만큼 동전을 뺀다
			 * (만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
			 * 3. 금액에서 동전의 개수(coinNum)와 동전 단위를 곱한 값을 뺸다.
			 */

			if(coinNum<=5){ 
				coin[i]=coin[i]-coinNum; // 배열 coin에서 coinNum만큼 동전을 뺀다.
			}else{		//coinNum이 5초과일 경우 배열 coin에 있는 수만큼만 제외.
				coin[i]=0; 
				coinNum=5;
			}
			money=money-coinNum*coinUnit[i]; //금액에서 동전의 개수(coinNum)와 동전 단위를 곱한 값을 뺸다.
			System.out.println(coinUnit[i]+"원:"+coinNum);
		}
		if(money>0){
			System.out.println("거스름돈이  부족합니다.");
			System.exit(0);
		}

		System.out.println("=남은 동전의 개수=");
		for(int i=0;i<coinUnit.length;i++){
			System.out.println(coinUnit[i]+"원:"+coin[i]);
		}

	}		

}
