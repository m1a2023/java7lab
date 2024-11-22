package com.example.task02;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        // чтобы протестировать свое решение, вам нужно:
        // - направить файл input.test в стандартный ввод программы (в настройках запуска программы в IDE или в консоли)
        // - направить стандартный вывод программы в файл output.test
        // - запустить программу
        // - и сравнить получившийся файл output.test с expected.test

        changeToUnix(System.in, System.out);
    }

    public static void changeToUnix(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        if (inputStream == null && outputStream != null)
            throw new IllegalArgumentException();

        byte current, previous = -1;

        while ((current = (byte) inputStream.read()) != -1) {
            if (previous == 13 && current == 10) {
                outputStream.write(current);
                previous = -1;
            } else {
                if (previous != -1) outputStream.write(previous);
                previous = current;
            }
        }

        if (previous != -1) outputStream.write(previous);

        outputStream.flush();
    }
}
