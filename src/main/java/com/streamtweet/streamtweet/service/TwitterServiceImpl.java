package com.streamtweet.streamtweet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.streamtweet.streamtweet.entity.TweetEntity;
/**
 * TwitterServiceImpl is Service Implementation layer for StreamTweet Application
 * @author SanjayanCsk
 *
 */
@Service
public class TwitterServiceImpl {
	@Autowired
	private Twitter twitter;
	
	/**
	 *  fetchTweets Method is used to fetch the tweet value from Twitter API
	 * 
	 * @param tweetEntity
	 * @return List<Tweet> values
	 */
	public List<Tweet> fetchTweets(TweetEntity tweetEntity) {
		List<Tweet> list_of_tweets = new ArrayList<>();
		String followers =tweetEntity.getFollowerId();
		String hashTag =tweetEntity.getHashTag();
		if(followers!=""&&hashTag!=""){
			String [] variables = {"@"+followers,"#"+hashTag};
			Random ran = new Random();
			int value=ran.nextInt(variables.length);
			list_of_tweets = twitter.searchOperations().search(variables[value], 20).getTweets();
		}else if(hashTag!=""){
			list_of_tweets = twitter.searchOperations().search("#"+hashTag, 20).getTweets();
		}else if(followers!=""){
			list_of_tweets = twitter.searchOperations().search("@"+followers, 20).getTweets();
		}
		return list_of_tweets;
	}

}
