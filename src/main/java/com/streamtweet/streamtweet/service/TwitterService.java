package com.streamtweet.streamtweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import com.streamtweet.streamtweet.entity.TweetEntity;
/**
 * TwitterService is Service layer for StreamTweet
 * @author SanjayanCsk
 *
 */
@Service
public class TwitterService {
	@Autowired
	private TwitterServiceImpl twitterServiceImpl;
	
	/**
	 * getTweets method is used to fetch the tweet value
	 * 
	 * @author SanjayanCsk
	 * @param tweetEntity
	 * @return List<Tweet> values
	 */
	public List<Tweet> getTweets(TweetEntity tweetEntity) {
		return twitterServiceImpl.fetchTweets(tweetEntity);
	}

}
