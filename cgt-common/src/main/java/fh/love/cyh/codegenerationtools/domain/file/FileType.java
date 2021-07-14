package fh.love.cyh.codegenerationtools.domain.file;

public enum FileType {
    TXT(".txt"),
    XML(".xml"),
    JAVA(".java"),
    YAML(".yaml"),
    HTML(".html"),
    JS(".js")
    ;

    private String suffix;

    private FileType(String suffix) {
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
