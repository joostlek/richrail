package nl.hu.richrail.utils;

import nl.hu.richrail.domain.Train;
import nl.hu.richrail.domain.rollingcomponent.RollingComponent;
import nl.hu.richrail.domain.rollingcomponent.type.Wagon;

import java.util.Iterator;
import java.util.List;

public class CliUtils {

    private CliUtils() {
    }

    public static String getTrainsString(List<Train> trains) {
        StringBuilder stringBuilder = new StringBuilder("trains\n");

        for (Train train : trains) {
            Iterator<RollingComponent> trainIterator = train.iterator();
            StringBuilder stringBuilderRollingComponents = new StringBuilder();

            stringBuilder.append("(").append(train.getKey()).append(")");

            if (trainIterator.hasNext()) {
                stringBuilder.append("-");
            }

            while (trainIterator.hasNext()) {
                stringBuilderRollingComponents.append("{").append(trainIterator.next().getKey()).append("}");

                if (trainIterator.hasNext()) {
                    stringBuilderRollingComponents.append("-");
                }
            }

            stringBuilder.append(stringBuilderRollingComponents).append("\n");
        }

        return stringBuilder.toString();
    }

    public static String getComponentsString(List<RollingComponent> components) {
        StringBuilder stringBuilder = new StringBuilder("rollingcomponents\n");

        for (RollingComponent component : components) {
            stringBuilder
                    .append("(")
                    .append(component.getKey())
                    .append(component instanceof Wagon ? ": " + component.getSeats() : "")
                    .append(")\n");
        }

        return stringBuilder.toString();
    }

}
