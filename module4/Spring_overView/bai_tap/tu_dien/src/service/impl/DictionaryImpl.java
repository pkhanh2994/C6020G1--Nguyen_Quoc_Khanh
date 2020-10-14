package service.impl;

import org.springframework.stereotype.Service;
import service.Dictionary;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryImpl implements Dictionary {
    @Override
    public String resultSearch(String search) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String result=dictionary.get(search);
        String resultSearch;
        if(result!=null){
            resultSearch="search :"+search+"\n";
            resultSearch+="result :"+result;
        }else {
            resultSearch="No world";

        }
        return resultSearch;
    }
}
