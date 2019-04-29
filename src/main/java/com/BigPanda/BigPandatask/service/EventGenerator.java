package com.BigPanda.BigPandatask.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class EventGenerator {
    private Process process;

    public String getEvent() throws IOException {
        InputStream is = getProcess().getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public BufferedReader getEventBufferedReader() throws IOException {
        InputStream is = getProcess().getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    private Process getProcess() throws IOException {
        if (process == null) {
            return this.process = new ProcessBuilder("C:\\Users\\Guy\\Downloads\\generator-windows-amd64.exe").start();
        } else {
            return this.process;
        }
    }
}
