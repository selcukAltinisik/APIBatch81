package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedDataMethod(Integer userId, String title, Boolean completed){
        //  Dinamik expected data methodu: Json datayı String bir container olarak return ediyor.

        Map<String,Object> expectedDataMap = new HashMap<>();
        if (userId!=null){
            expectedDataMap.put("userId",1);

        }
        if (title!=null){
            expectedDataMap.put("title", title);

        }
        if (completed!=null){
            expectedDataMap.put("completed", false);
        }

        return expectedDataMap;
    }

    /*
        {
         "userId": 55,
         "title": "Tidy your room",
         "completed": false
         }
     */
    public String expectedDataInString(int userId,String title, boolean completed){
        String expectedData = "{\n" +
                "                 \"userId\": "+userId+",\n" +
                "                 \"title\": \""+title+"\",\n" +
                "                 \"completed\": "+completed+"\n" +
                "                 }";
        return expectedData;
    }



}
