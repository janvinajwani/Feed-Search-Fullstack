package com.feedProject.service;

import com.feedProject.model.DataModel;
import com.feedProject.model.DataSearcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchService {
    static List<DataModel> storedList = new ArrayList<>(); // the whole json list that should not change
    public List<DataModel> searchWhole() throws IOException {
        DataSearcher dataSearcher = new DataSearcher();
        List<DataModel> dataList = dataSearcher.searchData();
        storedList = dataList;
        return dataList;
    }

    public List<DataModel> searchByName(String searchTerm, boolean isSort, String sortTerm) throws IOException {
        if(isSort==true){
            SortService sortService = new SortService();
            storedList = sortService.sortBy(sortTerm, storedList);
        }
        if (searchTerm == null || searchTerm.isEmpty()) {
            return storedList;
        }

        List<DataModel> searchResults = new ArrayList<>();

        // Check if search term contains exact match in double quotes
        if (searchTerm.startsWith("\"") && searchTerm.endsWith("\"")) {
            String exactMatch = searchTerm.substring(1, searchTerm.length() - 1);
            for (DataModel data : storedList) {
                if (data.getName().toLowerCase().contains(exactMatch.toLowerCase()) || data.getDescription().toLowerCase().contains(exactMatch.toLowerCase())) {
                    searchResults.add(data);
                }
            }
        } else {
            String[] substrArray = searchTerm.split("\\s+");
            for (DataModel data : storedList) {
                String[] dataName = data.getName().split("\\s+");
                String[] dataDesc = data.getDescription().split("\\s+");
                int index1=0;
                int index2=0;
                while (index1 < substrArray.length && index2 < dataName.length) {
                    if (substrArray[index1].equalsIgnoreCase(dataName[index2])) {
                        index1++;
                    }
                    index2++;
                }

                if(index1 == substrArray.length) {
                    searchResults.add(data);
                    continue;
                }
                 index1=0;
                 index2=0;
                while (index1 < substrArray.length && index2 < dataDesc.length) {
                    if (substrArray[index1].equalsIgnoreCase(dataDesc[index2])) {
                        index1++;
                    }
                    index2++;
                }
                if(index1 == substrArray.length) {
                    searchResults.add(data);
                }
            }
            }

        return searchResults;
    }
}

