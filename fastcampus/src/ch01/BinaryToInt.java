package ch01;

public class BinaryToInt {
    public static void main(String[] args) {
        byte bNum = 10;
        int iNum = bNum;
        int iNum1 = 20;
        float fNum = iNum1;
        byte bbNum = (byte)iNum;
        double dNum = 3.14;
        int iNum2 = (int)dNum;
        System.out.println(iNum);
        System.out.println(fNum);
        System.out.println(dNum);
        System.out.println(iNum2);
        System.out.println(bbNum);
    }
}
