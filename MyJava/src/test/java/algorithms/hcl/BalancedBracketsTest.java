package algorithms.hcl;


import org.junit.Assert;
import org.junit.Test;

public class BalancedBracketsTest {

    @Test
    public void testValidInput_1(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("{}");
        Assert.assertTrue(balanced);

    }

    @Test
    public void testValidInput_2(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("{()}");
        Assert.assertTrue(balanced);

    }

    @Test
    public void testValidInput_3(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("{([])}");
        Assert.assertTrue(balanced);

    }

    @Test
    public void testValidInput_4(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("()[]{}(([])){[()][]}");
        Assert.assertTrue(balanced);

    }



    @Test
    public void testInValidInput_1(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("())[]{}");
        Assert.assertFalse(balanced);

    }

    @Test
    public void testInValidInput_2(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("[(])");
        Assert.assertFalse(balanced);

    }

    @Test
    public void testEmptyInput(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("");
        Assert.assertTrue(balanced);

    }

    @Test
    public void testNullInput(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced(null);
        Assert.assertTrue(balanced);

    }


    /**
     * Non bracket input like 123 or  !@# etc
     */
    @Test
    public void testNumberedInput(){
        BalancedBrackets balancedBrackets= new BalancedBrackets();
        boolean balanced = balancedBrackets.isBalanced("123");
        Assert.assertFalse(balanced);

    }



}