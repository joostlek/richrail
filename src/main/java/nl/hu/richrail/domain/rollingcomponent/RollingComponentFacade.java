//package nl.hu.richrail.domain.rollingcomponent;
//
//import nl.hu.richrail.domain.rollingcomponent.type.LocomotiveBuilder;
//import nl.hu.richrail.domain.rollingcomponent.type.Wagon;
//import nl.hu.richrail.domain.rollingcomponent.type.WagonBuilder;
//import nl.hu.richrail.services.TrainService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class RollingComponentFacade {
//    // TODO: implement DAO
//
//    private List<RollingComponent> rollingComponents = new ArrayList<>();
//
//    private static Logger logger = Logger.getLogger(TrainService.class.getName());
//
//    public RollingComponent getRollingComponent(String id) {
//        for (RollingComponent rollingComponent : rollingComponents) {
//            if (rollingComponent.getId().equalsIgnoreCase(id)) {
//                return rollingComponent.clone();
//            }
//        }
//
//        return null;
//    }
//
//    public List<RollingComponent> getRollingComponents() {
//        return rollingComponents;
//    }
//
//    private boolean createRollingComponent(RollingComponent rollingComponent) {
//        if (rollingComponents.contains(rollingComponent)) {
//            return false;
//        }
//
//        if (rollingComponents.add(rollingComponent)) {
//            logger.log(Level.INFO, "Created rollingcomponent: " + rollingComponent.toString());
//            return true;
//        }
//
//        return false;
//    }
//
//    public boolean createRollingComponentLocomotive(String id) {
//        String imagePath = "";
//
//        if (id == null) {
//            return false;
//        }
//
//        LocomotiveBuilder locomotiveBuilder = new LocomotiveBuilder(id, imagePath);
//
//        return createRollingComponent(locomotiveBuilder.build());
//    }
//
//    public boolean createRollingComponentWagon(String id, int numSeats) {
//        String imagePath = "";
//
//        if (id == null) {
//            return false;
//        }
//
//        WagonBuilder wagonBuilder = new WagonBuilder(id, imagePath);
//
//        wagonBuilder.setNumSeats(numSeats);
//
//        return createRollingComponent(wagonBuilder.build());
//    }
//
//    public boolean removeRollingComponent(String id) {
//        RollingComponent rollingComponent = getRollingComponent(id);
//
//        if (rollingComponents.remove(rollingComponent)) {
//            logger.log(Level.INFO, "Romoved rollingcomponent: " + rollingComponent.toString());
//            return true;
//        }
//
//        return false;
//    }
//
//    public String getRollingComponentsString() {
//        StringBuilder stringBuilder = new StringBuilder("rollingcomponents\n");
//
//        for (RollingComponent rollingComponent : rollingComponents) {
//            stringBuilder.append("(" + rollingComponent.getId() + (rollingComponent instanceof Wagon ? ": " + ((Wagon) rollingComponent).getSeats() : "") + ")\n");
//        }
//
//        return stringBuilder.toString();
//    }
//}
