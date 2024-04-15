package com.feedProject.controller;

import com.feedProject.model.DataModel;
import com.feedProject.repository.DataRepoForFile;
import com.feedProject.service.PaginationService;
import com.feedProject.service.SearchService;
import com.feedProject.service.SortService;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/feedsearch")

public class DataController {

    DataRepoForFile dataFromFile = new DataRepoForFile();
    private List<DataModel> currList;
    @GetMapping()
    public List<DataModel> searchWhole(@RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
                                       @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) throws IOException {
        if(dataFromFile.getDataModel()!=null && dataFromFile.getPageSize()==pageSize && dataFromFile.getPageNumber()==pageNumber) return dataFromFile.getPageDataModel(); // to save data after reload
        SearchService searchService = new SearchService();
        PaginationService paginationService = new PaginationService();
        List<DataModel> resultedList ;
        if(dataFromFile.getDataModel()!=null) resultedList= dataFromFile.getDataModel();
        else resultedList= dataFromFile.saveDataModel(searchService.searchWhole());
        dataFromFile.setPageNumber(pageNumber);
        dataFromFile.setPageSize(pageSize);
        if(((pageNumber - 1) * pageSize) >= resultedList.size()) return dataFromFile.savePageDataModel(null);
        return dataFromFile.savePageDataModel(paginationService.showPage(resultedList, pageNumber, pageSize));
    }
    @GetMapping("/byvalue")
    public List<DataModel> searchByName(@RequestParam String searchTerm, @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
                                        @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) throws IOException {
        boolean isSort = dataFromFile.getSortValue();
        String sortTerm = dataFromFile.getSortTerm();
        SearchService searchService = new SearchService();
        PaginationService paginationService = new PaginationService();
        List<DataModel> resultedList = dataFromFile.saveDataModel(searchService.searchByName(searchTerm, isSort, sortTerm));
        dataFromFile.setPageNumber(pageNumber);
        dataFromFile.setPageSize(pageSize);
        if(((pageNumber - 1) * pageSize) >= resultedList.size()) return dataFromFile.savePageDataModel(null);
        return dataFromFile.savePageDataModel(paginationService.showPage(resultedList, pageNumber, pageSize));
    }

    @GetMapping("/sort")
    public List<DataModel> sortBy(@RequestParam String sortTerm, @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
                                  @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) throws IOException {
        currList = dataFromFile.getDataModel();
        dataFromFile.setSortValue(sortTerm);
        SortService sortService = new SortService();
        PaginationService paginationService = new PaginationService();
        List<DataModel> resultedList = dataFromFile.saveDataModel(sortService.sortBy(sortTerm, currList));
        dataFromFile.setPageNumber(pageNumber);
        dataFromFile.setPageSize(pageSize);
        if(((pageNumber - 1) * pageSize) >= resultedList.size()) return dataFromFile.savePageDataModel(null);
        return dataFromFile.savePageDataModel(paginationService.showPage(resultedList, pageNumber, pageSize));
    }

    @GetMapping("/page")
    public List<DataModel> getDataWithPagination(
            @RequestParam(name = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) throws IOException {

            currList = dataFromFile.getDataModel();
            PaginationService paginationService = new PaginationService();
            dataFromFile.setPageNumber(pageNumber);
            dataFromFile.setPageSize(pageSize);
            if(((pageNumber - 1) * pageSize) >= currList.size()) return dataFromFile.savePageDataModel(null);
            return dataFromFile.savePageDataModel(paginationService.showPage(currList, pageNumber, pageSize));
    }
}
