package com.adara;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class AdCallProcessor {
	// hypothetical high-level ad call logic...
	public void handleAdCall(int placementId) {
		// which ads are mapped to this placement
		Collection<PlacementAdMapping> eligibleAds = getAdsForPlacement(placementId);
		// choose one of the ads based on relative weight
		PlacementAdMapping chosenAd = chooseAd(eligibleAds);
		// ... render the ad
		System.out.println(chosenAd);
	}

	/**
	 * Choose one of the ads ( based on relative weight )
	 * 
	 * @param ads
	 *            list of ads to choose from
	 * @return the chosen ad
	 */
	public PlacementAdMapping chooseAd(Collection<PlacementAdMapping> ads) {
		int totalWeight = 0;
		Iterator<PlacementAdMapping> iterator = ads.iterator();
		// To handle the error or when nothing is passed
		if (ads.size() == 0) {
			System.err.println("Error, there are no elements in the collection");
			return null;
		}
		// This iterates trough the collection of ads and calculates the total
		// weight
		while (iterator.hasNext()) {
			PlacementAdMapping pam = iterator.next();
			if (pam.getWeight() <= 0) {
				System.err.println("Error, the weight needs to be between 1 to MAXINTEGER");
				return null;
			}
			totalWeight += pam.getWeight();
		}
		Random r = new Random();
		// Pick a random value from 0 to totalWeight
		int randomValue = 0;
		try {
			randomValue = r.nextInt(totalWeight);
		} catch (Exception e) {
			//This will only happen when the sum of the total weights exceed Interget.MAX_VALUE
			System.err.println("Error, The total weights excedded Integer.MAX_VALUE");
			return null;
		}
		iterator = ads.iterator();
		// this will choose a random number based on the weight
		while (iterator.hasNext()) {
			PlacementAdMapping pam = iterator.next();
			randomValue -= pam.getWeight();
			if (randomValue < 0)
				return pam;
		}
		return null;
	}

	/**
	 * returns the ads mapped to a given placement
	 * 
	 * @param placementId
	 * @return collection of PlacementAd objects mapped to placement
	 */
	protected Collection<PlacementAdMapping> getAdsForPlacement(int placementId) {
		//
		// In a "real" implementation, this info would probably be read from a
		// DB...
		//
		// For this exercise, feel free to override this for the purpose of
		// testing
		// I created this for initial testing. To see a more elaborated tests
		// view TestCases.java
		ArrayList<PlacementAdMapping> pamArray = new ArrayList<PlacementAdMapping>();
		pamArray.add(new PlacementAdMapping(1, 101, 10));

		return pamArray;
	}
}