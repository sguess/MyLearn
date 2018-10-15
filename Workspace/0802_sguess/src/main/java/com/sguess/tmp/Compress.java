package com.sguess.tmp;

import java.io.File;
import java.io.IOException;

public abstract class Compress {
    protected abstract void doCompress(File srcFile, File destFile) throws IOException;

    protected abstract void doDecompress(File srcFile, File destDir) throws IOException;
}
