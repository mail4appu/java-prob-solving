package com.checkpoint.springredis.util;

import java.util.Arrays;

public class TestApp {
    public static void main(String[] args) {
        String s="    -42";
        char[] chs=s.trim().toCharArray();
        if(chs[0]=='-'){
            System.out.println("yes negative");
        }
        System.out.println(s.length());
        int []input1={6, 8, 2, 1, 13, 10};

        System.out.println("maxFromRight:  " + Arrays.toString(maxFromRight(input1)));
        int []input2={6, 8, 2, 1, 13, 10};
        System.out.println("maxFromRight Include Current:  " + Arrays.toString(maxFromRightIncludeCurrent(input2)));
        int []input3={6, 8, 2, 1, 13, 10};
        System.out.println("maxFromLeft:  " + Arrays.toString(maxFromLeft(input3)));
        int []input4={6, 8, 2, 1, 13, 10};
        System.out.println("maxFromLeft Include Current:  " + Arrays.toString(maxFromLeftIncludeCurrent(input4)));

        System.out.println((~(123 - 1)));




    }

    private static int[] maxFromRight(int[] a){
        int size=a.length;
        int maxFromRight=a[size-1];
        a[size-1]=-1;
        for(int j=size-2;j>=0;j--){
            int current=a[j];
            a[j]=maxFromRight;
            if(current>maxFromRight){
                maxFromRight=current;
            }
        }
        return a;
    }

    public static int[]  maxFromRightIncludeCurrent(int[] a){
        int size=a.length;
        int maxFromRight=a[size-1];
        for(int i=size-2;i>-1;i--){
            if(a[i]>maxFromRight){
                maxFromRight=a[i];
            }
            a[i]=maxFromRight;
        }
        return a;
    }


    private static int[] maxFromLeft(int[] c) {
        int length=c.length;
        int maxFrmLeft=c[0];
        c[0]=-1;
        for(int i=1;i<length;i++){
            int current=c[i];
            c[i]=maxFrmLeft;
            if(current>maxFrmLeft){
                maxFrmLeft=current;
            }

        }
        return c;

    }


    private static int[] maxFromLeftIncludeCurrent(int[] c){
        int length=c.length;
        int maxFromLeft=c[0];
        for(int i=1;i<length;i++){
            if(c[i]>maxFromLeft){
                maxFromLeft=c[i];

            }
            c[i]=maxFromLeft;

        }
        return c;

    }




}
