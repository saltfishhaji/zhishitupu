package com.cxtx.controller;

import com.cxtx.Tools.ExcelReader;
import com.cxtx.Tools.RelationExtraction;
import com.cxtx.model.FileKeyValueResponse;
import com.cxtx.model.Pair;
import com.cxtx.model.ResponseJSON;
import com.cxtx.model.TestCase;
import com.cxtx.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController extends ApiController{

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
        this.storageService.deleteAll();
        this.storageService.init();
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public ResponseJSON handleFileUpload(@RequestParam("file") MultipartFile[] files,
                                         RedirectAttributes redirectAttributes) {
        String outMessage = "";
        for(MultipartFile file:files){
            String storedPath = storageService.store(file);
            if(outMessage.equals(""))
                outMessage = file.getOriginalFilename();
            else
                outMessage += ","+file.getOriginalFilename();
            System.out.println(file.getOriginalFilename() + "->" + storedPath);
        }
        return new ResponseJSON(200,outMessage);
    }

    @RequestMapping(value = "/listall",method = RequestMethod.GET)
    @ResponseBody
    public List<FileKeyValueResponse> handleListAll(){
        List<FileKeyValueResponse> ret = new ArrayList<>();
        String splitWords1[] = {"：为", "=为", "=", "为：",">", "<", "大于", "小于","为",":","：", "等于"};
        List<File> fileList = this.storageService.loadAllFile();
        System.out.println(fileList.get(0).getAbsolutePath());
        System.out.println(fileList.get(1).getAbsolutePath());
        for(File file:fileList){
            List<TestCase> testCases = ExcelReader.getTextCaseByFile(file);
            List<Pair> pairList = RelationExtraction.divideOnly(testCases,"[.,!?\\s]+",splitWords1);
            for(Pair p : pairList){
                System.out.println("["+p.key+" -> "+p.value+"]");
            }
            ret.add(new FileKeyValueResponse(file.getName(),pairList));
        }
        return ret;
    }
}