package main;

/**
 * @author Miguel Deniz
 * @version 12/27/17
 * Last update: 12/27/17
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

/*
 * {  
   "item":{  
      "icon":"http://services.runescape.com/m=itemdb_rs/4908_obj_sprite.gif?id=4151",
      "icon_large":"http://services.runescape.com/m=itemdb_rs/4908_obj_big.gif?id=4151",
      "id":4151,
      "type":"Default",
      "typeIcon":"http://www.runescape.com/img/categories/Default",
      "name":"Abyssal whip",
      "description":"A weapon from the abyss.",
      "current":{  
         "trend":"neutral",
         "price":"2.3m"
      },
      "today":{  
         "trend":"neutral",
         "price":0
      },
      "members":"true",
      "day30":{  
         "trend":"positive",
         "change":"+9.0%"
      },
      "day90":{  
         "trend":"negative",
         "change":"-7.0%"
      },
      "day180":{  
         "trend":"positive",
         "change":"+44.0%"
      }
   }
}
 */

public class RunescapeAPIInterface {

	public static JSONObject getJSONObjectItem(String item) {
		try {
			String baseUrl = "http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=";
			baseUrl += item;

			URL url = new URL(baseUrl);
			URLConnection yc = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			return new JSONObject(sb.toString());
		} catch (Exception e) {
			return null;
		}
	}

	// item = 11834
	public static RunescapeResponse getItem(String item) {
		RunescapeResponse resp = new RunescapeResponse();

		try {
			JSONObject jsonObj = getJSONObjectItem(item).getJSONObject("item");

			resp.id = jsonObj.getInt("id");
			resp.name = jsonObj.getString("name");
			resp.description = jsonObj.getString("description");
			resp.members = jsonObj.getBoolean("members");
			
			resp.current_trend = jsonObj.getJSONObject("current").getString("trend");
			resp.current_price = jsonObj.getJSONObject("current").getString("price");
			
			resp.today_trend = jsonObj.getJSONObject("today").getString("trend");
			resp.today_price = jsonObj.getJSONObject("today").getString("price");
			
			resp.day30_trend = jsonObj.getJSONObject("day30").getString("trend");
			resp.day30_change = jsonObj.getJSONObject("day30").getString("change");
			
			resp.day90_trend = jsonObj.getJSONObject("day90").getString("trend");
			resp.day90_change = jsonObj.getJSONObject("day90").getString("change");
			
			resp.day180_trend = jsonObj.getJSONObject("day180").getString("trend");
			resp.day180_change = jsonObj.getJSONObject("day180").getString("change");
			
			return resp;
		} catch (Exception e) {
			return resp;
		}
	}
}