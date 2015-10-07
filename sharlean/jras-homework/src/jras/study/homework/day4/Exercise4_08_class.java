package jras.study.homework.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * 방정식 2x+4y=10의 모든 해를 구하시오. 
 * 단, x와 y는 정수이고 각각의 범위는 0<=x<=10, 0<=y<=10 이다.
 * 
 * [실행 결과]
 * x=1, y=2
 * x=3, y=1
 * x=5, y=0
 * 
 * @author Yunseong
 */
public class Exercise4_08_class {
    
	public static void main(String[] args) throws Exception {
	    //미지수 x, y 생성
		Unknown x = new Unknown("x", 2, new Range(0, 10));
		Unknown y = new Unknown("y", 4, new Range(0, 10));
		
		//미지수 x와 y 연산에 사용할 연산자 설정
		Operator[] op = { Operator.PLUS };
		
		//방정식 클래스 생성
		Equation eq = new Equation(10, op, x, y);
		
		//모든 답을 찾도록 함
		eq.answersFindAll();
	}

}

/**
 * 방정식 클래스 Equation
 * 
 * 방정식 클래스는 우변에 해당하는 결과값(result), 연산자 묶음(Operatorp[])과 미지수 묶음(Unknown[])을 가진다.
 * 
 * 방정식의 결과값은 하나로 고정될 수 있지만,
 * 방정식의 좌변에 해당하는 영역에 표현될 수 있는 미지수의 갯수는 제한이 없다.
 * 따라서 미지수는 가변 인자 형태로 받아 필요한만큼 받을 수 있도록 한다.
 *
 * 연산자는 미지수간의 연산을 표현하므로 미지수 전체 수량보다 1개 적어야만 한다.
 * 따라서 조건을 만족하지 않으면 예외 처리를 하여 클래스 생성을 막는다.
 * 
 * @author Yunseong
 *
 */
class Equation {
    private int result;
	private Operator[] operators;
    private Unknown[] unknowns;

    /**
     * Equation 생성자
     * 
     * 클래스 생성 조건에 부합하는 경우는 생성이 가능하고,
     * 그렇지 않으면 예외 처리로 클래스 생성을 막는다.
     * 
     * @param result
     * @param operators
     * @param unknowns
     * @throws Exception
     */
    public Equation(int result, Operator[] operators, Unknown... unknowns) throws Exception {
        if(unknowns.length-1 == operators.length) {
            this.result = result;
            this.operators = operators;
            this.unknowns = unknowns;
        } else {
            throw new Exception("연산자 수는 미지수보다 1개 적어야만 합니다");
        }
	}
    
    /**
     * 정답에 부합하는지를 참/거짓 형태로 리턴하는 메서드
     * 
     * xyz 인자로 넘어온 데이터를 미지수별 가중치를 더한 값으로 반환한 후,
     * 각 미지수를 지정된 연산자로 연산하여 합산한다.
     * 
     * 합산한 값이 result값과 일치하면 정답이므로 참을 리턴하고, 아닌 경우 거짓을 리턴한다.
     * 
     * @param xyz
     * @return
     */
    private boolean isAnswer(int[] xyz) {
        int[] values = makeUnknownValues(xyz);
        
        int sum = IntegratedCalculation(values);
        
        return sum == result;
    }

    /**
     * 가중치가 더해진 값을 연산자와 함께
     * 각자 계산하도록 한 후,
     * 계산한 값을 통합해서 넘기도록 하는 메서드.
     * 
     * 그러나 테스트 결과
     * 생각한 것과 다르게 미지수 3개 이상의 연산에 대해 고려되어있지 않으므로,
     * 새로운 알고리즘을 고민해봐야할 듯하다.
     * 
     * @param values
     * @return
     */
    private int IntegratedCalculation(int[] values) {
        int sum = 0;
        
        for(int j = 0; j < operators.length; j++) {
            sum += calculator(values[j], values[j+1], operators[j]); 
        }
        
        return sum;
    }

    /**
     * 미지수가 가진 본연의 값을 배열 형태로 리턴해주는 메서드.
     * 
     * 미지수 자신의 범위값이 넘어온 배열 xyz에 대해서 미지수의 가중치를 곱해주도록 한다.
     * 그리고 그 값들을 배열 형태로 리턴한다. 
     * 
     * @param xyz
     * @return
     */
    private int[] makeUnknownValues(int[] xyz) {
        int[] values = new int[unknowns.length];
        
        for(int i = 0; i < xyz.length; i++) {
            values[i] = unknowns[i].getWeight() * xyz[i];
        }
        
        return values;
    }

    /**
     * 주어진 연산자 타입에 따라서 연산을 수행한 후, 수행한 값을 리턴한다.
     * 
     * @param firstNum
     * @param secondNum
     * @param operator
     * @return
     */
    private int calculator(int firstNum, int secondNum, Operator operator) {
        
             if(operator.equals(Operator.PLUS))     { return firstNum + secondNum; } 
        else if(operator.equals(Operator.MINUS))    { return firstNum - secondNum; } 
        else if(operator.equals(Operator.MULTIPLE)) { return firstNum * secondNum; } 
        else if(operator.equals(Operator.DIVIDE))   { return firstNum / secondNum; }
        
        return 0;
    }

