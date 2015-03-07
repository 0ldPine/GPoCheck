package util.file;

public class File {

    private String path;
    private Object contents;

    private File() {

    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     *            the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return new java.io.File(path).getName();
    }

    /**
     * @return the contents
     */
    public Object getContents() {
        return contents;
    }

    /**
     * @param contents
     *            the contents to set
     */
    public void setContents(Object contents) {
        this.contents = contents;
    }

    public static File readBytesFromFile(String path) {
        File file = new File();
        file.setPath(path);
        file.setContents(FileUtilities.fileToBytes(path));
        return file;
    }

    public static File readStringFromFile(String path) {
        File file = new File();
        file.setContents(FileUtilities.fileToString(path));
        file.setPath(path);
        return file;
    }
}
