package RunescapeAPIInterface;

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

	/**
	 * Returns a RunescapeResponse object or null.
	 * 
	 * @param item
	 * @return RunescapeResponse
	 */
	public static RunescapeResponse getItem(String item) {
		RunescapeResponse resp = new RunescapeResponse();

		try {
			JSONObject jsonObj = getJSONObjectItem(item).getJSONObject("item");

			resp.id = jsonObj.getInt("id");
			resp.name = jsonObj.getString("name");
			resp.description = jsonObj.getString("description");
			resp.members = jsonObj.getBoolean("members");
			
			String tempCurrentPrice = jsonObj.getJSONObject("current").get("price").toString();
			resp.current_price = convertRunescapePriceStringToInt(tempCurrentPrice);
			
			String tempTodayPrice = jsonObj.getJSONObject("today").get("price").toString();
			resp.today_price = convertRunescapePriceStringToInt(tempTodayPrice);
			
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
	
	private static int convertRunescapePriceStringToInt(String number) {
		
		// Runescape's API returns negative numbers as "- 12"
		number = number.replace(" ", "");
		
		// Runescape API contains commas in the prices. Ex "1,234"
		number = number.replace(",", "");
		
		try {
			int num = Integer.parseInt(number);
			return num;
		} catch (NumberFormatException e) {
			if (number.contains("k")) {
				number = number.replace("k", "");
				return (int) (Double.parseDouble(number) * 1000);
			} else if (number.contains("m")) {
				number = number.replace("m", "");
				return (int) (Double.parseDouble(number) * 1000000);
			}
			
			return 0;
		}
	}
	
	public static String getPlayerHighscoresStrResponse(String username) {
		// Sample URL
		// http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=Fudget
		
		try {
			String baseUrl = "http://services.runescape.com/m=hiscore_oldschool/index_lite.ws?player=";
			baseUrl += username;

			URL url = new URL(baseUrl);
			URLConnection yc = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(yc.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String line = null;
			try {
				while ((line = reader.readLine()) != null) {
					sb.append(line + ",");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static RunescapeHighscoresResponse getRunescapeHighscores(String username) {
		String response = getPlayerHighscoresStrResponse(username);
		System.out.println(response);
		String[] responseArray = response.split(",");
		
		RunescapeHighscoresResponse resp = new RunescapeHighscoresResponse(username);
		int index = 0;
		resp.overall_rank = Integer.parseInt(responseArray[index++]);
		resp.overall_level = Integer.parseInt(responseArray[index++]);
		resp.overall_xp = Integer.parseInt(responseArray[index++]);
		
		resp.attack.rank = Integer.parseInt(responseArray[index++]);
		resp.attack.level = Integer.parseInt(responseArray[index++]);
		resp.attack.xp = Integer.parseInt(responseArray[index++]);
		
		resp.defence.rank = Integer.parseInt(responseArray[index++]);
		resp.defence.level = Integer.parseInt(responseArray[index++]);
		resp.defence.xp = Integer.parseInt(responseArray[index++]);
		
		resp.strength.rank = Integer.parseInt(responseArray[index++]);
		resp.strength.level = Integer.parseInt(responseArray[index++]);
		resp.strength.xp = Integer.parseInt(responseArray[index++]);
		
		resp.hitpoints.rank = Integer.parseInt(responseArray[index++]);
		resp.hitpoints.level = Integer.parseInt(responseArray[index++]);
		resp.hitpoints.xp = Integer.parseInt(responseArray[index++]);
		
		resp.ranged.rank = Integer.parseInt(responseArray[index++]);
		resp.ranged.level = Integer.parseInt(responseArray[index++]);
		resp.ranged.xp = Integer.parseInt(responseArray[index++]);
		
		resp.prayer.rank = Integer.parseInt(responseArray[index++]);
		resp.prayer.level = Integer.parseInt(responseArray[index++]);
		resp.prayer.xp = Integer.parseInt(responseArray[index++]);
		
		resp.magic.rank = Integer.parseInt(responseArray[index++]);
		resp.magic.level = Integer.parseInt(responseArray[index++]);
		resp.magic.xp = Integer.parseInt(responseArray[index++]);
		
		resp.cooking.rank = Integer.parseInt(responseArray[index++]);
		resp.cooking.level = Integer.parseInt(responseArray[index++]);
		resp.cooking.xp = Integer.parseInt(responseArray[index++]);
		
		resp.woodcutting.rank = Integer.parseInt(responseArray[index++]);
		resp.woodcutting.level = Integer.parseInt(responseArray[index++]);
		resp.woodcutting.xp = Integer.parseInt(responseArray[index++]);
		
		resp.fletching.rank = Integer.parseInt(responseArray[index++]);
		resp.fletching.level = Integer.parseInt(responseArray[index++]);
		resp.fletching.xp = Integer.parseInt(responseArray[index++]);
		
		resp.fishing.rank = Integer.parseInt(responseArray[index++]);
		resp.fishing.level = Integer.parseInt(responseArray[index++]);
		resp.fishing.xp = Integer.parseInt(responseArray[index++]);
		
		resp.firemaking.rank = Integer.parseInt(responseArray[index++]);
		resp.firemaking.level = Integer.parseInt(responseArray[index++]);
		resp.firemaking.xp = Integer.parseInt(responseArray[index++]);
		
		resp.crafting.rank = Integer.parseInt(responseArray[index++]);
		resp.crafting.level = Integer.parseInt(responseArray[index++]);
		resp.crafting.xp = Integer.parseInt(responseArray[index++]);
		
		resp.smithing.rank = Integer.parseInt(responseArray[index++]);
		resp.smithing.level = Integer.parseInt(responseArray[index++]);
		resp.smithing.xp = Integer.parseInt(responseArray[index++]);
		
		resp.mining.rank = Integer.parseInt(responseArray[index++]);
		resp.mining.level = Integer.parseInt(responseArray[index++]);
		resp.mining.xp = Integer.parseInt(responseArray[index++]);
		
		resp.herblore.rank = Integer.parseInt(responseArray[index++]);
		resp.herblore.level = Integer.parseInt(responseArray[index++]);
		resp.herblore.xp = Integer.parseInt(responseArray[index++]);
		
		resp.agility.rank = Integer.parseInt(responseArray[index++]);
		resp.agility.level = Integer.parseInt(responseArray[index++]);
		resp.agility.xp = Integer.parseInt(responseArray[index++]);
		
		resp.thieving.rank = Integer.parseInt(responseArray[index++]);
		resp.thieving.level = Integer.parseInt(responseArray[index++]);
		resp.thieving.xp = Integer.parseInt(responseArray[index++]);
		
		resp.slayer.rank = Integer.parseInt(responseArray[index++]);
		resp.slayer.level = Integer.parseInt(responseArray[index++]);
		resp.slayer.xp = Integer.parseInt(responseArray[index++]);
		
		resp.farming.rank = Integer.parseInt(responseArray[index++]);
		resp.farming.level = Integer.parseInt(responseArray[index++]);
		resp.farming.xp = Integer.parseInt(responseArray[index++]);
		
		resp.runecraft.rank = Integer.parseInt(responseArray[index++]);
		resp.runecraft.level = Integer.parseInt(responseArray[index++]);
		resp.runecraft.xp = Integer.parseInt(responseArray[index++]);
		
		resp.hunter.rank = Integer.parseInt(responseArray[index++]);
		resp.hunter.level = Integer.parseInt(responseArray[index++]);
		resp.hunter.xp = Integer.parseInt(responseArray[index++]);
		
		resp.construction.rank = Integer.parseInt(responseArray[index++]);
		resp.construction.level = Integer.parseInt(responseArray[index++]);
		resp.construction.xp = Integer.parseInt(responseArray[index++]);
		
		return resp;
	}
}
