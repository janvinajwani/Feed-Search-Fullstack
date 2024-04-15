package com.feedProject.service;
import com.feedProject.model.DataModel;
import com.feedProject.model.DataSearcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class SortService {
    public List<DataModel> sortBy(String sortTerm, List<DataModel> currList) throws IOException {
        if(sortTerm.equalsIgnoreCase("name")){
            Comparator<DataModel> comparator = Comparator.comparing(DataModel::getName);
            // Sort the list using the comparator
            Collections.sort(currList, comparator);
        }
        else if(sortTerm.equalsIgnoreCase("date")){
            Comparator<DataModel> comparator = Comparator.comparing(DataModel::getDateLastEdited);
            Collections.sort(currList, comparator);
        }
        return currList;
    }
}
