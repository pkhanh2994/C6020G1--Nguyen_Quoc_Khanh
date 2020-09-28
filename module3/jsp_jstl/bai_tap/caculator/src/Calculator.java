public class Calculator {
    public static double calculator(double nums1,double nums2,String operator){
        switch (operator){
            case "+":
                return nums1+nums2;

            case "-":
                return  nums1-nums2;

            case "*":
                return nums1*nums2;
            case "/":
                    if(nums2!=0)
                    return nums1/nums2;
                    else
                        throw new RuntimeException("can't devide by zero");
            default:
                throw new RuntimeException("invalid values");

        }
    }
}
