package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class UserCounterListener implements HttpSessionListener, HttpSessionAttributeListener {
    private static final AtomicInteger activeUsers = new AtomicInteger(0);

    public static int getActiveUsers() {
        return activeUsers.get();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
         Object user = event.getSession().getAttribute("user");
         if(user != null) {
             activeUsers.decrementAndGet();
         }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName()) && event.getValue() != null) {
            activeUsers.incrementAndGet();
        }
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("user".equals(event.getName()) && event.getValue() != null) {
            activeUsers.decrementAndGet();
        }
    }
}
