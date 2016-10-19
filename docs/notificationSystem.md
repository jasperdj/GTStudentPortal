
abstract class EmailNotificationRecruiter {
  void postEmailAction();
}

class EmailNotificationRecruiters extends EmailNotificationRecruiter {
  subject: Varchar(255)
  content: Text
  when: LocalDateTime
  isAnEmailNotification: Boolean
  hasReceivedEmail: Boolean
  hasBeenSeen: Boolean
  postEmailAction();
}

Cronjob every hour, go through all emailNotifications, send email when 
- now > when
- isAnEmailNotification == true;
- hasReceivedEmail == false

Events
- Education edited Student
- Birthday edited student
- Weekly cronjob-> account signup's



# Notifications
- Every week
    - Account signup's
    - (Event signup's)
- Every birthday an email. 
- 1 day before every student comment. 
- 3 months before education. 
