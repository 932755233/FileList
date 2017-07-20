package com.zzy.filelist.files;

import java.io.File;
import java.io.FileFilter;

public class FileSelector implements FileFilter {


    public boolean accept(File pathname) {
        String name = pathname.getName();

        return !name.startsWith(".");
    }
}
