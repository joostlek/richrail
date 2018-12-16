package nl.hu.richrail.persistence.file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.memory.repositories.MemoryTrainRepository;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class FileTrainRepository implements TrainRepository {

    private final TrainRepository trainRepository;

    private final FileFactory fileFactory;

    public FileTrainRepository(FileFactory fileFactory, TrainRepository trainRepository) {
        this.fileFactory = fileFactory;
        this.trainRepository = trainRepository;
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

    private void saveToFile() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(trainRepository.getAllTrains());
            FileUtils.writeStringToFile(fileFactory.getTrainsFile(), json, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            Gson gson = new Gson();
            String json = FileUtils.readFileToString(fileFactory.getTrainsFile(), Charset.forName("UTF-8"));
            List<Train> trains = gson.fromJson(json, new TypeToken<List<Train>>(){}.getType());
            for (Train train : trains) {
                this.trainRepository.saveTrain(train);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
