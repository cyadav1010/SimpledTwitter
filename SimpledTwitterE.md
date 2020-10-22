
Design a simplified Twitter clone

1. List of Users
Request :GET http:localhost:8080/user
Response : return all users

2. User register
Request : POST http:localhost:8080/user , Body : User object
Response : N/A


3. get User Post
Request :GET http:localhost:8080/user/{userId}/post
Response : return all user of user
 

4. User Post message
Request : POST http:localhost:8080/user/{userId}/post , Body : post object
Response : N/A

5. get particular Post of user
Request :GET http:localhost:8080/user/{userId}/post/{id}
Response : return post message


6: Like the particular post 
Request :GET http:localhost:8080/user/{userId}/post/{id}/like
Response : return post message

7: get user follower
Request :GET http:localhost:8080/user/{userId}/follower
Response : return list of follower

8:
Request :POST http:localhost:8080/user/{userId}/follower Body :follower object
Response : return list of follower

9: get user feed
Request :POST http:localhost:8080/user/{userId}/feed Body :
Response : return list of feed


