














abstract class EmailNotificationRecruiter {
  void postEmailAction();
}

Class EmailNotificationRecruiters extends EmailNotificationRecruiter {
  subject: Varchar(255)
  content: Text
  when: LocalDateTime
  isAnEmailNotification: Boolean
  hasReceivedEmail: Boolean
  hasBeenSeen: Boolean
  (override) operation
}

Cronjob every hour, go through all emailNotifications, send email when 
- now > when
- isAnEmailNotification == true;
- hasReceivedEmail == false


# Notifications
- Every week
    - Account signup's
    - Event signup's
- Every birthday an email. 
- 1 day before every student comment. 
- 3 months before education. 


















