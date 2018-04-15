package com.cxtx.model;

public class ResponseJSON {
    public int status;
    public String files;

    public ResponseJSON(int status, String files) {
        this.status = status;
        this.files = files;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
}
