package main;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.*;

import org.json.JSONException;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {

		for (int i = 5; i < 100; i++) {
			//RunescapeResponse resp = RunescapeAPIInterface.getItem(""+i);
			//if(resp.name!=null)
			//	System.out.println("Item: "+resp.name+"   Price: "+resp.current_price + " i = " + i);
		}
		
		
		
		
		RunescapeResponse resp = RunescapeAPIInterface.getItem("11834");
		System.out.println(resp);
	}
}
