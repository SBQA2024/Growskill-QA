package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.SerializePayload;
import pojo.lOCATION;

public class TestDataBuilder  {
	
	public SerializePayload AddAPIPayload(String name ,String phone_number ,String address) {
	
	
	SerializePayload obj = new SerializePayload();
	
	obj.setAccuracy(50);
	obj.setAddress(address);
	obj.setLanguage("French-IN");
	
	lOCATION loc = new lOCATION();
         loc.setLat(-38.383494);
         loc.setLng(33.427362);
         
         obj.setLocation(loc);
         
         obj.setName(name);
         obj.setPhone_number(phone_number);
         
       List<String> types = new ArrayList<>();
       
       types.add("shoe park");
       types.add("shop");
       
       obj.setTypes(types);
       
       return obj;

}}
