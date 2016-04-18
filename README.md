# twitter-java

## To Install

Either:

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/

or in Intellij

    VCS -> Checkout from Version Control -> GitHub

    with the project link git@github.com:tsetsova/twitter-java.git


## To try out use the following commands:
* tweet
* timeline
* find
* follow
* sign out
* exit


## Example Interaction:
```
Hi, to tweet, please enter your username:
Spike
Hello Spike
The commands I understand are:
tweet
timeline
find
follow
sign out
exit
tweet
What's on your mind?
Coding is cool!
@Spike said 'Coding is cool!'
timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
tweet
What's on your mind?
more horsees
@Spike said ‘clean code’s the best book ever!'
timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
18/04/2016 07:47:04 @Spike said ‘clean code’s the best book ever!'
sign out
Signed out, your tweets have been saved.
Hi, to tweet, please enter your username:
Leo
Hello Leo
The commands I understand are:
tweet
timeline
find
follow
sign out
exit
tweet
What's on your mind?
What would Thoughtbot do?
@Leo said 'What would Thoughtbot do?'
help
Sorry did you mean one of these commands?
The commands I understand are:
tweet
timeline
find
follow
sign out
exit
timeline
18/04/2016 07:47:18 @Leo said 'What would Thoughtbot do?'
follow
Which user would you like to follow?
Spike
Spike followed!
follow
Which user would you like to follow?
owrifjoiwejfo
owrifjoiwejfo not found
timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
18/04/2016 07:47:04 @Spike said ‘clean code’s the best book ever!'
18/04/2016 07:47:18 @Leo said 'What would Thoughtbot do?'
sign out
Signed out, your tweets have been saved.
```
## If I had more time:
 * Currently once the user follows another user they only receive their existing tweets, but not any new ones. I've been working on this and will get it fixed, but most probably after the deadline :) 
 * extract responsibilities out of the Twitter class
 * test the Twitter class and any extracted class/classes

