package com.valtech.training.ratingui;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.mobileranking.MobileRankingServiceImpl;

public class RatingHelper {
	private MobileRankingService mobRankService=new MobileRankingServiceImpl();
	public int getRating(String mobile) {
		return mobRankService.rankMobile(mobile);
	}
}

//7dedd55d5d9340efa789ace6bdc29034