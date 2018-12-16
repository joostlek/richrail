package nl.hu.richrail.persistence.file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import nl.hu.richrail.domain.Train;
import nl.hu.richrail.persistence.TrainRepository;
import nl.hu.richrail.persistence.file.dao.FileTrain;
import nl.hu.richrail.persistence.memory.repositories.MemoryTrainRepository;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
            // Get all trains.
            List<Train> trains = trainRepository.getAllTrains();

            // Map trains to a DAO.
            FileTrain[] fileTrains = trains.stream().map(train -> {
                FileTrain fileTrain = new FileTrain();
                fileTrain.key = train.getKey();
                return fileTrain;
            }).toArray(FileTrain[]::new);

            // Store trains.
            String json = this.gson.toJson(fileTrains);

            FileUtils.writeStringToFile(fileFactory.getTrainsFile(), json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile() {
        try {
            // Check if file exists.
            File file = fileFactory.getTrainsFile();
            if (file.exists()) {
                // Read trains.
                String json = FileUtils.readFileToString(fileFactory.getTrainsFile(), StandardCharsets.UTF_8);
                List<FileTrain> trains = this.gson.fromJson(json, new TypeToken<List<FileTrain>>(){}.getType());

                // Store trains in memory.
                for (FileTrain train : trains) {
                    this.trainRepository.saveTrain(new Train(train.key));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
