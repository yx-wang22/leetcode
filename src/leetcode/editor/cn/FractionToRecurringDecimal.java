//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
//
// Related Topics 哈希表 数学 字符串 👍 432 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：分数到小数
public class FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        // TO TEST
        System.out.println();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String flag;
        Long myNumerator = (long) numerator;
        Long myDenominator = (long) denominator;
        //判断符号
        if(myNumerator<0 & myDenominator<0 || myNumerator>0 & myDenominator>0 || myNumerator == 0){
            flag = "";
        }
        else {
            flag = "-";
        }

        myNumerator = Math.abs(myNumerator);
        myDenominator = Math.abs(myDenominator);

        // 取余直到余数为零 or 余数出现重复
        Long remainder = (long) myNumerator % myDenominator;
        String intPart = Long.toString(myNumerator / myDenominator);
        String decimalPart = "";

        List<Long> remainderList = new ArrayList<>();
        remainderList.add(remainder);

        while(remainder != 0) {
            remainder = remainder * 10;
            myDenominator = myDenominator;
            String s = Long.toString(remainder / myDenominator);
            decimalPart = decimalPart + s;
            remainder = remainder % myDenominator;

            if(remainderList.contains(remainder)){
                // 找出循环部分
                Integer firstPlace = remainderList.indexOf(remainder);
                Integer lastPlace = remainderList.size();

                String nonRecurPart = decimalPart.substring(0, firstPlace);
                String recurPart = "(" + decimalPart.substring(firstPlace, lastPlace) + ")";

                decimalPart = nonRecurPart + recurPart;

                break;
            }
            remainderList.add(remainder);
        }
        if(decimalPart != "") {
            decimalPart = "." + decimalPart;
        }

        return flag + intPart + decimalPart;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}