package com.feedProject.repository;
import org.springframework.stereotype.Repository;
import com.feedProject.model.DataModel;
import com.feedProject.model.DataRepo;

import java.util.List;

@Repository
public class DataRepoForFile implements DataRepo {
    private List<DataModel> dataModels;
    private List<DataModel> pageDataModels;
    private boolean isSort = false;
    private String sortTerm;

    private int pageSize=2;
    private int pageNumber=1;
    public List<DataModel> getDataModel() {
        return dataModels;
    }
    public void setDataModel(List<DataModel> dataModels) {
        this.dataModels = dataModels;
    }
    public List<DataModel> saveDataModel(List<DataModel> dataModelsList) {
        dataModels=dataModelsList;
        return dataModels;
    }

    public List<DataModel> getPageDataModel() {
        return pageDataModels;
    }
    public void setPageDataModel(List<DataModel> pageDataModels) {
        this.pageDataModels = pageDataModels;
    }
    public List<DataModel> savePageDataModel(List<DataModel> pageDataModelsList) {
        pageDataModels=pageDataModelsList;
        return pageDataModels;
    }

    public boolean getSortValue(){
        return isSort;
    }

    public String getSortTerm(){
        return sortTerm;
    }

    public void setSortValue(String sortTerm){
        isSort = true;
        this.sortTerm = sortTerm;
    }

    public int getPageSize(){
        return pageSize;
    }

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

    public int getPageNumber(){
        return pageNumber;
    }

    public void setPageNumber(int pageNumber){
    this.pageNumber = pageNumber;
    }
}

