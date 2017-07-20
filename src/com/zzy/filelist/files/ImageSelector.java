package com.zzy.filelist.files;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImageSelector implements FileFilter {

    String[] strs = {"jpg"};

    public boolean accept(File pathname) {
        String name = pathname.getName();
        List<String> list = Arrays.asList(strs);

        if (name != null && name.contains("\\.")) {
            String[] split = name.split("\\.");
            return list.contains(split[1]);
        } else {
            return false;
        }
    }

}
