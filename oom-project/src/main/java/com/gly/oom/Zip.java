package com.gly.oom;

import java.util.List;

public class Zip {
    private List<Byte[]> a = null;

    public List<Byte[]> getA() {
        return a;
    }

    public void setA(List<Byte[]> a) {
        this.a = a;
    }
    public void test(List<Byte[]> list){
        Zip n = new Zip();
        n.setA(list);
        R r = new R();
        r.test1(n);
    }
}