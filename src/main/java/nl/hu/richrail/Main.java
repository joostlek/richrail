package nl.hu.richrail;

import com.typesafe.config.ConfigFactory;
import nl.hu.richrail.application.ApplicationPicker;
import nl.hu.richrail.persistence.StorageMethod;
import nl.hu.richrail.persistence.StorageMethodFactory;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Settings settings = new Settings(ConfigFactory.load());

        StorageMethodFactory storageMethodFactory = new StorageMethodFactory(settings);
        StorageMethod storageMethod = storageMethodFactory.create();

        SwingUtilities.invokeLater(() -> new ApplicationPicker(storageMethod).createAndShow());
    }

}
