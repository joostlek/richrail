package nl.hu.richrail.persistence.file;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class FileFactory {

    private static final String TRAIN_FILE_NAME = "train.json";

    private static final String COMPONENT_FILE_NAME = "component.json";

    private final FileConfig fileConfig;

    public FileFactory(FileConfig fileConfig) {
        this.fileConfig = fileConfig;
    }

    public File getTrainsFile() {
        return FileUtils.getFile(this.fileConfig.getPath(), TRAIN_FILE_NAME);
    }

    public File getComponentsFile() {
        return FileUtils.getFile(this.fileConfig.getPath(), COMPONENT_FILE_NAME);
    }

}
