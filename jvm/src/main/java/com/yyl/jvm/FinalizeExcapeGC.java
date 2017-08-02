package com.yyl.jvm;

/**
 * Created by Administrator on 2017/7/26.
 */
public class FinalizeExcapeGC {
    public static FinalizeExcapeGC SAVE_HOOK=null;

    public void isAlive(){
        System.out.println("Yes, I am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method executed !");
        FinalizeExcapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK=new FinalizeExcapeGC();

        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(5000);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No, I am dead :(");
        }

        SAVE_HOOK=null;
        System.gc();
        Thread.sleep(5000);
        if(SAVE_HOOK !=null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("No, I am dead :(");
        }
    }
}
