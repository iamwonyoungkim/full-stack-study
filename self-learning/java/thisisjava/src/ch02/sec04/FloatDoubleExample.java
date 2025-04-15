package ch02.sec04;

public class FloatDoubleExample {
    public static void main(String[] args) {
        // 정밀도 확인
        float var1 = 0.1234567890123456789f; // 소수점 9번째에서 반올림
        double var2 = 0.1234567890123456789; // 소수점 18번째에서 반올림(약 2배 정도의 유효 자릿수)
        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);

        // 10의 거듭제곱 리터럴
        double var3 = 3e6;
        float var4 = 3e6F; // 실수 리터럴을 float 타입에 대입하려면 f나 F를 붙여야 한다.
        double var5 = 2e-3; // 0.002
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);
        System.out.println("var5: " + var5);
    }
}
