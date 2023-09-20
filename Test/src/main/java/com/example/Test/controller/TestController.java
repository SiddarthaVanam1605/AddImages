package com.example.Test.controller;

import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    private TestInter testInterface;


    @GetMapping("/createVideo/imagePath1/imagePath2")
    public String genarateVideo(@RequestParam String imagePath1, @RequestParam String imagePath2){

        List<String> imagePaths = new ArrayList<>();
        imagePaths.add(imagePath1);
        imagePaths.add(imagePath2);

        String respnseImagePaths = null;
        try {
            respnseImagePaths = testInterface.getVideo(imagePaths);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return respnseImagePaths;




    }









}
