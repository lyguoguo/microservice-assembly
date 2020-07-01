package com.gly.oom;

public class R {
    public void test1(Zip z){
        while(true){
            Byte[] b = new Byte[100000];
            z.getA().add(b);
        }
    }
}