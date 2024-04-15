package com.feedProject.service;
import com.feedProject.model.DataModel;
import com.feedProject.model.DataSearcher;
import com.feedProject.repository.DataRepoForFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PaginationService {
    public List<DataModel> showPage(List<DataModel> currlist, int pageNumber, int pageSize) throws IOException {
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, currlist.size());

        return currlist.subList(startIndex, endIndex);
    }
}
