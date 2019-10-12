package leetcode;

/**
 * 整数->罗马数
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内
 */
public class Solution12 {
    public static void main(String[] args) {
        Solution12 s=new Solution12();
        System.out.println(s.intToRoman(558));
    }
    //方法3：最推荐，和第二种方法一个意思，但是会更加简洁。
    public String intToRoman4(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index] + " ");
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }

//    方法2
    public String intToRoman2(int num) {
        StringBuffer s = new StringBuffer();
        while (num != 0) {  //大条件
            if (num >= 1000) {
                s.append("M");
                num -= 1000;
            } else if (num >= 900) {
                s.append("CM");
                num -= 900;
            } else if (num >= 500) {
                s.append("D");
                num -= 500;
            } else if (num >= 400) {
                s.append("CD");
                num -= 400;
            } else if (num >= 100) {
                s.append("C");
                num -= 100;
            } else if (num >= 90) {
                s.append("XC");
                num -= 90;
            } else if (num >= 50) {
                s.append("L");
                num -= 50;
            } else if (num >= 40) {
                s.append("XL");
                num -= 40;
            } else if (num >= 10) {
                s.append("X");
                num -= 10;
            } else if (num >= 9) {
                s.append("IX");
                num -= 9;
            } else if (num >= 5) {
                s.append("V");
                num -= 5;
            } else if (num >= 4) {
                s.append("IV");
                num -= 4;
            } else if (num >= 1) {
                s.append("I");
                num -= 1;
            }
        }
     return s.toString();
    }



    //方法1：分情况考虑，将公共部分抽取出来
    public String intToRoman(int num) {
        StringBuilder res=new StringBuilder();
        if (num>=1000){
            for (int i=0;i<num/1000;i++){
                res.append("M");
            }
            num=num%1000;
        }
        res.append(getRomanHelper(num,100));
        num=num%100;
        res.append(getRomanHelper(num,10));
        num=num%10;
        res.append(getRomanHelper(num,1));
        return res.toString();
    }

    private String getRomanHelper(int num, int stage) {
        StringBuilder res=new StringBuilder();
        String ten="";
        String five="";
        String one="";
        switch (stage){
            case 1: ten="X"; five="V"; one="I";break;
            case 10:ten="C"; five="L"; one="X";break;
            case 100:ten="M";five="D"; one="C";break;
            default:
        }
        if (num>=stage){
            int t=num/stage;  //几百
            if (t==9){  //900
                res.append(one);
                res.append(ten);
            }else if (t==5){ //500
                res.append(five);
            }else if (t==4){ //400
                res.append(one);
                res.append(five);
            }else if (t>5 && t<9){  //600-800: DCCC
                res.append(five);
                while (t-5>0){
                    res.append(one);
                    t--;
                }
            }else {
                while (t>0){
                    res.append(one);
                    t--;
                }
            }
        }
        return res.toString();
    }


    //每种情况都列举
//    public String intToRoman(int num) {
//        StringBuilder res=new StringBuilder();
//        if (num>=1000){
//            for (int i=0;i<num/1000;i++){
//                res.append("M");
//            }
//            num=num%1000;
//        }

//        //100-1000
//        if (num>=100){
//            int t=num/100;  //几百
//            if (t==9){  //900
//                res.append("CM");
//
//            }else if (t==5){ //500
//                res.append("D");
//            }else if (t==4){ //400
//                res.append("CD");
//            }else if (t>5 && t<9){  //600-800: DCCC
//                res.append("D");
//                while (t-5>0){
//                    res.append("C");
//                    t--;
//                }
//            }else {
//                while (t>0){
//                    res.append("C");
//                    t--;
//                }
//            }
//            num=num%100;
//        }
//
//        //10-100
//        if (num>=10){
//            int t=num/10;  //几百
//            if (t==9){  //90
//                res.append("XC");
//
//            }else if (t==5){ //50
//                res.append("L");
//            }else if (t==4){ //40
//                res.append("XL");
//            }else if (t>5 && t<9){  //600-800: DCCC
//                res.append("L");
//                while (t-5>0){
//                    res.append("X");
//                    t--;
//                }
//            }else {
//                while (t>0){
//                    res.append("X");
//                    t--;
//                }
//            }
//            num=num%10;
//        }
//
//
//        //1-10
//        if (num>=1){
//            int t=num;  //几百
//            if (t==9){  //90
//                res.append("IX");
//
//            }else if (t==5){ //50
//                res.append("V");
//            }else if (t==4){ //40
//                res.append("IV");
//            }else if (t>5 && t<9){  //600-800: DCCC
//                res.append("V");
//                while (t-5>0){
//                    res.append("I");
//                    t--;
//                }
//            }else {
//                while (t>0){
//                    res.append("I");
//                    t--;
//                }
//            }
//        }
//        return res.toString();
//    }


}
