package com.gly.oom;

import java.util.ArrayList;
import java.util.List;

public class OOM {
    private static List<Byte[]> list = new ArrayList<Byte[]>();
    public static void oom() {
        Zip zip = new Zip();
        zip.test(list);
    }
}