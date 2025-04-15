package ch02.sec03;

public class CharExample {
    public static void main(String[] args) {
        char c1 = 'A';
        char c2 = 65;

        char c3 = '가';
        char c4 = 44032;

        // char c5 = ''; // 컴파일 에러
        char c6 = ' '; // 문자를 대입하지 않고 초기화할 목적이라면 공백 하나를 포함해서 초기화해야 한다.

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c6);
    }
}
