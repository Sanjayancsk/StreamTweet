package com.streamtweet.streamtweet.entity;
/**
 * TweetEntity is used to ModelObject for page
 * @author SanjayanCsk
 *
 */
public class TweetEntity {
	private String followerId;
	private String hashTag;
	public String getFollowerId() {
		return followerId;
	}
	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}
	
}
