package day7.filebackup;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackupManager {
    private static final String BACKUP_DIR = "backup/";
    private static final String METADATA_FILE = "backup_metadata.dat";

    public void backupDirectory(String sourceDirPath) {
        File sourceDir = new File(sourceDirPath);
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("⚠ Invalid directory!");
            return;
        }

        File backupDir = new File(BACKUP_DIR);
        if (!backupDir.exists()) backupDir.mkdir();

        List<Metadata> metadataList = new ArrayList<>();
        
        File[] files = sourceDir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("⚠ No files to backup!");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                File destFile = new File(BACKUP_DIR + file.getName());
                copyFile(file, destFile);
                metadataList.add(new Metadata(file.getName(), file.length(), file.lastModified()));
            }
        }

        saveMetadata(metadataList);
        System.out.println("✅ Backup completed!");
    }

    private void copyFile(File src, File dest) {
        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("⚠ Error copying file: " + src.getName());
        }
    }

    private void saveMetadata(List<Metadata> metadataList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(METADATA_FILE))) {
            oos.writeObject(metadataList);
        } catch (IOException e) {
            System.out.println("⚠ Error saving metadata!");
        }
    }

    @SuppressWarnings("unchecked")
    public void recoverFiles() {
        List<Metadata> metadataList;
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(METADATA_FILE))) {
            metadataList = (List<Metadata>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ No metadata found or error reading metadata!");
            return;
        }

        for (Metadata metadata : metadataList) {
            File srcFile = new File(BACKUP_DIR + metadata.getFileName());
            File destFile = new File(metadata.getFileName());

            if (srcFile.exists()) {
                copyFile(srcFile, destFile);
                System.out.println("✅ Restored: " + metadata.getFileName());
            } else {
                System.out.println("⚠ Missing file in backup: " + metadata.getFileName());
            }
        }
    }

    public void showBackupMetadata() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(METADATA_FILE))) {
            List<Metadata> metadataList = (List<Metadata>) ois.readObject();
            System.out.println("\n📄 Backup Metadata:");
            metadataList.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ No metadata available.");
        }
    }
}
