package com.cxtx.model;

import java.util.List;

public class FileKeyValueResponse {
    String filename;
    List<Pair> keyvaluepair;

    public FileKeyValueResponse(String filename, List<Pair> keyvaluepair) {
        this.filename = filename;
        this.keyvaluepair = keyvaluepair;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Pair> getKeyvaluepair() {
        return keyvaluepair;
    }

    public void setKeyvaluepair(List<Pair> keyvaluepair) {
        this.keyvaluepair = keyvaluepair;
    }


}
