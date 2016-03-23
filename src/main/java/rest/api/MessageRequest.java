package rest.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by denis on 23/03/16.
 */


@XmlRootElement
public class MessageRequest {

    private String oldFileName;
    private String newFileName;
    private String olfFile;
    private String newFile;

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getOlfFile() {
        return olfFile;
    }

    public void setOlfFile(String olfFile) {
        this.olfFile = olfFile;
    }

    public String getNewFile() {
        return newFile;
    }

    public void setNewFile(String newFile) {
        this.newFile = newFile;
    }
}