    /**
     * 외부에서 호출 가능한 메서드로, 
     * 현재 방정식에 맞는 해답을 찾는다.
     */
    public void answersFindAll() {
        recursiveUnknownsForAnswers(0, unknowns.length, new int[unknowns.length]);
    }

    /**
     * 재귀 호출을 이용해 미지수 수만큼 해당 미지수가 가지는 최소값부터 최대값을 순회하여 xyz 배열에 포함시킨다.
     * 미지수 숫자만큼 배열의 크기가 정해지며, 재귀 호출의 끝에 다다르면 이 배열에 들어간 값으로 방정식을 평가하게 된다.
     * 
     * @param currentNum
     * @param max
     * @param xyz
     */
    private void recursiveUnknownsForAnswers(int currentNum, int max, int[] xyz) {
        if(currentNum < max) {
            for(int i = unknowns[currentNum].getRange().getMin(); i <= unknowns[currentNum].getRange().getMax(); i++) {
                if(xyz.length == 0) xyz[0] = i; 
                else xyz[currentNum] = i;
                
                recursiveUnknownsForAnswers(currentNum + 1, max, xyz);
            }
        } else if(currentNum == max) {
            printAnswer(xyz);
        }
        
    }

    /**
     * 배열에 들어간 미지수의 값을 받아 그 값을 출력할 문자열을 만든다.
     * 이후 이 값들이 방정식의 정답이라고 판단되면, 이를 콘솔 화면에 출력한다.
     * 
     * @param xyz
     */
    private void printAnswer(int[] xyz) {
        StringBuffer sb = new StringBuffer();
        String seperator = ", ";
        
        for(int i = 0; i < xyz.length; i++) {
            if(i == xyz.length - 1) seperator = "";
            
            //System.out.println("xyz[" + i + "] : " + arrayInfo(xyz));
            if(unknowns[i].getName().length() == 0) {
                sb.append(i + "=" + xyz[i] + seperator);
            } else {
                sb.append(unknowns[i].getName() + "=" + xyz[i] + seperator);
            }
        }
        
        if(isAnswer(xyz)) System.out.println(sb.toString());
    }

    /**
     * 재귀가 정상적으로 돌았는지 테스트를 위한 출력 메서드
     * 
     * @param xyz
     * @return
     */
    private String arrayInfo(int[] xyz) {
        StringBuffer sb = new StringBuffer();
        
        sb.append("xyz[size : " + xyz.length + "] ");
        
        for(int i : xyz) {
            sb.append(i +",");
        }
        
        String result = sb.toString();
        
        return result.substring(0, result.length()-1);
    }

}

/**
 * 연산자 열거형 Operator
 * 
 * 각 미지수 간에 사용될 연산자를 타입으로 지정하여, 미지수들간의 연산을 자유롭게 표현할 수 있도록 한다.
 * 
 * @author Yunseong
 */
enum Operator {
    PLUS, MINUS, MULTIPLE, DIVIDE
}

/**
 * 미지수 클래스 Unknown
 * 
 * 방정식에 표현하는 미지수 x, y, z 등을 표현하기 위해 사용하는 클래스다.
 * Unknown 클래스는 가중치(weight), 계산에 사용될 범위(range)를 가지고, 옵션으로 이름을 부여할 수 있다.
 * 
 * @author Yunseong
 */
class Unknown {
	private int weight;
    private Range range;
    private String name = "";

   
    public Unknown(int weight, Range range) {
        this.weight = weight;
        this.range = range;
    }
    
    public Unknown(Range range) {
        this(1, range);
    }
    
    public Unknown(String name, int weight, Range range) {
        this(weight, range);
        this.name = name;
    }
    
	public int getWeight() {
        return weight;
    }

    public Range getRange() {
        return range;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.length() > 0 ? 
              "Unknown " + name + ": [weight=" + weight + ", range=" + range + "]" : 
              "Unknown: [weight=" + weight + ", range=" + range + "]";
    }
    
}


/**
 * 범위 클래스 Range
 * 
 * 최소값과 최대값을 가진다.
 * 어떤 식으로 인자를 넣든 최소값, 최대값 정렬이 되도록 한다.
 * 
 * @author Yunseong
 */
class Range {
	private int min;
	private int max;

	public Range(int min, int max) {
		if(min > max) {
			this.min  = max;
			this.max  = min;
		} else {
			this.min  = min;
			this.max  = max;
		}
	}

	public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public List<Integer> getScope() {
        ArrayList<Integer> scope = new ArrayList<Integer>();
        
	    if(max - min == 0) {
	        scope.add(max);
	    } else {
	        for(int i = min; i <= max; i++) {
	            scope.add(i);
	        }
	    }
	    
	    return scope;
	}
	
}