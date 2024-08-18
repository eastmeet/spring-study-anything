package anything.java;

public class ParameterizedTypes {

    // primitives
    byte aByte;
    short aShort;
    int aInt;
    long aLong;
    double aDouble;
    char aChar;
    boolean aBoolean;


    // Wrapper
    Byte aWrapperByte;
    Short aWrapperShort;
    Integer aWrapperInt;
    Long aWrapperLong;
    Double aWrapperDouble;
    Character aWrapperChar;
    Boolean aWrapperBoolean;

    // Autoboxing
    public static void main(String[] args) {

        /**
         * [명시적 박싱] 새로운 Integer 객체 생성 및 heap 메모리 할당 -> Integer boxing : 기본 타입의 값이 객체 내부 값으로 복사(박싱)
         */
        Integer wrapperInt = Integer.valueOf(2);


        /**
         * [명시적 언박싱] 객체의 값이 기본 타입으로 복사
         */
        int x = wrapperInt.intValue(); // 명시적 언박싱
        int y = wrapperInt; // 자동 언박싱

    }


}
