package com.cxtx.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    String store(MultipartFile file);

    Stream<Path> loadAll();

    List<File> loadAllFile();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}