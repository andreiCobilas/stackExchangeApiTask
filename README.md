
Commit of the done task: 

Used gradle as a package manager and retrofit for API interaction.
It took around 16 hours to finish, take care of throttle violation when sending multiple records. Because there is no way to sort by location when making the api request.
I first take all users that have reputation over 223 and are tagged with:
"java",".net","docker" or "C# . After that I check the list for users by location from Romania/Moldova, and if they are from correct country I show them with the logger in following format :

User name: user.userName 
Location: user.location
Answer Count: user.answerCount 
Question count: user.questionCount
User tags : user tags as a string divided by ,
User link :  user.profileLink
User Avatar Link: user.avatarLink

Task:
Using the stackoverflow.com api documented at: https://api.stackexchange.com/docs retrieve
the list of stack overflow users meeting the following criteria:
i. Are located in Romania or Moldova
ii. Have a reputation of min 223 points.
iii. Answered min 1 question
iv. Have the tags: "java",".net","docker" or "C#" Requirements:
 The code should be tracked with git and pushed to Github or Bitbucket.  The app should be written in Java (bonus points if written in Kotlin)
 The list of retrieved users should be dumped in a list in STDOUT.  Each line should contain:
 User name
 Location
 Answer count
 Question count
 Tags as a comma delimited string
 Link to profile
 Link to avatar
