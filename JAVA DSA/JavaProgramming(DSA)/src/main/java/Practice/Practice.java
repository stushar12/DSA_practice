package Practice;

import java.util.*;

public class Practice {
    public static HashMap<Integer, List<Integer>> postMapping = new HashMap<>();

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter operation to be performed:  ");
//            int operationPerformed = sc.nextInt();
//
//            if (operationPerformed == 1) {
//                //post
//                System.out.println("Enter userId :  ");
//                int userId = sc.nextInt();
//                System.out.println("Enter postId: ");
//                int postId = sc.nextInt();
//                post(userId,postId);
//
//            } else if (operationPerformed == 2) {
//                //get
//                System.out.println("Enter userId :  ");
//                int userId = sc.nextInt();
//                List<Integer> result= new ArrayList<>();
//                result = get(userId);
//                for(Integer elem: result){
//                    System.out.print(elem + "  ");
//                }
//                System.out.println();
//            } else if (operationPerformed == 3) {
//                //follow
//                System.out.println("Enter userId to follow :  ");
//                int follower = sc.nextInt();
//                System.out.println("Enter userId to followee: ");
//                int followee = sc.nextInt();
//                follow(follower,followee);
//            } else if (operationPerformed == 4) {
//                //unfolllow
//                System.out.println("Enter userId to unfollow :  ");
//                int unfollower = sc.nextInt();
//                System.out.println("Enter userId to unfollowee: ");
//                int unfollowee = sc.nextInt();
//                unfollow(unfollower,unfollowee);
//            } else {
//                System.exit(0);
//            }
//        }
    }

    static void post(int userId, int postId) {
        List<Integer> postList = new ArrayList<>();
        if (postMapping.get(userId) != null) {
            postList = postMapping.get(userId);
        }
        postList.add(postId);
        postMapping.put(userId, postList);
    }

    static List<Integer> get(int userId) {
        if (postMapping.get(userId) != null) {
            return postMapping.get(userId);
        }
        return new ArrayList<>();
    }

    static void follow(int followerId, int followeeId) {
        List<Integer> followerPostList = new ArrayList<>();
        List<Integer> followeePostList = new ArrayList<>();
        if (postMapping.get(followerId) != null) {
            followerPostList = postMapping.get(followerId);
        }
        if (postMapping.get(followeeId) != null) {
            followeePostList = postMapping.get(followeeId);
        }
        for (Integer post : followeePostList) {
            followerPostList.add(post);
        }
        postMapping.put(followerId, followerPostList);
    }

    static void unfollow(int unfollowerId, int unfolloweeId) {
        List<Integer> unfollowerPostList = new ArrayList<>();
        List<Integer> unfolloweePostList = new ArrayList<>();
        if (postMapping.get(unfollowerId) != null) {
            unfollowerPostList = postMapping.get(unfollowerId);
        }
        if (postMapping.get(unfolloweeId) != null) {
            unfolloweePostList = postMapping.get(unfolloweeId);
        }
        for (Integer post : unfolloweePostList) {
            unfollowerPostList.remove(post);
        }
        postMapping.put(unfollowerId, unfollowerPostList);
    }

    public static int getAllSubstrings(String str) {
        int count = 0;
        int length = str.length();


        for (int i = 0; i < length; i++) {
            int[] frequency = new int[3];
            for (int j = i; j < length; j++) {
                frequency[str.charAt(j) - 'a'] = 1;
                if (frequency[0] + frequency[1] + frequency[2] == 3) {
                    count++;
                }

            }
        }
        return count;
    }
}
