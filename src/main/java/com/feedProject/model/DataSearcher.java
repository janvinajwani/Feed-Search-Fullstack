package com.feedProject.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataSearcher {

    public List<DataModel> searchData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DataModel[] dataArray = objectMapper.readValue(new File("C:/Users/ASUS/Downloads/feedProject/feedProject/src/main/resources/mock_data.json"), DataModel[].class);
        return Arrays.asList(dataArray);
    }
}
