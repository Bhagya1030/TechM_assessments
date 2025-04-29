package day7.filebackup;

import java.io.Serializable;
import java.util.Date;

public class Metadata implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String fileName;
    private long fileSize;
    private Date lastModified;

    public Metadata(String fileName, long fileSize, long lastModified) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.lastModified = new Date(lastModified);
    }

    public String getFileName() { return fileName; }
    public long getFileSize() { return fileSize; }
    public Date getLastModified() { return lastModified; }

    @Override
    public String toString() {
        return "File: " + fileName + ", Size: " + fileSize + " bytes, Last Modified: " + lastModified;
    }
}
