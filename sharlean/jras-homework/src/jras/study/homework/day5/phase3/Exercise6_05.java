package jras.study.homework.day5.phase3;

public class Exercise6_05 {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 1, 1, 100, 60, 76);
        
        System.out.println(s.info());
    }
}

class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    
    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name   = name;
        this.ban    = ban;
        this.no     = no;
        this.kor    = kor;
        this.eng    = eng;
        this.math   = math;
    }
    
    public int getTotal() {
        return kor + eng + math;
    }
    
    public float getAverage() {
        return Math.round(getTotal() * 100)/3/100.0f;
    }
    
    public String info() {
        final String separator = ",";
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(name          + separator);
        sb.append(ban           + separator);
        sb.append(no            + separator);
        sb.append(kor           + separator);
        sb.append(eng           + separator);
        sb.append(math          + separator);
        sb.append(getTotal()    + separator);
        sb.append(getAverage());
        
        return sb.toString(); 
    }
}