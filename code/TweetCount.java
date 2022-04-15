import java.util.Objects;

/**
 * This object represents the count of tweets by a specific
 * Twitter user.
 * 
 * @author Mark Hancock
 *
 */
public class TweetCount implements Comparable<TweetCount> {
	
	
	@Override
	public int compareTo(TweetCount o) {
		// swap the 2 parameters to the integer.compare around to get the max first
	    return Integer.compare(o.getCount(), this.getCount());
	}
	
	// override to string method to fit output of list of top 20 tweets
	@Override
	public String toString() {
		String result = screenName + " had " + count + " tweets";
		return result;
	}
	
    /**
     * The screen name of the Twitter user.
     */
    private String screenName;

    /**
     * The count of tweets by the user.
     */
    private int count;

    /**
     * Creates a new TweetCount object with the given screen
     * name and count.
     * 
     * @param screenName the screen name of the user
     * @param count      the initial count of tweets by that
     *                   user.
     */
    public TweetCount(String screenName, int count) {
        this.screenName = screenName;
        this.count = count;
    }

    /**
     * Returns the screen name of the Twitter user.
     * 
     * @return the screen name of the Twitter user.
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     * Returns the count of tweets by this user.
     * 
     * @return the count of tweets by this user.
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments the count of tweets by this user.
     */
    public void increment() {
        count++;
    }

    /**
     * Checks for equality of this TweetCount with another.
     */
    @Override
    public boolean equals(Object other) {
        // Source:
        // https://www.sitepoint.com/implement-javas-equals-method-correctly/
        // self check
        if (this == other)
            return true;

        // null check
        if (other == null)
            return false;

        // type check and cast
        if (getClass() != other.getClass())
            return false;

        TweetCount count = (TweetCount) other;

        // field comparison (only check degree for equality)
        return Objects.equals(screenName, count.screenName);
    }

    /**
     * Ensures that using a HashMap or HashSet on TweetCount
     * objects uses the screen name.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(screenName);
    }
}
