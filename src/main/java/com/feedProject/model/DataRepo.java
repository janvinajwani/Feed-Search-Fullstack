package com.feedProject.model;
import java.io.IOException;
import java.util.List;
public interface DataRepo {
    List<DataModel> saveDataModel(List<DataModel> dataModelList);
    void setDataModel(List<DataModel> dataModelList);
    List<DataModel> getDataModel();

    //saving current page info
    List<DataModel> savePageDataModel(List<DataModel> dataModelList);
    void setPageDataModel(List<DataModel> dataModelList);
    List<DataModel> getPageDataModel();
}
