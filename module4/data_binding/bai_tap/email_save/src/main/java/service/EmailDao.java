package service;

import model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class EmailDao {
 private static  Map<Integer,Email>emailMap;
 static {
     emailMap=new TreeMap<>();
     emailMap.put(1,new Email("VietNamese","25","enable spam filter","Quoc Khanh"));
 }
 public List<Email> findAllEmail(){
     List<Email>emailList=new ArrayList<>(emailMap.values());
    return emailList;
 }

}
