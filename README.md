slack-sendgrid-integration-example
==================================

This project is an example of how to integrate slack events api with Sendgrid mail apis.
Here we show how for every file comment([link](https://api.slack.com/events/file_comment_added)) posted in slack, we email that immediately to the responsible 
file owner's email address.

Setup
=====

- Create a slack app and get a slack application token as shown at this [link](https://api.slack.com/slack-apps).

- Register at sendgrid and get a sendgrid api key as shown at this [link](https://sendgrid.com/docs/Classroom/Send/How_Emails_Are_Sent/api_keys.html).

- Set the system environment variables **SLACK_TOKEN** and **SENDGRID_API_KEY**.

- Build the app using **mvn clean install**

- Use the maven jetty plugin to start the app **mvn jetty:run**

- Download ngrok from [here](https://ngrok.com/) to expose localhost to the web.

- Run the command **ngrok http 8080** to expose **http://localhost:8080** to web.

- Register this url as a callback url in the slack application and choose the file_comment 
event to be subscribed.

- Install the app to your slack workspace.

Issues
======

In case there are issues please report them to Github issues.