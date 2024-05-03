package com.lowlevel.design.file;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface FileDetector{
    Optional<String> detectAndFindType(File file) throws IOException;

    static byte[] readInitialByte(File file) throws IOException {
        byte[] result = new byte[8];
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int numBytesRead = bufferedInputStream.read(result);
        if(numBytesRead < 2 )
            return  null;
        return result;
    }
}

class XMLFileDetector implements FileDetector{

    @Override
    public Optional<String> detectAndFindType(File file) throws IOException {
        byte[] bytes = FileDetector.readInitialByte(file);
        //add logic to check
        return Optional.empty();
    }
}

class TextFileDetector implements FileDetector{

    @Override
    public Optional<String> detectAndFindType(File file) throws IOException {
        byte[] bytes = FileDetector.readInitialByte(file);
        //add logic to check
        return Optional.empty();
    }
}

class FileDetectorDBFactory{
    static List<FileDetector> getAllDetectors(){
        List<FileDetector> detectors= new ArrayList<>();
        detectors.add(new TextFileDetector());
        detectors.add(new XMLFileDetector());
        return  detectors;
    }
}



public class FileCommand {

    static final String UNKNOWN = "Unknown";

    private void printError(String message){
        System.err.println(message);
    }


    List<String> file(String directoryName) {
        File directory = new File(directoryName);

        if(!directory.isDirectory())
        {
            printError("Must be a directory");
        }

        String[] allFiles = directory.list();
        List<FileDetector> detectors = FileDetectorDBFactory.getAllDetectors();

        List<String> result = new ArrayList<>();
        for(String singleFile : allFiles){
            File file = new File(directory,singleFile);
            if(file.isFile()){
                String fileType = UNKNOWN;
                for(FileDetector detector : detectors){
                    try {
                        Optional<String> type = detector.detectAndFindType(file);
                        if(!type.isEmpty()){
                            fileType = type.get();
                            break;
                        }
                    } catch (IOException e) {
                       printError("File not Found ");
                       System.exit(1);
                    }
                }

                result.add(fileType);
            }
        }


        return result;
    }


    List<String> fileList(String fileList ) {

        return null;
    }


    List<String> fileList(String fileList , char separator) {

        return null;
    }
}
