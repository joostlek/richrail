package nl.hu.richrail.persistence.file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.persistence.ComponentRepository;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FileComponentRepository implements ComponentRepository {

    private final ComponentRepository componentRepository;

    private final FileFactory fileFactory;

    public FileComponentRepository(FileFactory fileFactory, ComponentRepository componentRepository) {
        this.fileFactory = fileFactory;
        this.componentRepository = componentRepository;
        loadFromFile();
    }

    @Override
    public void insertComponent(RollingComponent component) {
        componentRepository.insertComponent(component);
        saveToFile();
    }

    @Override
    public void updateComponentTrainKey(String key, String trainKey) {
        componentRepository.updateComponentTrainKey(key, trainKey);
        saveToFile();
    }

    @Override
    public void removeComponentTrainKey(String key) {
        componentRepository.removeComponentTrainKey(key);
        saveToFile();
    }

    @Override
    public void deleteComponent(String key) {
        componentRepository.deleteComponent(key);
        saveToFile();
    }

    @Override
    public RollingComponent getComponent(String key) {
        return componentRepository.getComponent(key);
    }

    @Override
    public boolean hasComponent(String key) {
        return componentRepository.hasComponent(key);
    }

    @Override
    public List<RollingComponent> getAllComponents() {
        return componentRepository.getAllComponents();
    }

    @Override
    public List<RollingComponent> getComponentsByTrainKey(String key) {
        return componentRepository.getComponentsByTrainKey(key);
    }


    private void saveToFile() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(componentRepository.getAllComponents());
            FileUtils.writeStringToFile(fileFactory.getComponentsFile(), json, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            Gson gson = new Gson();
            String json = FileUtils.readFileToString(fileFactory.getComponentsFile(), Charset.forName("UTF-8"));
            List<RollingComponent> rollingComponents = gson.fromJson(json, new TypeToken<List<RollingComponent>>(){}.getType());
            for (RollingComponent rollingComponent : rollingComponents) {
                this.componentRepository.insertComponent(rollingComponent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
