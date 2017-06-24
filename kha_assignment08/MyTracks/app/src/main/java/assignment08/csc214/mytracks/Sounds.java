package assignment08.csc214.mytracks;

/**
 * Created by Tkha on 6/24/17.
 */

public class Sounds {

    private final String mPath;
    private final String mSound;
    private Integer mId;

    public Sounds(String path, String sound) {
        mPath = path;
        mSound = sound;
    }

    public String getPath() {
        return mPath;
    }

    public String getSoundName() {
        return mSound;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

}
