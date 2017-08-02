package com.yyl.jvm;

/**
 * Created by Administrator on 2017/7/28.
 */
public class E14ReorderArray {
    public void order(int[] arr){
        if(arr == null)
            return;
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            if(isEven(arr[i]) && !isEven(arr[j])){
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
            }
            else if(!isEven(arr[i]) && isEven(arr[j])){
                i++;
            }
            else if(isEven(arr[i]) && isEven(arr[j])){
                j--;
            }else{
                i++;
                j--;
            }
        }
    }
    public boolean isEven(int n){
        return (n & 1) == 0;
    }
    public static void main(String[] args){
        E14ReorderArray test = new E14ReorderArray();
        int[] arr= {1,2,3,4,5,6,12,7,8,9,10};
        test.order(arr);
        for(int i = 0;i<arr.length ;i++){
            System.out.print(arr[i]+",");
        }
    }

}
