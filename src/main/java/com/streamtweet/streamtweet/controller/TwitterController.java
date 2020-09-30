package com.streamtweet.streamtweet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.streamtweet.streamtweet.entity.TweetEntity;
import com.streamtweet.streamtweet.service.TwitterService;

@Controller
public class TwitterController {

	@Autowired
	private TwitterService twitterService;

	
	/**
	 * check method is initial method to load page
	 * 
	 * @author SanjayanCsk 
	 * @param tweetEntity
	 * @return ModelAndView as list_of_tweets 
	 */
	@RequestMapping("check")
	public ModelAndView check(TweetEntity tweetEntity){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("check");
		return mv;
	}

	/**
	 * searchTweet method is used for fetching the tweet value from twitterAPI
	 * 
	 * @author SanjayanCsk 
	 * @param tweetEntity
	 * @return ModelAndView as list_of_tweets 
	 */
	@RequestMapping(value="searchTweet",method=RequestMethod.POST)
	public ModelAndView searchTweet(TweetEntity tweetEntity){
		ModelAndView mv = new ModelAndView();
		List<Tweet> list_of_tweets = new ArrayList<>();
		list_of_tweets= twitterService.getTweets(tweetEntity);
		mv.addObject("follower", tweetEntity.getFollowerId());
		mv.addObject("hashTag", tweetEntity.getHashTag());
		mv.addObject("prods",list_of_tweets);
		mv.setViewName("check");
		return mv;
	}
}
