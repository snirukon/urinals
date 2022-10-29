package org.example;

import java.io.*;
import java.util.Scanner;

/**
 * @author sai viswas
 */
public class Urinals {
    public String[] openFile() throws IOException {
        File dataFile = new File("./src/main/resources/urinals.dat");
        Scanner scanner = new Scanner(dataFile);
        File newFile = new File("./src/main/resources/urinals.dat");
        int count = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(newFile))) {
            while (lnr.readLine() != null) {
            }
            count = lnr.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;
        String[] files = new String[count];
        while (scanner.hasNextLine()) {
            files[i] = scanner.nextLine();
            i++;
        }
        return files;
    }

    public void recieveString() throws IOException {
        String[] strArray = openFile();
        for (int i = 0; i < strArray.length; i++) {
            int result= getUrinalStatus(strArray[i]);
            System.out.println(result);
        }
    }

    public int getUrinalStatus(String status) {
        int count = 0;
        if (isValid(status)) {
            int len = status.length();
            for (int i = 0; i < len - 1; i++) {
                if (status.charAt(i) == '0') {
                    if (i == 0 && status.charAt(i + 1) == '0') {
                        count++;
                        status = status.substring(0, i) + '1'
                                + status.substring(i + 1);

                    } else if (i > 0) {
                        if (status.charAt(i - 1) == '0' && status.charAt(i + 1) == '0') {
                            count++;
                            status = status.substring(0, i) + '1'
                                    + status.substring(i + 1);
                        }
                    }
                }
            }
            if (status.charAt(len - 1) == '0' && status.charAt(len - 2) == '0') {
                count++;
                status = status.substring(0, len - 1) + '1'
                        + status.substring(len);
            }
        } else {
            count = -1;
        }
        return count;
    }

    public boolean isValid(String string) {

        if (string != null) {
            int length = string.length();
            for (int i = 0; i < length - 1; i++) {
                if (i == 0) {
                    if (string.charAt(0) == '1' && string.charAt(1) == '1') {
                        return false;
                    }
                } else {
                    if (string.charAt(i) == '1') {
                        if (string.charAt(i - 1) == '1' || string.charAt(i + 1) == '1') {
                            return false;
                        }
                    }
                }
            }
            return string.charAt(length - 1) != '1' || string.charAt(length - 2) != '1';
        }
        return true;
    }

    public static void main(String[] args) throws NullPointerException, IOException {
        Urinals urinal = new Urinals();
        urinal.recieveString();
    }
}