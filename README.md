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

### To sign in:

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
---

```

### To tweet and see your tweets:

```
tweet
What's on your mind?
Coding is cool!
@Spike said 'Coding is cool!'
timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
tweet
@Spike said ‘clean code’s the best book ever!'
timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
18/04/2016 07:47:04 @Spike said ‘clean code’s the best book ever!'
```

### To search for other users and follow them:

```
timeline
18/04/2016 07:47:18 @Spike said 'What would Thoughtbot do?'
follow
Which user would you like to follow?
Leo
Spike followed!
follow
Which user would you like to follow?
owrifjoiwejfo
owrifjoiwejfo not found
timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
18/04/2016 07:47:04 @Spike said ‘clean code’s the best book ever!'
18/04/2016 07:47:04 @Leo said ‘I love php!!!'
18/04/2016 07:47:18 @Spike said 'What would Thoughtbot do?'
```

### If you sign out your tweets are safe

```
sign out
Signed out, your tweets have been saved.
---

Hi, to tweet, please enter your username:
Spike

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
---

timeline
18/04/2016 07:46:55 @Spike said 'Coding is cool!'
18/04/2016 07:47:04 @Spike said ‘clean code’s the best book ever!'
18/04/2016 07:47:04 @Leo said ‘I love php!!!'
18/04/2016 07:47:18 @Spike said 'What would Thoughtbot do?'
```

## If I had more time:
 * extract responsibilities out of the Twitter class
 * test the Twitter class and any extracted class/classes

