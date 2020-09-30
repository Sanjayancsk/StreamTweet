package com.streamtweet.streamtweet.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
/**
 * TweetConfig configuration file for StreamTweet App
 * @author SanjayanCsk
 *
 */
@Configuration
public class TweetConfig  {
	@Value("7PQuo7FbS0plCoPdrHWpoVNL5")
	private String consumerKey;
	@Value("UEVUnK7SYGTOMetivEAn1OgdeFfThGgTdv1jKYZMirzM2ikPO5")
	private String consumerSecret;
	@Value("1351780730-pJRgc0j45prLlq3G1EeRpYif4VUVoijXPyBgv3D")
	private String accessToken;
	@Value("s7litlO9Q1IZuAwDNgp4qPK81ddwzMqxg1ScXJjSGL0UW")
	private String accessTokenSecret;
	@Bean
	TwitterTemplate getTwtTemplate(){
		return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}

}
