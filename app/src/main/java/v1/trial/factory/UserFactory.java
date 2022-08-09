package v1.trial.factory;

import v1.trial.entity.user.AdminUser;
import v1.trial.entity.user.BasicUser;
import v1.trial.entity.user.User;
import java.time.LocalDateTime;

public class UserFactory {
    public User getUser(String username, String password, boolean isTimeStampRequired){
        if (isTimeStampRequired){
            LocalDateTime lt
                    = LocalDateTime.now();
            return new BasicUser(username, password, lt);
        }
        else {
            return new AdminUser(username, password);
        }

    }
}
