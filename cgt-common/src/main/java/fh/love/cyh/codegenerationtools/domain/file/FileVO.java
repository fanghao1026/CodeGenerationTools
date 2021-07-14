package fh.love.cyh.codegenerationtools.domain.file;

public class FileVO {

    private String name;
    private String type;
    private String path;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileVO(String name, String type, String path) {
        this.name = name;
        this.type = type;
        this.path = path;
    }
}
