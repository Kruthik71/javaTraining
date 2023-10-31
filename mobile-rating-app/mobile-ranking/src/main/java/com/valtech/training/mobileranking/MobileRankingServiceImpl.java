package com.valtech.training.mobileranking;

import java.util.List;

import com.valtech.training.patternchecker.PatternCheckerService;
import com.valtech.training.patternchecker.PatternCheckerServiceImpl;

public class MobileRankingServiceImpl implements MobileRankingService {
	
	private PatternCheckerService pattCheckService = new PatternCheckerServiceImpl();
	
	@Override
	public int  rankMobile(String mobile) {
		List<String> patterns=pattCheckService.listPatterns(mobile);
		//Rating logic here
		return 0;
	}
}
