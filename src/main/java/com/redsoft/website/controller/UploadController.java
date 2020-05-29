package com.redsoft.website.controller;


import com.redsoft.starters.own.util.result.JsonResult;
import com.redsoft.starters.uploader.result.FileResult;
import com.redsoft.starters.uploader.service.Uploader;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("upload")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UploadController {

    private final Uploader uploader;

    @PostMapping("file")
    public JsonResult<String> file(@RequestParam("file") MultipartFile file) throws IOException {
        return JsonResult
                .ok(uploader.upload(file).orElseThrow(() -> new IllegalArgumentException("文件上传失败"))
                        .getUrl());
    }

    @PostMapping("file/{module}")
    public JsonResult<String> fileModule(@RequestParam("file") MultipartFile file,
            @PathVariable("module") String module)
            throws IOException {
        return JsonResult.ok(uploader.upload(file, module.replace(",", "/"))
                .orElseThrow(() -> new IllegalArgumentException("文件上传失败")).getUrl());
    }

    @PostMapping("files")
    public JsonResult<List<String>> files(@RequestParam("files") MultipartFile[] files)
            throws IOException {
        return JsonResult.ok(uploader.uploads(files).orElse(new ArrayList<>()).stream()
                .map(FileResult::getUrl).collect(Collectors.toList()));
    }

    @PostMapping("files/{module}")
    public JsonResult<List<String>> filesModule(@RequestParam("files") MultipartFile[] files,
            @PathVariable("module") String module)
            throws IOException {
        return JsonResult
                .ok(uploader.uploads(files, module.replace(",", "/")).orElse(new ArrayList<>())
                        .stream()
                        .map(FileResult::getUrl).collect(Collectors.toList()));
    }

}
