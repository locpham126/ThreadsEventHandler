public class EventListener extends Thread {

    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = EventTracker.getInstance();
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    public void run() {
        do {
            if (shouldReply()) {
                reply();
            }
        }while(!readyToQuit());
    }

    public Boolean readyToQuit() {
        return messageToListenFor.equals("quit");
    }

    public Boolean shouldReply() {
        return messageToListenFor != null;
    }

    public void reply() {
        System.out.println(messageToReplyWith);
    }
}