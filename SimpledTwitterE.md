# SimpledTwitter

Design a simplified Twitter clone

1)
GET call
-  /user
 Response : return all users 
 
 2)
 POST call
 -/user
  Body : send user info 
  
  3)/user/{userid}
  GET call:
  Response : user Info
  Api info : get user Info of particular user
  
  4) 
  POST call 
  /user/{userid}/post
   
  Api info : send UserPost
  
  5)
  GET call :
  user/{userId}/post/{id}
  Response : getUserPostId details 
  
  6)
  GET call :
  user/{userId}/post/{id}/like
  api info :like a particular post 
  
  7)
  GET call :
  
  user/{userId}/follower
  api info : Get list of follower of user 
  
  8)
  POST call :
  user/{userId}/follower
  
  api info : add follow of particular user 
  
  9)
  GET call :
  user/{userId}/feed
  
  api info :get feed of a user 
