package com.ibm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.dao.NumberDao;
import com.ibm.model.Dice;
import com.ibm.model.RandomNumberConstants;
import com.ibm.properties.DatabaseProperties;

@RestController
public class RandomNumber {
	@Autowired
	private DatabaseProperties db;
	
	public void Randomnumber() {
		
	}

	@RequestMapping("/randomNumber")
	public Map<String, List<Dice>> getRandom() {
		List<Dice> diceList = getDiceList();
		Map<String, List<Dice>> diceMap = new HashMap<String, List<Dice>>();

		// connect to the database
		System.out.println("USE DATABASE: " + db.getUseDatabase());
		if ("true".equalsIgnoreCase(db.getUseDatabase())) {
			NumberDao dao = new NumberDao();
			dao.insertDice(diceList);
		}
		
		diceMap.put("dice", diceList);

		return diceMap;
	}

	private List<Dice> getDiceList() {
		List<Dice> diceList = new ArrayList<Dice>();
		for (int i = 1; i <= 3; i++) {
			Dice d = new Dice();
			d = generateRandomNumber(i, d);
			diceList.add(d);
		}
		return diceList;
	}

	private Dice generateRandomNumber(int id, Dice d) {
		Random r = new Random();
		d.setName(RandomNumberConstants.DICE_NAME + id);
		d.setValue(r.nextInt(6) + 1);
		return d;
	}

}