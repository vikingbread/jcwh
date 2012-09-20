package json;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		String json = "{\"name\":\"reiz\"}";
		JSONObject jsonObj = JSONObject.fromObject("{}");
		// String name = jsonObj.getString("name");

		// jsonObj.put("initial", name.substring(0, 1).toUpperCase());

		String[] likes = new String[] { "JavaScript", "Skiing", "Apple Pie" };
		jsonObj.put("likes1", likes);
		jsonObj.put("likes2", likes);
		jsonObj.put("likes3", likes);

		Map<String, String> ingredients = new HashMap<String, String>();
		ingredients.put("apples", "3kg");
		ingredients.put("sugar", "1kg");
		ingredients.put("pastry", "2.4kg");
		ingredients.put("bestEaten", "outdoors");
		jsonObj.put("ingredients1", ingredients);
		jsonObj.put("ingredients1", ingredients);

		System.out.println(jsonObj);
		// System.out.println( JSONObject.fromObject(jsonObj));
		JSONObject jsonObj2 = JSONObject.fromObject("{}");
		jsonObj2.put("status", new String[]{"ok"});
		System.out.println(jsonObj2);
	}
}