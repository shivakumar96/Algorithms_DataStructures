package com.shivakumar.algorithms.leetcode;

import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DesignTwitter {

    static int time = 1 ;

    private class Tweet{
        int tweetId ;
        int tweetTime ;

        Tweet(int tweetId, int tweetTime) {
            this.tweetId = tweetId;
            this.tweetTime = tweetTime;
        }

        public String tostring(){
            return "( tweetID: " + this.tweetId +" : time: " + this.tweetTime + ")" ;
        }
    }

    Map<Integer,List<Integer>> followesMap ;
    Map<Integer, Stack<Tweet>> newsMap ;

    public DesignTwitter() {
        followesMap = new HashMap<Integer,List<Integer>>();
        newsMap = new HashMap<Integer,Stack<Tweet>>();

    }

    public void initialize(int userId) {
        if(!followesMap.containsKey(userId)){
            followesMap.put(userId,new ArrayList<Integer>());
            followesMap.get(userId).add(userId); // a user is a follower of himself
        }
        if (!newsMap.containsKey(userId)) newsMap.put(userId,new Stack<Tweet>());
    }

    public void postTweet(int userId, int tweetId) {
        if (!newsMap.containsKey(userId)) initialize(userId);
        newsMap.get(userId).push(new Tweet(tweetId, this.time++));

    }

    public List<Integer> getNewsFeed(int userId) {

        if (!newsMap.containsKey(userId) ) initialize(userId);

        List<Integer> feed = new ArrayList<Integer>();
        PriorityQueue<Tweet> feedTime = new PriorityQueue<Tweet>((a,b)->b.tweetTime - a.tweetTime );
        List<Integer> folowees = followesMap.get(userId);
        for(int followee : folowees){
            Stack<Tweet> st = (Stack<Tweet> ) newsMap.get(followee).clone();
            while(!st.isEmpty()){
                feedTime.add(st.pop());
            }
        }

        for(int j=0; j<10 && !feedTime.isEmpty() ;j++)
            feed.add(feedTime.poll().tweetId);

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if(!followesMap.containsKey(followerId) || !followesMap.containsKey(followeeId)) {
            initialize(followerId); initialize(followeeId);
        }
        if(!followesMap.get(followerId).contains(followeeId))
            followesMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!followesMap.containsKey(followerId)) initialize(followerId);
        if(followesMap.get(followerId).contains(followeeId))
            followesMap.get(followerId).remove((Integer)followeeId);
    }

    public static void main(String[] args) {
        String[] commands = new String[] {"Twitter","postTweet","getNewsFeed","follow",
                "postTweet","getNewsFeed","unfollow","getNewsFeed"};
        int[][] values = new int[][] {{},{1,5},{1},{1,2},{2,6},{1},{1,2},{1}};

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        DesignTwitter twitter = null;

        for(int i=0;i<commands.length;i++){

            if(commands[i].equals("Twitter")){
                twitter = new DesignTwitter();
                output.add(null);
            } else if(commands[i].equals("postTweet")){
                twitter.postTweet(values[i][0],values[i][1]);
                output.add(null);
            }else if(commands[i].equals("follow")){
                twitter.follow(values[i][0],values[i][1]);
                output.add(null);

            }else if(commands[i].equals("unfollow")){
                twitter.unfollow(values[i][0],values[i][1]);
                output.add(null);
            } else if (commands[i].equals("getNewsFeed")) {
                output.add(twitter.getNewsFeed(values[i][0]));
            }
        }
        System.out.println(output);
    }

}
