package com.gxb.trend.controller;

import com.gxb.trend.pojo.IndexData;
import com.gxb.trend.service.IndexDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexDataController {

    @Autowired
    private IndexDataService indexDataService;

    //  http://127.0.0.1:8001/freshIndexData/000300
    //  http://127.0.0.1:8001/getIndexData/000300
    //  http://127.0.0.1:8001/removeIndexData/000300

    @GetMapping("freshIndexData/{code}")
    public String fresh(@PathVariable("code") String code) {
        indexDataService.fresh(code);
        return "refresh index data successfully";
    }

    @GetMapping("getIndexData/{code}")
    public List<IndexData> get(@PathVariable("code") String code) {
        return indexDataService.get(code);
    }

    @GetMapping("removeIndexData/{code}")
    public String remove(@PathVariable("code") String code) {
        indexDataService.remove(code);
        return "remove index data successfully";
    }
}
