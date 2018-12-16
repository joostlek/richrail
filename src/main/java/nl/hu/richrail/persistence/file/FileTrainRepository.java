package nl.hu.richrail.persistence.file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.memory.repositories.MemoryTrainRepository;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class FileTrainRepository implements TrainRepository, FileOperations {

    private final FileFactory fileFactory;

    private final Gson gson;

    private final TrainRepository trainRepository;

    FileTrainRepository(FileFactory fileFactory, Gson gson) {
        this.fileFactory = fileFactory;
        this.gson = gson;
        this.trainRepository = new MemoryTrainRepository();
        loadFromFile();
    }

    @Override
    public Train saveTrain(Train train) {
        trainRepository.saveTrain(train);
        saveToFile();
        return train;
    }

    @Override
    public void deleteTrain(String key) {
        trainRepository.deleteTrain(key);
        saveToFile();
    }

    @Override
    public Train getTrain(String key) {
        return trainRepository.getTrain(key);
    }

    @Override
    public boolean hasTrain(String key) {
        return trainRepository.hasTrain(key);
    }

    @Override
    public List<Train> getAllTrains() {
        return this.trainRepository.getAllTrains();
    }

    @Override
    public void saveToFile() {
        try {
            String json = this.gson.toJson(trainRepository.getAllTrains());
            FileUtils.writeStringToFile(fileFactory.getTrainsFile(), json, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        try {
            File file = fileFactory.getTrainsFile();
            if (file.exists()) {
                String json = FileUtils.readFileToString(fileFactory.getTrainsFile(), Charset.forName("UTF-8"));
                List<Train> trains = this.gson.fromJson(json, new TypeToken<List<Train>>(){}.getType());
                for (Train train : trains) {
                    this.trainRepository.saveTrain(train);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
